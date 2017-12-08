package com.seu.cose.dokyme;

import java.util.ArrayList;
import java.util.List;

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
        while ((line = reFile.readline()) != null) {
            NoDefiniteAutomation.build(parseRELine(line));
        }
    }

    public void parseTargetFile() {

    }

    private RegularExpression parseRELine(String line) {
        int start = line.indexOf('{');
        int end = line.indexOf('}');
        return new RegularExpression(line.substring(0, start).trim(), line.substring(start + 1, end).trim());
    }
}
