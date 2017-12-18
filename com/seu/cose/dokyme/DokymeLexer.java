package com.seu.cose.dokyme;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DokymeLexer {
	private int counter = 0;

	public void printf(String content){
	    System.out.println("["+this.token+"]"+content);
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
					if(ch=='w') {
						state = 1;
					}
					else if(ch=='i') {
						state = 2;
					}
					else if(ch==0x0d) {
						state = 3;
					}
					else {
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
						if(ch=='h') {
							state = 4;
						}
						else {
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
							if(ch=='f') {
								state = 5;
							}
							else {
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
								if(ch==0x0a) {
									state = 6;
								}
								else {
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
									if(ch=='i') {
										state = 7;
									}
									else {
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
												if(ch=='l') {
													state = 8;
												}
												else {
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
													if(ch=='e') {
														state = 9;
													}
													else {
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
														{
															type = endState(lastEndState);
															outputToken();
															if(reachEnd) {
																i = end;
															} else {
																i = end - 1;
															}
															}
															break;
													}
        }

    }

    private String endState(int state) {
        if (debug) {
            System.out.println("[DEBUG] Enter end state:" + state);
        }
		if(state==5){return "IF";}
		if(state==6){return "CRLF";}
		if(state==9){return "WHILE";}
		return "NULL";
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
