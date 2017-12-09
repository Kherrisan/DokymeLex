package com.seu.cose.dokyme;

import sun.rmi.runtime.Log;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by zdksc on 2017/12/9.
 */
public class FileWriter {
    private String filePath;
    private BufferedWriter output;

    public FileWriter(String filePath) {
        this.filePath = filePath;
        prepareToWrite();
    }

    private boolean prepareToWrite() {
        try {
            output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.filePath)));
            return true;
        } catch (IOException e) {
            Logger.error(e);
            return false;
        }
    }

    public void writeLine(String content) {
        try {
            if (!content.endsWith("\n")) {
                content += "\n";
            }
            output.write(content);
        } catch (IOException e) {
            Logger.error(e);
        }
    }

    public void close() {
        try {
            output.close();
        } catch (IOException e) {
            Logger.error(e);
        }
    }

    public static void main(String[] args) {
        FileWriter writer = new FileWriter("gen.txt");
        writer.writeLine("Hello World");
        writer.close();
    }
}
