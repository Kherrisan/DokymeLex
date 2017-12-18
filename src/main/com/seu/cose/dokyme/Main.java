package com.seu.cose.dokyme;

import java.util.Set;

public class Main {

    public static final boolean DEBUG = true;

    public static void main(String[] args) {
        FileReader dokymeFile = new FileReader("rule.dokyme");
        FileWriter generate = new FileWriter("generate.java");
        DokymeLexFile lexFile = new DokymeLexFile(dokymeFile);
        Set<NoDefiniteAutomation> nfas = lexFile.parseDokymeFile().buildNFAs();
        DefiniteAutomation dfa = DefiniteAutomation.build(nfas);
        SourceGenerator sg = new SourceGenerator(generate, dfa, lexFile);
        sg.dokymeFile();
    }
}
