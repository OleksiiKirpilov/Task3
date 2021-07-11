package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        final String FILENAME = "part3.txt";
        String textData = Util.getInput(FILENAME);
        System.out.println("Part3 demo.");
        System.out.println("input:");
        System.out.println(textData);
        System.out.println();
        System.out.println("convert:");
        System.out.println(convert(textData));
    }

    public static String convert(String input) {
        Pattern p = Pattern.compile("([A-zА-яЁё]+?)([A-zА-яЁё]{2,})");
        Matcher m = p.matcher(input);
        StringBuilder sb = new StringBuilder(input);
        while (m.find()) {
            char c = sb.charAt(m.start(1));
            c = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
            sb.setCharAt(m.start(1), c);
        }
        return sb.toString();
    }
}
