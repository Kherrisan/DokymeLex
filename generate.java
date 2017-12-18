package com.seu.cose.dokyme;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DokymeLexer {
	private int counter = 0;

	private int counter = 0;

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
		int DOKYME_STATE=84;
        for (int i = 0; i < buf.length; i++) {
            ch = buf[i];
			switch (DOKYME_STATE){
				case 96: 
					end = i;
					lastEndState = 96;
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 97: 
					end = i;
					lastEndState = 97;
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 98: 
					end = i;
					lastEndState = 98;
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 99: 
					end = i;
					lastEndState = 99;
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 86;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 84: 
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					if(ch.equals('%') {
						DOKYME_STATE = 85;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 87;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 88;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 85: 
					end = i;
					lastEndState = 85;
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 86;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 86: 
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 86;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 87: 
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 99;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 86;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 88: 
					end = i;
					lastEndState = 88;
					if(ch.equals('4') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 86;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 89: 
					end = i;
					lastEndState = 89;
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 90: 
					end = i;
					lastEndState = 90;
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 91: 
					end = i;
					lastEndState = 91;
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 92: 
					end = i;
					lastEndState = 92;
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 93: 
					end = i;
					lastEndState = 93;
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 94: 
					end = i;
					lastEndState = 94;
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
				case 95: 
					end = i;
					lastEndState = 95;
					if(ch.equals('0') {
						DOKYME_STATE = 89;
					}
					if(ch.equals('1') {
						DOKYME_STATE = 90;
					}
					if(ch.equals('2') {
						DOKYME_STATE = 91;
					}
					if(ch.equals('3') {
						DOKYME_STATE = 92;
					}
					if(ch.equals('4') {
						DOKYME_STATE = 93;
					}
					if(ch.equals('5') {
						DOKYME_STATE = 94;
					}
					if(ch.equals('6') {
						DOKYME_STATE = 95;
					}
					if(ch.equals('7') {
						DOKYME_STATE = 96;
					}
					if(ch.equals('8') {
						DOKYME_STATE = 97;
					}
					if(ch.equals('9') {
						DOKYME_STATE = 98;
					}
					if(ch.equals('%') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('f') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('i') {
						DOKYME_STATE = 86;
					}
					if(ch.equals('/') {
						DOKYME_STATE = 86;
					}
					else {
						outputToken(line.substring(start, end+1), endState(lastEndState));
					}
					break;
			}
        }
    }

    private String endState(int state) {
        if (debug) {
            System.out.println("[DEBUG] Enter end state:" + state);
        }
		if(state==96){return "CONSTANT";}
		if(state==97){return "CONSTANT";}
		if(state==98){return "CONSTANT";}
		if(state==99){incrementCounter();return "IF";}
		if(state==85){return "MOD";}
		if(state==88){return "DIV";}
		if(state==89){return "CONSTANT";}
		if(state==90){return "CONSTANT";}
		if(state==91){return "CONSTANT";}
		if(state==92){return "CONSTANT";}
		if(state==93){return "CONSTANT";}
		if(state==94){return "CONSTANT";}
		if(state==95){return "CONSTANT";}
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
