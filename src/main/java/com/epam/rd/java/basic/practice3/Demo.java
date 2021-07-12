package com.epam.rd.java.basic.practice3;

import java.security.NoSuchAlgorithmException;

public class Demo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Part1.main(args);
        Part2.main(args);
        Part3.main(args);
        Part4.main(args);
        Part5.main(args);
        System.out.printf("%d --> %s%n", 2021, Part5.decimal2Roman(2021));
        Part6.main(args);
    }

}
