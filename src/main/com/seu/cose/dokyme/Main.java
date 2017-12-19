package com.seu.cose.dokyme;

import java.util.Set;

public class Main {

    public static final boolean DEBUG = true;

    public static void main(String[] args) {
        FileReader dokymeFile = new FileReader("rule.dokyme");
        FileWriter generate = new FileWriter("./src/main/com/seu/cose/dokyme/DokymeLexer.java");
        DokymeLexFile lexFile = new DokymeLexFile(dokymeFile);
        Set<NoDefiniteAutomation> nfas = lexFile.parseDokymeFile().buildNFAs();
        DefiniteAutomation dfa = DefiniteAutomation.build(nfas);
        SourceGenerator sg = new SourceGenerator(generate, dfa, lexFile);
        sg.dokymeFile();
        int i = 1;
        switch (i) {
            case 1:
                System.out.println("1");
            {
                System.out.println("222");
            }
            break;
            default:
                break;
        }
    }
}
