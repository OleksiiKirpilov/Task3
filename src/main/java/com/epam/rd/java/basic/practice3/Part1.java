package com.epam.rd.java.basic.practice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Part1 {

    private final static String fileName = "part1.txt";
    private static String textData;

    public static void main(String[] args) {
        System.out.println("Part1 demo.");
        System.out.println("input:");
        textData = Util.getInput(fileName);
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

    public static String convert1(String input) {

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new StringReader(input));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                sb.append(parts[0]).append(": ").append(parts[2]);
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        return null;
    }

    public static String convert3(String input) {
        return null;
    }

    public static String convert4(String input) {
        return null;
    }
}