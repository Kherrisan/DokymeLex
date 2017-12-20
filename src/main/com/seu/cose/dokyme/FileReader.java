package com.seu.cose.dokyme;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zdksc on 2017/12/6.
 */
public class FileReader {
    private String filePath;
    private BufferedReader input;

    public FileReader(String filePath) {
        this.filePath = filePath;
        prepareToRead();
    }

    private boolean prepareToRead() {
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream(this.filePath)));
            return input.ready();
        } catch (IOException e) {
            Logger.error(e);
            return false;
        }
    }

    public String readline() {
        try {
            return input.readLine();
        } catch (IOException e) {
            Logger.error(e);
            release();
            return null;
        }
    }

    public void release() {
        try {
            if (input != null) {
                input.close();
            }
        } catch (IOException e) {
            Logger.error(e);
        }
    }
}
