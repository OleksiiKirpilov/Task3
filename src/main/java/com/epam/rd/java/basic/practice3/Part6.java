package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        String input = Util.getInput("part6.txt");
        System.out.println("Part6 demo.");
        System.out.println(input);
        System.out.println();
        System.out.println(convert(input));
    }

    public static String convert(String input) {
        Pattern p = Pattern.compile("([A-zА-яЁё]+)");
        Matcher m = p.matcher(input);
        StringBuilder sb = new StringBuilder(input);
        int underscoresCount = 0;
        while (m.find()) {
            if (isRecurring(m.group(), input)) {
                sb.insert(m.start() + underscoresCount++, '_');
            }
        }
        return sb.toString();
    }

    private static boolean isRecurring(String word, String input) {
        Pattern r = Pattern.compile("\\s" + word + "\\s+.*" + word + "\\s", Pattern.DOTALL);
        Matcher m = r.matcher(input);
        return m.find();
    }
}
