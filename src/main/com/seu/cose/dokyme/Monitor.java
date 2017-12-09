package com.seu.cose.dokyme;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zdksc on 2017/12/7.
 */
public class Monitor {

    private FileReader reFile;
    private FileReader targetFile;

    public Monitor(FileReader reFile, FileReader targetFile) {
        this.reFile = reFile;
        this.targetFile = targetFile;
    }

    public void parseREFile() {
        String line;
        Set<NoDefiniteAutomation> nfas = new HashSet<>();
        while ((line = reFile.readline()) != null) {
            nfas.add(NoDefiniteAutomation.build(parseRELine(line)));
        }
        DefiniteAutomation dfa = DefiniteAutomation.build(nfas);

    }

    public void parseTargetFile() {

    }

    public RegularExpression parseRELine(String line) {
        int start = line.indexOf('{');
        int end = line.indexOf('}');
        return new RegularExpression(line.substring(0, start).trim(), line.substring(start + 1, end).trim());
    }

    public static Monitor mock() {
        FileReader input = new FileReader("input.txt");
        FileReader output = new FileReader("output.txt");
        Monitor monitor = new Monitor(input, output);
        return monitor;
    }

    public static void main(String[] args) {

    }
}
