package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        final String FILENAME = "part2.txt";
        String textData = Util.getInput(FILENAME);
        System.out.println("Part2 demo.");
        System.out.println("input:");
        System.out.println(textData);
        System.out.println();
        System.out.println("convert:");
        System.out.println(convert(textData));
        System.out.println(getWordsByLength(textData, 2));
    }

    public static String convert(String input) {
        Pattern p = Pattern.compile("[^A-z]?([A-z]+)[^A-z]?");
        Matcher m = p.matcher(input);
        int minLen = 0;
        int maxLen = 0;
        StringBuilder sbMin = new StringBuilder();
        StringBuilder sbMax = new StringBuilder();
        while (m.find()) {
            String word = m.group(1);
            if (minLen == 0 || word.length() < minLen) {
                minLen = word.length();
                sbMin.setLength(0);
                sbMin.append(word).append(", ");
            } else if (word.length() == minLen && sbMin.indexOf(word) == -1) {
                sbMin.append(word).append(", ");
            }
            if (maxLen == 0 || word.length() > maxLen) {
                maxLen = word.length();
                sbMax.setLength(0);
                sbMax.append(word).append(", ");
            } else if (word.length() == maxLen && sbMax.indexOf(word) == -1) {
                sbMax.append(word).append(", ");
            }
        }
        sbMin.delete(sbMin.length() - 2, sbMin.length()).append(System.lineSeparator());
        sbMax.delete(sbMax.length() - 2, sbMax.length());
        sbMin.insert(0, "Min: ");
        //String maxWords = getWordsByLength(input, maxLen);
        return sbMin.append("Max: ").append(sbMax).toString();
    }

    private static String getWordsByLength(String input, int length) {
        // doesn't work with length = 1
        Pattern p = Pattern.compile("[^A-z]([A-z]{" + length + "})[^A-z]+");
        Matcher m = p.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            if (sb.indexOf(m.group(1)) == -1) {
                sb.append(m.group(1)).append(", ");
            }
        }
        if (sb.length() > 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }
}
