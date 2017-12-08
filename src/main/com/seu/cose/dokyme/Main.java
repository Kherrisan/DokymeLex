package com.seu.cose.dokyme;

public class Main {

    public static final boolean DEBUG = true;

    public static void main(String[] args) {
        FileReader input = new FileReader("input.txt");
        FileReader output = new FileReader("output.txt");
        Monitor monitor = new Monitor(input, output);
        monitor.parseREFile();
    }
}
