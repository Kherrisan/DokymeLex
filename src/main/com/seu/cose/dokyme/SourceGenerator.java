package com.seu.cose.dokyme;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by zdksc on 2017/12/9.
 */
public class SourceGenerator {
    private FileReader reader;
    private FileWriter writer;
    private DefiniteAutomation dfa;
    private int contextIndent;
    private DokymeLexFile lexFile;

    public SourceGenerator(FileWriter writer, DefiniteAutomation dfa, DokymeLexFile lexFile) {
        this.writer = writer;
        this.dfa = dfa;
        this.lexFile = lexFile;
    }

    private void buildAllStatesFunctions() {
        for (State state : dfa.graph.getVertices()) {
            buildFunction(state);
        }
    }

    private void buildNestedSwitchBlock(Set<Transition> trans) {
        writeLineWithIndents("switch(ch){");
        contextIndent++;
        for (Transition tran : trans) {
            if (tran.tag.equals('\n')) {
                writeLineWithIndents("case 0x0d:state = " + dfa.graph.getDest(tran).id + ";break;");
            } else if (tran.tag.equals('\r')) {
                writeLineWithIndents("case 0x0a:state = " + dfa.graph.getDest(tran).id + ";break;");
            } else {
                writeLineWithIndents("case 0x0d:state = " + dfa.graph.getDest(tran).id + ";break;");
            }
        }
        writeLineWithIndents("default:");
        contextIndent++;
        writeLineWithIndents("if(start == end) {tokenBuffer.remove(0);start++;return;}");
        writeLineWithIndents("type = endState(lastEndState);outputToken();");
        writeLineWithIndents("if(reachEnd) {i = end;} else {i = end - 1;}");
        contextIndent--;
        contextIndent--;
        writeLineWithIndents("}");
    }

    private void buildFunction(State state) {
        writeLineWithIndents("private void stateFunction_" + state.id + "(byte ch) throws IOException {");
        contextIndent++;
        writeLineWithIndents("if(debug) {System.out.println(\"[DEBUG] Enter state:\" + " + state.id + ");}");
        if (dfa.endStates.contains(state)) {
            writeLineWithIndents("end = i;lastEndState = " + state.id + ";");
        }
        boolean firstIf = true;
        for (Transition trans : dfa.graph.getOutEdges(state)) {
            if (firstIf) {
                buildIfBlock(trans, false);
                firstIf = false;
            } else {
                buildIfBlock(trans, true);
            }
        }
        if (dfa.graph.getOutEdges(state).isEmpty()) {
            writeLineWithIndents("{");
        } else {
            writeLineWithIndents("else {");
        }
        contextIndent++;
        writeLineWithIndents("if(start == end) {tokenBuffer.remove(0);start++;return;}");
        writeLineWithIndents("type = endState(lastEndState);outputToken();");
        writeLineWithIndents("if(reachEnd) {i = end;} else {i = end - 1;}");
        writeLineWithIndents("}");
        contextIndent--;
        contextIndent--;
        writeLineWithIndents("}");
    }

    private void buildSwitchBlock() {
        writeLineWithIndents("switch (state){");
        for (State state : dfa.graph.getVertices()) {
            buildCaseBlock(state);
        }
        writeLineWithIndents("}");
        writer.flush();
    }

    private void buildCaseBlock(State state) {
        contextIndent++;
        writeLineWithIndents("case " + state.id + ": ");
        contextIndent++;
        writeLineWithIndents("stateFunction_" + state.id + "(ch);");
        writeLineWithIndents("break;");
        contextIndent--;
        contextIndent--;
    }

    private void buildIfBlock(Transition trans, boolean uElse) {
        String elseIf;
        if (uElse) {
            elseIf = "else ";
        } else {
            elseIf = "";
        }
        if (trans.tag.equals('\n')) {
            writeLineWithIndents(elseIf + "if(ch==0x0d) {state = " + dfa.graph.getDest(trans).id + ";}");
        } else if (trans.tag.equals('\r')) {
            writeLineWithIndents(elseIf + "if(ch==0x0a) {state = " + dfa.graph.getDest(trans).id + ";}");
        } else {
            writeLineWithIndents(elseIf + "if(ch=='" + trans.tag + "') {state = " + dfa.graph.getDest(trans).id + ";}");
        }
    }

    private void buildStartState() {
        writeLineWithIndents("startState = " + dfa.start.id + ";");
    }

    /**
     *
     */
    private void buildDeclarations() {
        for (String decl : lexFile.getDelcarations()) {
            writeLineWithIndents(decl);
        }
    }

    /**
     *
     */
    private void buildFunctions() {
        for (String func : lexFile.getPrograms()) {
            writeLineWithIndents(func);
        }
    }

    /**
     *
     */
    private void buildEndStates() {
        for (State end : dfa.endStates) {
            writeLineWithIndents("if(state==" + end.id + "){" + end.tag + "}");
        }
        writeLineWithIndents("return \"NULL\";");
    }

    /**
     *
     */
    public void dokymeFile() {
        try {
            reader = new FileReader("./DokymeLexer.java");
            String line;
            while ((line = reader.readline()) != null) {
                if (line.contains("//DECLARATIONS")) {
                    adjustIndents(line);
                    buildDeclarations();
                } else if (line.contains("//FUNCTIONS")) {
                    adjustIndents(line);
                    buildFunctions();
                } else if (line.contains("//START_STATE_ID")) {
                    adjustIndents(line);
                    buildStartState();
                } else if (line.contains("//SWITCH_BLOCK_BEGIN")) {
                    adjustIndents(line);
                    buildSwitchBlock();
                } else if (line.contains("//END_STATE")) {
                    adjustIndents(line);
                    buildEndStates();
                } else if (line.contains("//STATE_FUNCTIONS")) {
                    adjustIndents(line);
                    buildAllStatesFunctions();
                } else {
                    //如果没有模板标记字符串，直接写入输出文件中。
                    writeLine(line);
                }
            }
            reader.release();
            writer.flush();
            writer.close();
        } catch (Exception e) {
            Logger.error(e);
        }
    }

    /**
     * @param content
     */
    private void writeLine(String content) {
        writer.writeLine(content);
    }

    /**
     * @param content
     */
    private void writeLineWithIndents(String content) {
        for (int i = 0; i < contextIndent; i++) {
            content = "\t" + content;
        }
        writer.writeLine(content);
    }

    /**
     * @param templateLine
     */
    private void adjustIndents(String templateLine) {
        char[] chars = templateLine.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count++;
            } else {
                break;
            }
        }
        contextIndent = count / 4;
    }

    public static void main(String[] args) {

    }
}
