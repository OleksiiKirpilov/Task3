package com.epam.rd.java.basic.practice3;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final Random rnd = new Random();
    private static Pattern pat;

    private static String convertN(String input, int part) {
        StringBuilder sb = new StringBuilder();
        String[] lines = input.split(System.lineSeparator());
        for (String line : lines) {
            if (!line.contains("@")) {
                continue;
            }
            String[] words = line.split(";");
            sb = processData(part, sb, words);
        }
        return sb.toString();
    }

    private static StringBuilder processData(int part, StringBuilder sb, String[] words) {
        switch (part) {
            case 1:
                sb.append(words[0]).append(": ").append(words[2]);
                break;
            case 2:
                String[] nameParts = words[1].split(" ");
                sb.append(String.format("%s %s (email: %s)",
                        nameParts[1], nameParts[0], words[2]));
                break;
            case 4:
                sb.append(words[0]).append(";").append(words[1]).append(";");
                sb.append(words[2]).append(";");
                sb.append(String.format("%04d", rnd.nextInt(10_000)));
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return sb.append(System.lineSeparator());
    }

    public static String convert1(String input) {
        return convertN(input, 1);
    }

    public static String convert2(String input) {
        return convertN(input, 2);
    }

    public static String convert3(String input) {
        StringBuilder sb = new StringBuilder();
        pat = Pattern.compile("^(\\S+);(\\S+)\\s(\\S+);((\\S+)@(\\S+))$");
        String[] lines = input.split(System.lineSeparator());
        String domains = getDomains(lines);
        for (String domain : domains.split(";")) {
            sb.append(getLoginsForDomain(domain, lines));
        }
        return sb.toString();
    }

    public static String convert4(String input) {
        return convertN(input, 4);
    }

    private static String getDomains(String[] lines) {
        StringBuilder domains = new StringBuilder();
        for (String line : lines) {
            Matcher m = pat.matcher(line);
            if (m.find()) {
                String domain = m.group(6);
                if (domains.indexOf(domain) == -1) {
                    domains.append(domain).append(';');
                }
            }
        }
        return domains.toString();
    }

    // mail.com ==> ivanov, bush
    private static String getLoginsForDomain(String domain, String[] lines) {
        StringBuilder sb = new StringBuilder(domain);
        sb.append(" ==> ");
        Pattern patDomain = Pattern.compile("^(\\S+);(\\S+)\\s(\\S+);((\\S+)@(" +
                domain + "))$");
        for (String s : lines) {
            Matcher m = patDomain.matcher(s);
            if (m.find()) {
                sb.append(m.group(1)).append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length()).append(System.lineSeparator());
        return sb.toString();
    }

    public static void main(String[] args) {
        final String FILENAME = "part1.txt";
        String textData = Util.getInput(FILENAME);
        System.out.println("Part1 demo.");
        System.out.println("input:");
        System.out.println(textData);
        System.out.println();
        System.out.println("convert1:");
        System.out.println(convert1(textData));
        System.out.println("convert2:");
        System.out.println(convert2(textData));
        System.out.println("convert3:");
        System.out.println(convert3(textData));
        System.out.println("convert4:");
        System.out.println(convert4(textData));
    }
}