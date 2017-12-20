package com.seu.cose.dokyme;

import java.util.Collection;

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

    private void buildNestedSwitchBlock(Collection<Transition> trans) {
        writeLineWithIndents("switch(ch){");
        contextIndent++;
        for (Transition tran : trans) {
            if (tran.tag.equals('\n')) {
                writeLineWithIndents("case 0x0d:state = " + dfa.graph.getDest(tran).id + ";break;");
            } else if (tran.tag.equals('\r')) {
                writeLineWithIndents("case 0x0a:state = " + dfa.graph.getDest(tran).id + ";break;");
            } else {
                writeLineWithIndents("case '" + tran.tag + "':state = " + dfa.graph.getDest(tran).id + ";break;");
            }
        }
        writeLineWithIndents("default:");
        contextIndent++;
        writeLineWithIndents("handlePotentialOutput();");
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
        buildNestedSwitchBlock(dfa.graph.getOutEdges(state));
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
        writeLineWithIndents("switch(state){");
        contextIndent++;
        for (State end : dfa.endStates) {
            writeLineWithIndents("case " + end.id + ":" + end.tag);
        }
        writeLineWithIndents("default:return \"NULL\";");
        contextIndent--;
        writeLineWithIndents("}");
    }

    private void buildPackageInfo() {
        writeLine("package " + Main.packageInfo + ";");
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
                } else if (line.contains("//PACKAGE_INFO")) {
                    buildPackageInfo();
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
