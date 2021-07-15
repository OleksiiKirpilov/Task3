package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        String input = Util.getInput("part3.txt");
        System.out.println("Part3 demo.");
        System.out.println("in:");
        System.out.println(input);
        System.out.println();
        System.out.println("out:");
        System.out.println(convert(input));
    }

    public static String convert(String input) {
        Pattern p = Pattern.compile("(\\w+?)\\w{2,}", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher(input);
        StringBuilder sb = new StringBuilder(input);
        while (m.find()) {
            char c = sb.charAt(m.start());
            c = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
            sb.setCharAt(m.start(), c);
        }
        return sb.toString();
    }
}
