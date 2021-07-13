package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

    public static void main(String[] args) {
        System.out.println("Part 5 demo.");
        for (int n = 1; n <= 100; ++n) {
            String r = decimal2Roman(n);
            System.out.printf("%d --> %s --> %d%n", n, r, roman2Decimal(r));
        }
    }

    public static String decimal2Roman(int dec) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] decimals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < decimals.length; ++i) {
            int d = decimals[i];
            while (dec >= d) {
                dec -= d;
                out.append(romans[i]);
            }
        }
        return out.toString();
    }

    public static int roman2Decimal(String roman) {
        String[] romans = {"CM", "CD", "XC", "XL", "IX", "IV", "M", "D", "C", "L", "X", "V", "I"};
        int[] decimals = {900, 400, 90, 40, 9, 4, 1000, 500, 100, 50, 10, 5, 1};
        int number = 0;
        StringBuilder r = new StringBuilder(roman);
        for (int i = 0; i < romans.length; ++i) {
            number += processNumber(r, romans[i]) * decimals[i];
        }
        return number;
    }

    private static int processNumber(StringBuilder sb, String roman) {
        int count = 0;
        int index = sb.indexOf(roman);
        while (index != -1) {
            count++;
            sb.delete(index, index + roman.length());
            index = sb.indexOf(roman);
        }
        return count;
    }
}
