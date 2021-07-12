package com.epam.rd.java.basic.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    public static void main(String[] args)
            throws NoSuchAlgorithmException {
        System.out.println("Part 4 demo.");
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
    }

    public static String hash(String input, String algorithm)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(input.getBytes());
        byte[] hash = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
