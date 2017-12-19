package com.seu.cose.dokyme;

import java.util.*;

/**
 * Created by zdksc on 2017/12/7.
 */
public class DokymeLexFile {

    private FileReader reFile;
    private Map<String, String> definitions;
    private List<String> delcarations;
    private List<String> programs;
    private List<RegularExpression> rules;
    private int precedence;

    public DokymeLexFile(FileReader reFile) {
        this.reFile = reFile;
        this.definitions = new HashMap<>();
        this.setDelcarations(new ArrayList<>());
        this.rules = new ArrayList<>();
        this.setPrograms(new ArrayList<>());
        precedence = 0;
    }

    public Set<NoDefiniteAutomation> buildNFAs() {
        Set<NoDefiniteAutomation> nfas = new HashSet<>();
        for (RegularExpression re : rules) {
            nfas.add(NoDefiniteAutomation.build(re));
        }
        return nfas;
    }

    public DokymeLexFile parseDokymeFile() {
        try {
            final int definition = 0;
            final int declaration = 1;
            final int rule = 2;
            final int program = 3;
            int state = 0;
            String line;
            while (true) {
                line = this.reFile.readline();
                if (line == null) {
                    return this;
                }
                switch (state) {
                    case definition: {
                        if (line.trim().equals("%%")) {
                            state = declaration;
                        } else {
                            parseDefinitionLine(line);
                        }
                        break;
                    }
                    case declaration: {
                        if (line.trim().equals("%%")) {
                            state = rule;
                        } else {
                            this.getDelcarations().add(line);
                        }
                        break;
                    }
                    case rule: {
                        if (line.trim().equals("%%")) {
                            state = program;
                        } else {
                            parseRuleLine(line);
                        }
                        break;
                    }
                    case program: {
                        this.getPrograms().add(line);
                        break;
                    }
                }
            }
        } catch (DokymeFileFormatException e) {
            Logger.error(e);
        }
        return this;
    }

    public void parseRuleLine(String line) throws DokymeFileFormatException {
        if (line.trim().equals("")) {
            return;
        }
        int actionStart = line.lastIndexOf("{");
        int actionEnd = line.lastIndexOf("}");
        if (actionStart == -1 || actionEnd == -1) {
            throw new DokymeFileFormatException();
        }
        String re = line.substring(0, actionStart).trim();
        String action = line.substring(actionStart + 1, actionEnd);
        for (String def : definitions.keySet()) {
            re = re.replace(def, definitions.get(def));
        }
        RegularExpression rule = new RegularExpression(re, action);
        rule.precedence = precedence++;
        rules.add(rule);
    }

    public void parseDefinitionLine(String line) throws DokymeFileFormatException {
        if (line.trim().equals("")) {
            return;
        }
        int defStart = line.lastIndexOf("{");
        int defEnd = line.lastIndexOf("}");
        if (defStart == -1 || defEnd == -1) {
            throw new DokymeFileFormatException();
        }
        String re = line.substring(0, defStart).trim();
        String tag = line.substring(defStart + 1, defEnd).trim();
        for (String def : definitions.keySet()) {
            re = re.replace(def, definitions.get(def));
        }
        definitions.put(tag, re);
    }

    public static DokymeLexFile mock() {
        return null;
    }

    public static void main(String[] args) {
        mock().parseDokymeFile().buildNFAs();
    }

    public List<String> getDelcarations() {
        return delcarations;
    }

    public void setDelcarations(List<String> delcarations) {
        this.delcarations = delcarations;
    }

    public List<String> getPrograms() {
        return programs;
    }

    public void setPrograms(List<String> programs) {
        this.programs = programs;
    }
}
