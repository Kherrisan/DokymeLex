package com.seu.cose.dokyme;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DokymeLexer {
    //DECLARATIONS

    //FUNCTIONS

    private String input;
    private String output;
    private boolean debug = false;
    private BufferedWriter outputWriter;
    private RandomAccessFile raFile;
    private Map<String, Integer> sInnerCode;
    private MappedByteBuffer inputBuffer;
    private int sid;
    private String token;
    private List<Byte> tokenBuffer;
    private String type;
    private int start;
    private int end;
    private int lastEndState;
    private int state;
    private int startState;

    private DokymeLexer(String[] args) {
        parseCmd(args);
        run();
    }

    private void run() {
        sInnerCode = new HashMap<>();
        tokenBuffer = new ArrayList<>();
        try {
            if (output != null) {
                outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
            }
            raFile = new RandomAccessFile(input, "r");
            FileChannel inChannel = raFile.getChannel();
            inputBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, raFile.length());
            parse();
            raFile.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void parse() throws IOException {
        byte ch;
        start = 0;
        end = -1;
        lastEndState = -1;
        //START_STATE_ID
        state = startState;
        boolean reachEnd = false;
        for (int i = 0; i < raFile.length() + 1; i++) {
            if (i < raFile.length()) {
                ch = inputBuffer.get(i);
            } else {
                reachEnd = true;
                ch = 0x21;
            }
            tokenBuffer.add(ch);
            if (debug) {
                System.out.println("[DEBUG] Current character:" + ch);
            }
            //SWITCH_BLOCK_BEGIN
        }

    }

    private String endState(int state) {
        if (debug) {
            System.out.println("[DEBUG] Enter end state:" + state);
        }
        //END_STATE
    }

    private void outputToken() throws IOException {
        Integer scode = sInnerCode.get(type);
        if (scode == null) {
            sInnerCode.put(type, 0);
            scode = 0;
        } else {
            sInnerCode.replace(type, scode + 1);
        }
        byte[] temp = new byte[end - start];
        int index = 0;
        for (int i = 0; i < end - start; i++) {
            temp[i] = tokenBuffer.get(i);
        }
        tokenBuffer.clear();
        token = new String(temp);
        System.out.println("(" + token + "," + type + "," + scode + ")");
        if (outputWriter != null) {
            outputWriter.write("(" + token + "," + type + "," + scode + ")\n");
        }
        state = startState;
        start = end;
    }

    private void parseCmd(String[] args) {
        //解析命令行参数
        //-o 输出文件路径 1
        //-h 帮助 2
        //-v 版本 3
        //-d 显示调试输出 4
        int lastOne = -1;
        if (args.length == 0) {
            System.out.println("Wrong command paramaters.\nTry -h to get help.\n");
            System.exit(0);
        }
        for (String arg : args) {
            if (arg.equals("-o")) {
                lastOne = 1;
            } else if (arg.equals("-h")) {
                System.out.print("Dokyme lexical parser source generator.\nUsage: dokyme.exe [options] <inputFilePath>\n\nOptions:\n\t-o\t<filePath>\n\t\tThe path which the output token file will be generated.\n\t\tNote:If unspecified,the token will only be printed in the console window.\n\t-h\tShow this help document.\n\t-v\tShow version information.\n\t-d\tShow debug output.\n");
                System.exit(0);
            } else if (arg.equals("-v")) {
                System.out.print("Dokyme lexical parser source generator.\nHello World from Southease University Software Academy.\n2017.12.18");
                System.exit(0);
            } else if (arg.equals("-d")) {
                debug = true;
            } else if (lastOne == 1) {
                output = arg;
            } else {
                input = arg;
            }
        }
        if (input == null) {
            System.out.print("Unspecified input file.Try -h to get help.");
            System.exit(1);
        }
    }

//    public static void main(String[] args) {
//        new DokymeLexer(args);
//    }
}
