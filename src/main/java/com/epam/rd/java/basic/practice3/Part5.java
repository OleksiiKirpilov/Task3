package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

    private static final int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final Pattern romansPattern = Pattern.compile("M|CM|D|CD|C|XC|L|XL|X|IX|V|IV|I");

    public static void main(String[] args) {
        System.out.println("Part 5 demo.");
        for (int n = 1; n <= 100; ++n) {
            String r = decimal2Roman(n);
            System.out.printf("%d --> %s --> %d%n", n, r, roman2Decimal(r));
        }
    }

    public static String decimal2Roman(int dec) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < decimalValues.length; ++i) {
            int d = decimalValues[i];
            while (dec >= d) {
                dec -= d;
                out.append(romans[i]);
            }
        }
        return out.toString();
    }

    public static int roman2Decimal(String r) {
        final Matcher matcher = romansPattern.matcher(r);
        final String romanString = "--M-CM--D-CD--C-XC--L-XL--X-IX--V-IV--I-";
        int result = 0;
        while (matcher.find()) {
            Matcher m = Pattern.compile("-(" + matcher.group() + ")-").matcher(romanString);
            m.find();
            result += decimalValues[m.start() / 3];
        }
        return result;
    }

}
