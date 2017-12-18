package com.seu.cose.dokyme;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DokymeLexer {
    //DECLARATIONS

    //FUNCTIONS

    private String input;
    private String output;
    private boolean debug = false;
    private BufferedWriter outputWriter;
    private BufferedReader inputReader;
    private Map<String, Integer> sInnerCode;
    private int sid;

    private DokymeLexer(String[] args) {
        parseCmd(args);
    }

    public void parse() {
        sInnerCode = new HashMap<>();
        try {
            if (output != null) {
                outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
            }
            inputReader = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
            String line;
            while ((line = inputReader.readLine()) != null) {
                if (debug) {
                    System.out.println("[DEBUG] Readline(trimed):" + line.trim());
                }
                parseLine(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("o(￣ヘ￣o＃)");
            System.exit(1);
        }
    }

    private void parseLine(String line) {
        char[] buf = line.toCharArray();
        char ch;
        int start = -1;
        int end=-1;
        int lastEndState = -1;
        //START_STATE_ID
        for (int i = 0; i < buf.length; i++) {
            ch = buf[i];
            //SWITCH_BLOCK_BEGIN
        }
    }

    private String endState(int state) {
        if (debug) {
            System.out.println("[DEBUG] Enter end state:" + state);
        }
        //END_STATE
    }

    private String outputToken(String token, String type) throws IOException {
        Integer scode = sInnerCode.get(type);
        if (scode == null) {
            sInnerCode.put(type, 0);
        } else {
            sInnerCode.replace(type, scode + 1);
        }
        System.out.println("<");
        if (outputWriter != null) {
            outputWriter.write("(" + token + "," + type + "," + scode + ")\n");
        }
    }

    private void parseCmd(String[] args) {
        //解析命令行参数
        //-o 输出文件路径 1
        //-h 帮助 2
        //-v 版本 3
        //-d 显示调试输出 4
        int lastOne = -1;
        if (args.length == 0) {
            System.out.println("Wrong command paramaters.\nTry -h to get help.\n（╯－_－）╯╧╧");
            System.exit(0);
        }
        for (String arg : args) {
            if (arg.equals("-o")) {
                lastOne = 1;
            } else if (arg.equals("-h")) {
                System.out.print("Dokyme lexical parser source generator.\nUsage: dokyme.exe [options] <inputFilePath>\n\nOptions:\n\t-o\t<filePath>\n\t\tThe path which the output token file will be generated.\n\t\tNote:If unspecified,the token will only be printed in the console window.\n\t-h\tShow this help document.\n\t-v\tShow version information.\n\t-d\tShow debug output.\n(๑•̀ㅂ•́)و✧\n");
                System.exit(0);
            } else if (arg.equals("-v")) {
                System.out.print("Dokyme lexical parser source generator.\nHello World from Southease University Software Academy.\n2017.12.18\t～(￣▽￣～)(～￣▽￣)～");
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
            System.out.print("Unspecified input file.Try -h to get help.\nw(ﾟДﾟ)w");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new DokymeLexer(args);
    }
}
