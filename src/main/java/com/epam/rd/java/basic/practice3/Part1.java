package com.epam.rd.java.basic.practice3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final String FILENAME = "part1.txt";
    private static final Random rnd = new Random();

    public static void main(String[] args) {
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

    private static String convertN(String input, int part) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new StringReader(input));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(";");
                sb = (processData(part, sb, words));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return sb.toString();
    }

    private static StringBuilder processData(int part, StringBuilder sb, String[] words) {
        switch (part) {
            case 1:
                sb.append(words[0]).append(": ").append(words[2]);
                break;
            case 2:
                sb.append(words[1]).append(" (email: ").append(words[2]);
                sb.append(")");
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
        try {
            BufferedReader reader = new BufferedReader(new StringReader(input));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                //String[] words = line.split(";");
                //sb = (processData(part, sb, words));
                Pattern p = Pattern.compile("(.+;.+;)(.+@.+)$");
                Matcher m = p.matcher(line);


                System.out.println(line);

            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return sb.toString();




       // return null; //convertN(input, 3);
    }

    public static String convert4(String input) {
        return convertN(input, 4);
    }
}