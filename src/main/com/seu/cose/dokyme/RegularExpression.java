package com.seu.cose.dokyme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zdksc on 2017/12/7.
 */
public class RegularExpression {
    public static HashMap<Character, Integer> operators;

    static {
        operators = new HashMap<>();
        operators.put('(', 10);
        operators.put('[', 10);
        operators.put('*', 3);
        operators.put('+', 3);
        operators.put('|', 1);
        operators.put('-', 3);
        operators.put('~', 2);
    }

    public String re;
    public String action;

    public RegularExpression(String re, String action) {
        this.re = re;
        this.action = action;
    }

    public static RegularExpression mock() {
//        DokymeLexFile monitor = DokymeLexFile.mock();
//        FileReader reFile = new FileReader("input.txt");
//        return monitor.parseRELine(reFile.readline());
        return null;
    }

    public static List<RegularExpression> mocks() {
        DokymeLexFile dokymeLexFile = DokymeLexFile.mock();
        List<RegularExpression> res = new ArrayList<>();
//        FileReader reFile = new FileReader("input.txt");
//        String line;
//        while ((line = reFile.readline()) != null) {
//            res.add(dokymeLexFile.parseRELine(line));
//        }
        return res;
    }

    public static void main(String[] args) {

    }
}
