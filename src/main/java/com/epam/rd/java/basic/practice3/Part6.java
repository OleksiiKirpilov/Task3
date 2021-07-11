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
            if (isRecurring(m.group(1), input)) {
                sb.insert(m.start(1) + underscoresCount++, '_');
            }
        }
        return sb.toString();
    }

    private static boolean isRecurring(String word, String input) {
        int index = 0;
        int count = 0;
        while (count < 2) {
            index = input.indexOf(word, index);
            if (index == -1) {
                return false;
            }
            count++;
            index += word.length();
        }
        return true;


//        Pattern r = Pattern.compile("(" + word + ".*){2,}");
//        Matcher m = r.matcher(input);
//        return m.find();
    }
}
