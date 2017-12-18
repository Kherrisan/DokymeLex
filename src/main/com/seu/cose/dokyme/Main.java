package com.seu.cose.dokyme;

<<<<<<< HEAD
import java.util.Set;

=======
>>>>>>> 940d6fa162c4415073f2533050e940dc2271d44b
public class Main {

    public static final boolean DEBUG = true;

    public static void main(String[] args) {
<<<<<<< HEAD
        FileReader dokymeFile = new FileReader("rule.dokyme");
        FileWriter generate = new FileWriter("generate.java");
        DokymeLexFile lexFile = new DokymeLexFile(dokymeFile);
        Set<NoDefiniteAutomation> nfas = lexFile.parseDokymeFile().buildNFAs();
        DefiniteAutomation dfa = DefiniteAutomation.build(nfas);
        SourceGenerator sg = new SourceGenerator(generate, dfa, lexFile);
        sg.dokymeFile();
=======
        FileReader input = new FileReader("input.txt");
        FileReader output = new FileReader("output.txt");
        Monitor monitor = new Monitor(input, output);
        monitor.parseREFile();
>>>>>>> 940d6fa162c4415073f2533050e940dc2271d44b
    }
}
