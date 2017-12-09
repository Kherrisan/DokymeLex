package com.seu.cose.dokyme;

/**
 * Created by zdksc on 2017/12/9.
 */
public class SourceGenerator {
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
    }
}
