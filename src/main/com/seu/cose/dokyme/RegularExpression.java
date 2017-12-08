package com.seu.cose.dokyme;

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
    public String tag;

    public RegularExpression(String re, String tag) {
        this.re = re;
        this.tag = tag;
    }

    public static void main(String[] args) {

    }
}
