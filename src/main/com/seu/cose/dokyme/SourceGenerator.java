package com.seu.cose.dokyme;

/**
 * Created by zdksc on 2017/12/9.
 */
public class SourceGenerator {
<<<<<<< HEAD
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

    private void buildSwitchBlock() {
        writeLineWithIndents("switch (DOKYME_STATE){");
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
        if (dfa.endStates.contains(state)) {
            writeLineWithIndents("end = i;");
            writeLineWithIndents("lastEndState = " + state.id + ";");
        }
        for (Transition trans : dfa.graph.getOutEdges(state)) {
            buildIfBlock(trans);
        }
        writeLineWithIndents("else {");
        contextIndent++;
        writeLineWithIndents("outputToken(line.substring(start, end+1), endState(lastEndState));");
        contextIndent--;
        writeLineWithIndents("}");
        writeLineWithIndents("break;");
        contextIndent--;
        contextIndent--;
    }

    private void buildIfBlock(Transition trans) {
        writeLineWithIndents("if(ch.equals('" + trans.tag + "') {");
        contextIndent++;
        writeLineWithIndents("DOKYME_STATE = " + dfa.graph.getDest(trans).id + ";");
        contextIndent--;
        writeLineWithIndents("}");
    }

    private void buildStartState() {
        writeLineWithIndents("int DOKYME_STATE=" + dfa.start.id + ";");
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
        for (String func : lexFile.getDelcarations()) {
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
    }

    /**
     *
     */
    public void dokymeFile() {
        try {
            reader = new FileReader("template.java");
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

=======
    private FileWriter writer;
    private DefiniteAutomation dfa;

    public SourceGenerator(FileWriter writer, DefiniteAutomation dfa) {
        this.writer = writer;
        this.dfa = dfa;
    }

    public void buildContext() {
        writer.writeLine("int DOKYME_STATE = " + dfa.start.id + ";");
    }

    public void buildSwitchBlock() {
        writer.writeLine("switch (DOKYME_STATE){");
        for (State state : dfa.graph.getVertices()) {
            buildCaseBlock(state);
        }
        writer.writeLine("}");
    }

    public void buildCaseBlock(State state) {
        writer.writeLine("case " + state.id + " : ");
        for (Transition trans : dfa.graph.getOutEdges(state)) {
            buildIfBlock(trans);
        }
        writer.writeLine("break;");
    }

    public void buildIfBlock(Transition trans) {
        writer.writeLine("if(ch.equals('" + trans.tag + "'){");
        writer.writeLine("DOKYME_STATE = " + dfa.graph.getDest(trans).id + ";");
        writer.writeLine("}");
    }

    public static void main(String[] args) {
        FileWriter writer = new FileWriter("gen.java");
        DefiniteAutomation dfa = DefiniteAutomation.mock(true);
        SourceGenerator sg = new SourceGenerator(writer, dfa);
        sg.buildSwitchBlock();
        writer.close();
>>>>>>> 940d6fa162c4415073f2533050e940dc2271d44b
    }
}
