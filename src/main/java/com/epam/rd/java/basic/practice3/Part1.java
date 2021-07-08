package com.epam.rd.java.basic.practice3;

import java.util.Arrays;
import java.util.Iterator;

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
        Iterator<String> i = Arrays.stream(textData.split(System.lineSeparator())).iterator();
        StringBuilder sb = new StringBuilder();
        i.next();
        while (i.hasNext()){
            String []line = i.next().split(";");
            sb.append(line[0]).append(": ").append(line[2]);
            sb.append(System.lineSeparator());
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