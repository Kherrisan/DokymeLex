package com.seu.cose.dokyme;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DokymeLexer {
	private int counter = 0;

	public String parseType(){
	    //this.token是一个String类型的、代表着当前识别出来的字符串的变量。
        return "";
	}
	public String printf(String content){
	    System.out.println("["+this.token+"]"+content);
	    return "";
	}
	public void incrementCounter(){
	    this.counter++;
	}
	public static void main(String[] args) {
	    new DokymeLexer(args);
	}

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
            inChannel.close();
            raFile.close();
            if (outputWriter != null) {
                outputWriter.close();
            }
            System.gc();
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
		startState = 0;
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
			switch (state){
				case 0: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 0);
					}
					if(ch=='8') {
						state = 16;
					}
					else if(ch=='9') {
						state = 17;
					}
					else if(ch=='<') {
						state = 18;
					}
					else if(ch=='=') {
						state = 19;
					}
					else if(ch=='>') {
						state = 20;
					}
					else if(ch=='A') {
						state = 21;
					}
					else if(ch=='B') {
						state = 22;
					}
					else if(ch=='C') {
						state = 23;
					}
					else if(ch=='D') {
						state = 24;
					}
					else if(ch=='E') {
						state = 25;
					}
					else if(ch=='F') {
						state = 26;
					}
					else if(ch=='G') {
						state = 27;
					}
					else if(ch=='H') {
						state = 28;
					}
					else if(ch=='I') {
						state = 29;
					}
					else if(ch=='J') {
						state = 30;
					}
					else if(ch=='K') {
						state = 31;
					}
					else if(ch=='L') {
						state = 32;
					}
					else if(ch=='M') {
						state = 33;
					}
					else if(ch=='N') {
						state = 34;
					}
					else if(ch=='O') {
						state = 35;
					}
					else if(ch=='P') {
						state = 36;
					}
					else if(ch=='Q') {
						state = 37;
					}
					else if(ch=='R') {
						state = 38;
					}
					else if(ch=='S') {
						state = 39;
					}
					else if(ch=='T') {
						state = 40;
					}
					else if(ch=='U') {
						state = 41;
					}
					else if(ch=='V') {
						state = 42;
					}
					else if(ch=='W') {
						state = 43;
					}
					else if(ch=='X') {
						state = 44;
					}
					else if(ch=='Y') {
						state = 45;
					}
					else if(ch=='Z') {
						state = 46;
					}
					else if(ch==']') {
						state = 47;
					}
					else if(ch=='a') {
						state = 48;
					}
					else if(ch=='b') {
						state = 49;
					}
					else if(ch=='c') {
						state = 50;
					}
					else if(ch=='d') {
						state = 51;
					}
					else if(ch=='e') {
						state = 52;
					}
					else if(ch=='f') {
						state = 53;
					}
					else if(ch=='g') {
						state = 54;
					}
					else if(ch=='h') {
						state = 55;
					}
					else if(ch=='i') {
						state = 56;
					}
					else if(ch=='j') {
						state = 57;
					}
					else if(ch=='k') {
						state = 58;
					}
					else if(ch=='l') {
						state = 59;
					}
					else if(ch=='m') {
						state = 60;
					}
					else if(ch=='n') {
						state = 61;
					}
					else if(ch=='o') {
						state = 62;
					}
					else if(ch=='p') {
						state = 63;
					}
					else if(ch=='q') {
						state = 64;
					}
					else if(ch=='r') {
						state = 65;
					}
					else if(ch=='s') {
						state = 66;
					}
					else if(ch=='t') {
						state = 67;
					}
					else if(ch=='u') {
						state = 68;
					}
					else if(ch=='v') {
						state = 69;
					}
					else if(ch=='w') {
						state = 70;
					}
					else if(ch=='x') {
						state = 71;
					}
					else if(ch=='y') {
						state = 72;
					}
					else if(ch=='z') {
						state = 73;
					}
					else if(ch=='{') {
						state = 74;
					}
					else if(ch=='}') {
						state = 75;
					}
					else if(ch=='!') {
						state = 1;
					}
					else if(ch=='"') {
						state = 2;
					}
					else if(ch=='%') {
						state = 3;
					}
					else if(ch=='&') {
						state = 4;
					}
					else if(ch==')') {
						state = 5;
					}
					else if(ch=='.') {
						state = 6;
					}
					else if(ch=='/') {
						state = 7;
					}
					else if(ch=='0') {
						state = 8;
					}
					else if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 1: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 1);
					}
					end = i;
					lastEndState = 1;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 2: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 2);
					}
					end = i;
					lastEndState = 2;
					if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 3: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 3);
					}
					end = i;
					lastEndState = 3;
					if(ch=='=') {
						state = 155;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 4: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 4);
					}
					if(ch=='&') {
						state = 156;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 5: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 5);
					}
					end = i;
					lastEndState = 5;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 6: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 6);
					}
					end = i;
					lastEndState = 6;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 7: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 7);
					}
					end = i;
					lastEndState = 7;
					if(ch=='=') {
						state = 157;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 8: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 8);
					}
					end = i;
					lastEndState = 8;
					if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else if(ch=='8') {
						state = 16;
					}
					else if(ch=='9') {
						state = 17;
					}
					else if(ch=='0') {
						state = 8;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 9: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 9);
					}
					end = i;
					lastEndState = 9;
					if(ch=='0') {
						state = 8;
					}
					else if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else if(ch=='8') {
						state = 16;
					}
					else if(ch=='9') {
						state = 17;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 10: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 10);
					}
					end = i;
					lastEndState = 10;
					if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else if(ch=='8') {
						state = 16;
					}
					else if(ch=='9') {
						state = 17;
					}
					else if(ch=='0') {
						state = 8;
					}
					else if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 11: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 11);
					}
					end = i;
					lastEndState = 11;
					if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else if(ch=='8') {
						state = 16;
					}
					else if(ch=='9') {
						state = 17;
					}
					else if(ch=='0') {
						state = 8;
					}
					else if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 12: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 12);
					}
					end = i;
					lastEndState = 12;
					if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else if(ch=='8') {
						state = 16;
					}
					else if(ch=='9') {
						state = 17;
					}
					else if(ch=='0') {
						state = 8;
					}
					else if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 13: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 13);
					}
					end = i;
					lastEndState = 13;
					if(ch=='8') {
						state = 16;
					}
					else if(ch=='9') {
						state = 17;
					}
					else if(ch=='0') {
						state = 8;
					}
					else if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 14: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 14);
					}
					end = i;
					lastEndState = 14;
					if(ch=='9') {
						state = 17;
					}
					else if(ch=='0') {
						state = 8;
					}
					else if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else if(ch=='8') {
						state = 16;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 15: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 15);
					}
					end = i;
					lastEndState = 15;
					if(ch=='9') {
						state = 17;
					}
					else if(ch=='0') {
						state = 8;
					}
					else if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else if(ch=='8') {
						state = 16;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 16: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 16);
					}
					end = i;
					lastEndState = 16;
					if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else if(ch=='8') {
						state = 16;
					}
					else if(ch=='9') {
						state = 17;
					}
					else if(ch=='0') {
						state = 8;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 17: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 17);
					}
					end = i;
					lastEndState = 17;
					if(ch=='0') {
						state = 8;
					}
					else if(ch=='1') {
						state = 9;
					}
					else if(ch=='2') {
						state = 10;
					}
					else if(ch=='3') {
						state = 11;
					}
					else if(ch=='4') {
						state = 12;
					}
					else if(ch=='5') {
						state = 13;
					}
					else if(ch=='6') {
						state = 14;
					}
					else if(ch=='7') {
						state = 15;
					}
					else if(ch=='8') {
						state = 16;
					}
					else if(ch=='9') {
						state = 17;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 18: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 18);
					}
					end = i;
					lastEndState = 18;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 19: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 19);
					}
					end = i;
					lastEndState = 19;
					if(ch=='=') {
						state = 158;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 20: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 20);
					}
					end = i;
					lastEndState = 20;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 21: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 21);
					}
					end = i;
					lastEndState = 21;
					if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 22: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 22);
					}
					end = i;
					lastEndState = 22;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 23: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 23);
					}
					end = i;
					lastEndState = 23;
					if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 24: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 24);
					}
					end = i;
					lastEndState = 24;
					if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 25: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 25);
					}
					end = i;
					lastEndState = 25;
					if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 26: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 26);
					}
					end = i;
					lastEndState = 26;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 27: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 27);
					}
					end = i;
					lastEndState = 27;
					if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 28: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 28);
					}
					end = i;
					lastEndState = 28;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 29: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 29);
					}
					end = i;
					lastEndState = 29;
					if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 30: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 30);
					}
					end = i;
					lastEndState = 30;
					if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 31: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 31);
					}
					end = i;
					lastEndState = 31;
					if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 32: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 32);
					}
					end = i;
					lastEndState = 32;
					if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 33: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 33);
					}
					end = i;
					lastEndState = 33;
					if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 34: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 34);
					}
					end = i;
					lastEndState = 34;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 35: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 35);
					}
					end = i;
					lastEndState = 35;
					if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 36: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 36);
					}
					end = i;
					lastEndState = 36;
					if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 37: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 37);
					}
					end = i;
					lastEndState = 37;
					if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 38: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 38);
					}
					end = i;
					lastEndState = 38;
					if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 39: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 39);
					}
					end = i;
					lastEndState = 39;
					if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 40: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 40);
					}
					end = i;
					lastEndState = 40;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 41: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 41);
					}
					end = i;
					lastEndState = 41;
					if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 42: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 42);
					}
					end = i;
					lastEndState = 42;
					if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 43: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 43);
					}
					end = i;
					lastEndState = 43;
					if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 44: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 44);
					}
					end = i;
					lastEndState = 44;
					if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 45: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 45);
					}
					end = i;
					lastEndState = 45;
					if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 46: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 46);
					}
					end = i;
					lastEndState = 46;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 47: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 47);
					}
					end = i;
					lastEndState = 47;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 48: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 48);
					}
					end = i;
					lastEndState = 48;
					if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 49: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 49);
					}
					end = i;
					lastEndState = 49;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 221;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 222;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 50: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 50);
					}
					end = i;
					lastEndState = 50;
					if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 223;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 224;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 51: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 51);
					}
					end = i;
					lastEndState = 51;
					if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 52: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 52);
					}
					end = i;
					lastEndState = 52;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 225;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 53: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 53);
					}
					end = i;
					lastEndState = 53;
					if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 226;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 227;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 54: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 54);
					}
					end = i;
					lastEndState = 54;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 55: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 55);
					}
					end = i;
					lastEndState = 55;
					if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 56: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 56);
					}
					end = i;
					lastEndState = 56;
					if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 228;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 229;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 57: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 57);
					}
					end = i;
					lastEndState = 57;
					if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 58: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 58);
					}
					end = i;
					lastEndState = 58;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 59: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 59);
					}
					end = i;
					lastEndState = 59;
					if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 60: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 60);
					}
					end = i;
					lastEndState = 60;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 61: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 61);
					}
					end = i;
					lastEndState = 61;
					if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 62: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 62);
					}
					end = i;
					lastEndState = 62;
					if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 63: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 63);
					}
					end = i;
					lastEndState = 63;
					if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 64: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 64);
					}
					end = i;
					lastEndState = 64;
					if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 65: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 65);
					}
					end = i;
					lastEndState = 65;
					if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 230;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 66: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 66);
					}
					end = i;
					lastEndState = 66;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 231;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 232;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 67: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 67);
					}
					end = i;
					lastEndState = 67;
					if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 68: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 68);
					}
					end = i;
					lastEndState = 68;
					if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 69: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 69);
					}
					end = i;
					lastEndState = 69;
					if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 233;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 70: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 70);
					}
					end = i;
					lastEndState = 70;
					if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 234;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 71: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 71);
					}
					end = i;
					lastEndState = 71;
					if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 72: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 72);
					}
					end = i;
					lastEndState = 72;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 73: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 73);
					}
					end = i;
					lastEndState = 73;
					if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 74: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 74);
					}
					end = i;
					lastEndState = 74;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 75: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 75);
					}
					end = i;
					lastEndState = 75;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 76: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 76);
					}
					if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 77: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 77);
					}
					if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 78: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 78);
					}
					if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 79: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 79);
					}
					if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 80: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 80);
					}
					if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 81: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 81);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 82: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 82);
					}
					if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 83: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 83);
					}
					if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 84: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 84);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 85: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 85);
					}
					if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 86: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 86);
					}
					if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 87: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 87);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 88: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 88);
					}
					if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 89: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 89);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 90: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 90);
					}
					if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 91: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 91);
					}
					if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 92: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 92);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 93: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 93);
					}
					if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 94: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 94);
					}
					if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 95: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 95);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 96: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 96);
					}
					if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 97: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 97);
					}
					if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 98: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 98);
					}
					if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 99: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 99);
					}
					if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 100: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 100);
					}
					if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 101: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 101);
					}
					if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 102: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 102);
					}
					if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 103: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 103);
					}
					if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 104: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 104);
					}
					if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 105: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 105);
					}
					if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 106: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 106);
					}
					if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 107: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 107);
					}
					if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 108: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 108);
					}
					if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 109: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 109);
					}
					if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 110: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 110);
					}
					if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 111: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 111);
					}
					if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 112: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 112);
					}
					if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 113: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 113);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 114: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 114);
					}
					if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 115: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 115);
					}
					if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 116: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 116);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 117: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 117);
					}
					if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 118: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 118);
					}
					if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 119: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 119);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 120: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 120);
					}
					if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 121: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 121);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 122: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 122);
					}
					if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 123: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 123);
					}
					if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 124: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 124);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 125: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 125);
					}
					if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 126: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 126);
					}
					if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 127: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 127);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 128: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 128);
					}
					if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 129: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 129);
					}
					if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 130: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 130);
					}
					if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 131: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 131);
					}
					if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 132: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 132);
					}
					if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 133: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 133);
					}
					if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 134: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 134);
					}
					if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 135: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 135);
					}
					if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 136: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 136);
					}
					if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 137: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 137);
					}
					if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 138: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 138);
					}
					if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 139: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 139);
					}
					if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 140: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 140);
					}
					if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 141: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 141);
					}
					if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 142: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 142);
					}
					if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 143: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 143);
					}
					if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 144: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 144);
					}
					if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 145: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 145);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 146: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 146);
					}
					if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 147: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 147);
					}
					if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 148: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 148);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 149: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 149);
					}
					if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 150: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 150);
					}
					if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 151: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 151);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 152: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 152);
					}
					if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 153: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 153);
					}
					if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 154: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 154);
					}
					if(ch=='7') {
						state = 91;
					}
					else if(ch=='8') {
						state = 92;
					}
					else if(ch=='9') {
						state = 93;
					}
					else if(ch==':') {
						state = 94;
					}
					else if(ch==';') {
						state = 95;
					}
					else if(ch=='?') {
						state = 96;
					}
					else if(ch=='@') {
						state = 97;
					}
					else if(ch=='A') {
						state = 98;
					}
					else if(ch=='B') {
						state = 99;
					}
					else if(ch=='C') {
						state = 100;
					}
					else if(ch=='D') {
						state = 101;
					}
					else if(ch=='E') {
						state = 102;
					}
					else if(ch=='F') {
						state = 103;
					}
					else if(ch=='G') {
						state = 104;
					}
					else if(ch=='H') {
						state = 105;
					}
					else if(ch=='I') {
						state = 106;
					}
					else if(ch=='J') {
						state = 107;
					}
					else if(ch=='K') {
						state = 108;
					}
					else if(ch=='L') {
						state = 109;
					}
					else if(ch=='M') {
						state = 110;
					}
					else if(ch=='N') {
						state = 111;
					}
					else if(ch=='O') {
						state = 112;
					}
					else if(ch=='P') {
						state = 113;
					}
					else if(ch=='Q') {
						state = 114;
					}
					else if(ch=='R') {
						state = 115;
					}
					else if(ch=='S') {
						state = 116;
					}
					else if(ch=='T') {
						state = 117;
					}
					else if(ch=='U') {
						state = 118;
					}
					else if(ch=='V') {
						state = 119;
					}
					else if(ch=='W') {
						state = 120;
					}
					else if(ch=='X') {
						state = 121;
					}
					else if(ch=='Y') {
						state = 122;
					}
					else if(ch=='Z') {
						state = 123;
					}
					else if(ch==']') {
						state = 124;
					}
					else if(ch=='^') {
						state = 125;
					}
					else if(ch=='_') {
						state = 126;
					}
					else if(ch=='a') {
						state = 127;
					}
					else if(ch=='b') {
						state = 128;
					}
					else if(ch=='c') {
						state = 129;
					}
					else if(ch=='d') {
						state = 130;
					}
					else if(ch=='e') {
						state = 131;
					}
					else if(ch=='f') {
						state = 132;
					}
					else if(ch=='g') {
						state = 133;
					}
					else if(ch=='h') {
						state = 134;
					}
					else if(ch=='i') {
						state = 135;
					}
					else if(ch=='j') {
						state = 136;
					}
					else if(ch=='k') {
						state = 137;
					}
					else if(ch=='l') {
						state = 138;
					}
					else if(ch=='m') {
						state = 139;
					}
					else if(ch=='n') {
						state = 140;
					}
					else if(ch=='o') {
						state = 141;
					}
					else if(ch=='p') {
						state = 142;
					}
					else if(ch=='q') {
						state = 143;
					}
					else if(ch=='r') {
						state = 144;
					}
					else if(ch=='s') {
						state = 145;
					}
					else if(ch=='t') {
						state = 146;
					}
					else if(ch=='u') {
						state = 147;
					}
					else if(ch=='v') {
						state = 148;
					}
					else if(ch=='w') {
						state = 149;
					}
					else if(ch=='x') {
						state = 150;
					}
					else if(ch=='y') {
						state = 151;
					}
					else if(ch=='z') {
						state = 152;
					}
					else if(ch=='{') {
						state = 153;
					}
					else if(ch=='}') {
						state = 154;
					}
					else if(ch=='!') {
						state = 76;
					}
					else if(ch=='"') {
						state = 235;
					}
					else if(ch=='#') {
						state = 77;
					}
					else if(ch=='$') {
						state = 78;
					}
					else if(ch=='%') {
						state = 79;
					}
					else if(ch=='&') {
						state = 80;
					}
					else if(ch==')') {
						state = 81;
					}
					else if(ch==',') {
						state = 82;
					}
					else if(ch=='.') {
						state = 83;
					}
					else if(ch=='0') {
						state = 84;
					}
					else if(ch=='1') {
						state = 85;
					}
					else if(ch=='2') {
						state = 86;
					}
					else if(ch=='3') {
						state = 87;
					}
					else if(ch=='4') {
						state = 88;
					}
					else if(ch=='5') {
						state = 89;
					}
					else if(ch=='6') {
						state = 90;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 155: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 155);
					}
					end = i;
					lastEndState = 155;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 156: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 156);
					}
					end = i;
					lastEndState = 156;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 157: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 157);
					}
					end = i;
					lastEndState = 157;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 158: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 158);
					}
					end = i;
					lastEndState = 158;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 159: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 159);
					}
					end = i;
					lastEndState = 159;
					if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 160: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 160);
					}
					end = i;
					lastEndState = 160;
					if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 161: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 161);
					}
					end = i;
					lastEndState = 161;
					if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 162: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 162);
					}
					end = i;
					lastEndState = 162;
					if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 163: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 163);
					}
					end = i;
					lastEndState = 163;
					if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 164: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 164);
					}
					end = i;
					lastEndState = 164;
					if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 165: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 165);
					}
					end = i;
					lastEndState = 165;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 166: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 166);
					}
					end = i;
					lastEndState = 166;
					if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 167: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 167);
					}
					end = i;
					lastEndState = 167;
					if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 168: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 168);
					}
					end = i;
					lastEndState = 168;
					if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 169: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 169);
					}
					end = i;
					lastEndState = 169;
					if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 170: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 170);
					}
					end = i;
					lastEndState = 170;
					if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 171: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 171);
					}
					end = i;
					lastEndState = 171;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 172: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 172);
					}
					end = i;
					lastEndState = 172;
					if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 173: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 173);
					}
					end = i;
					lastEndState = 173;
					if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 174: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 174);
					}
					end = i;
					lastEndState = 174;
					if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 175: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 175);
					}
					end = i;
					lastEndState = 175;
					if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 176: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 176);
					}
					end = i;
					lastEndState = 176;
					if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 177: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 177);
					}
					end = i;
					lastEndState = 177;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 178: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 178);
					}
					end = i;
					lastEndState = 178;
					if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 179: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 179);
					}
					end = i;
					lastEndState = 179;
					if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 180: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 180);
					}
					end = i;
					lastEndState = 180;
					if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 181: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 181);
					}
					end = i;
					lastEndState = 181;
					if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 182: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 182);
					}
					end = i;
					lastEndState = 182;
					if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 183: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 183);
					}
					end = i;
					lastEndState = 183;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 184: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 184);
					}
					end = i;
					lastEndState = 184;
					if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 185: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 185);
					}
					end = i;
					lastEndState = 185;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 186: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 186);
					}
					end = i;
					lastEndState = 186;
					if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 187: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 187);
					}
					end = i;
					lastEndState = 187;
					if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 188: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 188);
					}
					end = i;
					lastEndState = 188;
					if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 189: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 189);
					}
					end = i;
					lastEndState = 189;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 190: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 190);
					}
					end = i;
					lastEndState = 190;
					if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 191: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 191);
					}
					end = i;
					lastEndState = 191;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 192: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 192);
					}
					end = i;
					lastEndState = 192;
					if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 193: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 193);
					}
					end = i;
					lastEndState = 193;
					if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 194: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 194);
					}
					end = i;
					lastEndState = 194;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 195: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 195);
					}
					end = i;
					lastEndState = 195;
					if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 196: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 196);
					}
					end = i;
					lastEndState = 196;
					if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 197: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 197);
					}
					end = i;
					lastEndState = 197;
					if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 198: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 198);
					}
					end = i;
					lastEndState = 198;
					if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 199: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 199);
					}
					end = i;
					lastEndState = 199;
					if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 200: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 200);
					}
					end = i;
					lastEndState = 200;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 201: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 201);
					}
					end = i;
					lastEndState = 201;
					if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 202: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 202);
					}
					end = i;
					lastEndState = 202;
					if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 203: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 203);
					}
					end = i;
					lastEndState = 203;
					if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 204: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 204);
					}
					end = i;
					lastEndState = 204;
					if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 205: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 205);
					}
					end = i;
					lastEndState = 205;
					if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 206: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 206);
					}
					end = i;
					lastEndState = 206;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 207: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 207);
					}
					end = i;
					lastEndState = 207;
					if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 208: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 208);
					}
					end = i;
					lastEndState = 208;
					if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 209: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 209);
					}
					end = i;
					lastEndState = 209;
					if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 210: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 210);
					}
					end = i;
					lastEndState = 210;
					if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 211: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 211);
					}
					end = i;
					lastEndState = 211;
					if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 212: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 212);
					}
					end = i;
					lastEndState = 212;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 213: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 213);
					}
					end = i;
					lastEndState = 213;
					if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 214: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 214);
					}
					end = i;
					lastEndState = 214;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 215: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 215);
					}
					end = i;
					lastEndState = 215;
					if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 216: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 216);
					}
					end = i;
					lastEndState = 216;
					if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 217: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 217);
					}
					end = i;
					lastEndState = 217;
					if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 218: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 218);
					}
					end = i;
					lastEndState = 218;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 219: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 219);
					}
					end = i;
					lastEndState = 219;
					if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 220: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 220);
					}
					end = i;
					lastEndState = 220;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 221: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 221);
					}
					end = i;
					lastEndState = 221;
					if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 236;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 222: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 222);
					}
					end = i;
					lastEndState = 222;
					if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 237;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 223: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 223);
					}
					end = i;
					lastEndState = 223;
					if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 238;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 224: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 224);
					}
					end = i;
					lastEndState = 224;
					if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 239;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 225: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 225);
					}
					end = i;
					lastEndState = 225;
					if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 240;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 226: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 226);
					}
					end = i;
					lastEndState = 226;
					if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 241;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 227: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 227);
					}
					end = i;
					lastEndState = 227;
					if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 242;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 228: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 228);
					}
					end = i;
					lastEndState = 228;
					if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 229: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 229);
					}
					end = i;
					lastEndState = 229;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 243;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 230: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 230);
					}
					end = i;
					lastEndState = 230;
					if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 244;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 231: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 231);
					}
					end = i;
					lastEndState = 231;
					if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 245;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 232: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 232);
					}
					end = i;
					lastEndState = 232;
					if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 246;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 233: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 233);
					}
					end = i;
					lastEndState = 233;
					if(ch=='A') {
						state = 247;
					}
					else if(ch=='B') {
						state = 248;
					}
					else if(ch=='C') {
						state = 249;
					}
					else if(ch=='D') {
						state = 250;
					}
					else if(ch=='E') {
						state = 251;
					}
					else if(ch=='F') {
						state = 252;
					}
					else if(ch=='G') {
						state = 253;
					}
					else if(ch=='H') {
						state = 254;
					}
					else if(ch=='I') {
						state = 255;
					}
					else if(ch=='J') {
						state = 256;
					}
					else if(ch=='K') {
						state = 257;
					}
					else if(ch=='L') {
						state = 258;
					}
					else if(ch=='M') {
						state = 259;
					}
					else if(ch=='N') {
						state = 260;
					}
					else if(ch=='O') {
						state = 261;
					}
					else if(ch=='P') {
						state = 262;
					}
					else if(ch=='Q') {
						state = 263;
					}
					else if(ch=='R') {
						state = 264;
					}
					else if(ch=='S') {
						state = 265;
					}
					else if(ch=='T') {
						state = 266;
					}
					else if(ch=='U') {
						state = 267;
					}
					else if(ch=='V') {
						state = 268;
					}
					else if(ch=='W') {
						state = 269;
					}
					else if(ch=='X') {
						state = 270;
					}
					else if(ch=='Y') {
						state = 271;
					}
					else if(ch=='Z') {
						state = 272;
					}
					else if(ch=='a') {
						state = 273;
					}
					else if(ch=='b') {
						state = 274;
					}
					else if(ch=='c') {
						state = 275;
					}
					else if(ch=='d') {
						state = 276;
					}
					else if(ch=='e') {
						state = 277;
					}
					else if(ch=='f') {
						state = 278;
					}
					else if(ch=='g') {
						state = 279;
					}
					else if(ch=='h') {
						state = 280;
					}
					else if(ch=='i') {
						state = 281;
					}
					else if(ch=='j') {
						state = 282;
					}
					else if(ch=='k') {
						state = 283;
					}
					else if(ch=='l') {
						state = 284;
					}
					else if(ch=='m') {
						state = 285;
					}
					else if(ch=='n') {
						state = 286;
					}
					else if(ch=='o') {
						state = 287;
					}
					else if(ch=='p') {
						state = 288;
					}
					else if(ch=='q') {
						state = 289;
					}
					else if(ch=='r') {
						state = 290;
					}
					else if(ch=='s') {
						state = 291;
					}
					else if(ch=='t') {
						state = 292;
					}
					else if(ch=='u') {
						state = 293;
					}
					else if(ch=='v') {
						state = 294;
					}
					else if(ch=='w') {
						state = 295;
					}
					else if(ch=='x') {
						state = 296;
					}
					else if(ch=='y') {
						state = 297;
					}
					else if(ch=='z') {
						state = 298;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 234: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 234);
					}
					end = i;
					lastEndState = 234;
					if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 299;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 235: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 235);
					}
					end = i;
					lastEndState = 235;
					{
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 236: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 236);
					}
					end = i;
					lastEndState = 236;
					if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 300;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 237: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 237);
					}
					end = i;
					lastEndState = 237;
					if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 301;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 238: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 238);
					}
					end = i;
					lastEndState = 238;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 302;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 239: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 239);
					}
					end = i;
					lastEndState = 239;
					if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 303;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 240: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 240);
					}
					end = i;
					lastEndState = 240;
					if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 304;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 241: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 241);
					}
					end = i;
					lastEndState = 241;
					if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 305;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 242: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 242);
					}
					end = i;
					lastEndState = 242;
					if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 243: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 243);
					}
					end = i;
					lastEndState = 243;
					if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 244: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 244);
					}
					end = i;
					lastEndState = 244;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 214;
					}
					else if(ch=='u') {
						state = 306;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 245: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 245);
					}
					end = i;
					lastEndState = 245;
					if(ch=='z') {
						state = 220;
					}
					else if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 307;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 246: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 246);
					}
					end = i;
					lastEndState = 246;
					if(ch=='0') {
						state = 159;
					}
					else if(ch=='1') {
						state = 160;
					}
					else if(ch=='2') {
						state = 161;
					}
					else if(ch=='3') {
						state = 162;
					}
					else if(ch=='4') {
						state = 163;
					}
					else if(ch=='5') {
						state = 164;
					}
					else if(ch=='6') {
						state = 165;
					}
					else if(ch=='7') {
						state = 166;
					}
					else if(ch=='8') {
						state = 167;
					}
					else if(ch=='9') {
						state = 168;
					}
					else if(ch=='A') {
						state = 169;
					}
					else if(ch=='B') {
						state = 170;
					}
					else if(ch=='C') {
						state = 171;
					}
					else if(ch=='D') {
						state = 172;
					}
					else if(ch=='E') {
						state = 173;
					}
					else if(ch=='F') {
						state = 174;
					}
					else if(ch=='G') {
						state = 175;
					}
					else if(ch=='H') {
						state = 176;
					}
					else if(ch=='I') {
						state = 177;
					}
					else if(ch=='J') {
						state = 178;
					}
					else if(ch=='K') {
						state = 179;
					}
					else if(ch=='L') {
						state = 180;
					}
					else if(ch=='M') {
						state = 181;
					}
					else if(ch=='N') {
						state = 182;
					}
					else if(ch=='O') {
						state = 183;
					}
					else if(ch=='P') {
						state = 184;
					}
					else if(ch=='Q') {
						state = 185;
					}
					else if(ch=='R') {
						state = 186;
					}
					else if(ch=='S') {
						state = 187;
					}
					else if(ch=='T') {
						state = 188;
					}
					else if(ch=='U') {
						state = 189;
					}
					else if(ch=='V') {
						state = 190;
					}
					else if(ch=='W') {
						state = 191;
					}
					else if(ch=='X') {
						state = 192;
					}
					else if(ch=='Y') {
						state = 193;
					}
					else if(ch=='Z') {
						state = 194;
					}
					else if(ch=='a') {
						state = 195;
					}
					else if(ch=='b') {
						state = 196;
					}
					else if(ch=='c') {
						state = 197;
					}
					else if(ch=='d') {
						state = 198;
					}
					else if(ch=='e') {
						state = 199;
					}
					else if(ch=='f') {
						state = 200;
					}
					else if(ch=='g') {
						state = 201;
					}
					else if(ch=='h') {
						state = 202;
					}
					else if(ch=='i') {
						state = 203;
					}
					else if(ch=='j') {
						state = 204;
					}
					else if(ch=='k') {
						state = 205;
					}
					else if(ch=='l') {
						state = 206;
					}
					else if(ch=='m') {
						state = 207;
					}
					else if(ch=='n') {
						state = 208;
					}
					else if(ch=='o') {
						state = 209;
					}
					else if(ch=='p') {
						state = 210;
					}
					else if(ch=='q') {
						state = 211;
					}
					else if(ch=='r') {
						state = 212;
					}
					else if(ch=='s') {
						state = 213;
					}
					else if(ch=='t') {
						state = 308;
					}
					else if(ch=='u') {
						state = 215;
					}
					else if(ch=='v') {
						state = 216;
					}
					else if(ch=='w') {
						state = 217;
					}
					else if(ch=='x') {
						state = 218;
					}
					else if(ch=='y') {
						state = 219;
					}
					else if(ch=='z') {
						state = 220;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 247: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 247);
					}
					end = i;
					lastEndState = 247;
					if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 248: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 248);
					}
					end = i;
					lastEndState = 248;
					if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 249: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 249);
					}
					end = i;
					lastEndState = 249;
					if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 250: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 250);
					}
					end = i;
					lastEndState = 250;
					if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 251: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 251);
					}
					end = i;
					lastEndState = 251;
					if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 252: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 252);
					}
					end = i;
					lastEndState = 252;
					if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 253: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 253);
					}
					end = i;
					lastEndState = 253;
					if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 254: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 254);
					}
					end = i;
					lastEndState = 254;
					if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 255: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 255);
					}
					end = i;
					lastEndState = 255;
					if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 256: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 256);
					}
					end = i;
					lastEndState = 256;
					if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 257: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 257);
					}
					end = i;
					lastEndState = 257;
					if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 258: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 258);
					}
					end = i;
					lastEndState = 258;
					if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 259: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 259);
					}
					end = i;
					lastEndState = 259;
					if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 260: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 260);
					}
					end = i;
					lastEndState = 260;
					if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 261: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 261);
					}
					end = i;
					lastEndState = 261;
					if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 262: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 262);
					}
					end = i;
					lastEndState = 262;
					if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 263: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 263);
					}
					end = i;
					lastEndState = 263;
					if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 264: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 264);
					}
					end = i;
					lastEndState = 264;
					if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 265: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 265);
					}
					end = i;
					lastEndState = 265;
					if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 266: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 266);
					}
					end = i;
					lastEndState = 266;
					if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 267: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 267);
					}
					end = i;
					lastEndState = 267;
					if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 268: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 268);
					}
					end = i;
					lastEndState = 268;
					if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 269: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 269);
					}
					end = i;
					lastEndState = 269;
					if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 270: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 270);
					}
					end = i;
					lastEndState = 270;
					if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 271: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 271);
					}
					end = i;
					lastEndState = 271;
					if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 272: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 272);
					}
					end = i;
					lastEndState = 272;
					if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 273: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 273);
					}
					end = i;
					lastEndState = 273;
					if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 274: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 274);
					}
					end = i;
					lastEndState = 274;
					if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 275: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 275);
					}
					end = i;
					lastEndState = 275;
					if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 276: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 276);
					}
					end = i;
					lastEndState = 276;
					if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 277: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 277);
					}
					end = i;
					lastEndState = 277;
					if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 278: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 278);
					}
					end = i;
					lastEndState = 278;
					if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 279: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 279);
					}
					end = i;
					lastEndState = 279;
					if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 280: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 280);
					}
					end = i;
					lastEndState = 280;
					if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 281: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 281);
					}
					end = i;
					lastEndState = 281;
					if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 282: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 282);
					}
					end = i;
					lastEndState = 282;
					if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 283: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 283);
					}
					end = i;
					lastEndState = 283;
					if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 284: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 284);
					}
					end = i;
					lastEndState = 284;
					if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 285: 
					if(debug) {
						System.out.println("[DEBUG] Enter state:" + 285);
					}
					end = i;
					lastEndState = 285;
					if(ch=='0') {
						state = 309;
					}
					else if(ch=='1') {
						state = 310;
					}
					else if(ch=='2') {
						state = 311;
					}
					else if(ch=='3') {
						state = 312;
					}
					else if(ch=='4') {
						state = 313;
					}
					else if(ch=='5') {
						state = 314;
					}
					else if(ch=='6') {
						state = 315;
					}
					else if(ch=='7') {
						state = 316;
					}
					else if(ch=='8') {
						state = 317;
					}
					else if(ch=='9') {
						state = 318;
					}
					else if(ch=='A') {
						state = 319;
					}
					else if(ch=='B') {
						state = 320;
					}
					else if(ch=='C') {
						state = 321;
					}
					else if(ch=='D') {
						state = 322;
					}
					else if(ch=='E') {
						state = 323;
					}
					else if(ch=='F') {
						state = 324;
					}
					else if(ch=='G') {
						state = 325;
					}
					else if(ch=='H') {
						state = 326;
					}
					else if(ch=='I') {
						state = 327;
					}
					else if(ch=='J') {
						state = 328;
					}
					else if(ch=='K') {
						state = 329;
					}
					else if(ch=='L') {
						state = 330;
					}
					else if(ch=='M') {
						state = 331;
					}
					else if(ch=='N') {
						state = 332;
					}
					else if(ch=='O') {
						state = 333;
					}
					else if(ch=='P') {
						state = 334;
					}
					else if(ch=='Q') {
						state = 335;
					}
					else if(ch=='R') {
						state = 336;
					}
					else if(ch=='S') {
						state = 337;
					}
					else if(ch=='T') {
						state = 338;
					}
					else if(ch=='U') {
						state = 339;
					}
					else if(ch=='V') {
						state = 340;
					}
					else if(ch=='W') {
						state = 341;
					}
					else if(ch=='X') {
						state = 342;
					}
					else if(ch=='Y') {
						state = 343;
					}
					else if(ch=='Z') {
						state = 344;
					}
					else if(ch=='a') {
						state = 345;
					}
					else if(ch=='b') {
						state = 346;
					}
					else if(ch=='c') {
						state = 347;
					}
					else if(ch=='d') {
						state = 348;
					}
					else if(ch=='e') {
						state = 349;
					}
					else if(ch=='f') {
						state = 350;
					}
					else if(ch=='g') {
						state = 351;
					}
					else if(ch=='h') {
						state = 352;
					}
					else if(ch=='i') {
						state = 353;
					}
					else if(ch=='j') {
						state = 354;
					}
					else if(ch=='k') {
						state = 355;
					}
					else if(ch=='l') {
						state = 356;
					}
					else if(ch=='m') {
						state = 357;
					}
					else if(ch=='n') {
						state = 358;
					}
					else if(ch=='o') {
						state = 359;
					}
					else if(ch=='p') {
						state = 360;
					}
					else if(ch=='q') {
						state = 361;
					}
					else if(ch=='r') {
						state = 362;
					}
					else if(ch=='s') {
						state = 363;
					}
					else if(ch=='t') {
						state = 364;
					}
					else if(ch=='u') {
						state = 365;
					}
					else if(ch=='v') {
						state = 366;
					}
					else if(ch=='w') {
						state = 367;
					}
					else if(ch=='x') {
						state = 368;
					}
					else if(ch=='y') {
						state = 369;
					}
					else if(ch=='z') {
						state = 370;
					}
					else {
						if(start == end) {
							tokenBuffer.remove(0);
							start++;
							break;
						}
						type = endState(lastEndState);
						outputToken();
						if(reachEnd) {
							i = end;
						} else {
							i = end - 1;
						}
					}
					break;
				case 286: 
					if(debug) {
					}