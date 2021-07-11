package com.epam.rd.java.basic.practice3;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class Part4 {

    public static void main(String[] args)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println("Part 4 demo.");
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
    }

    public static String hash(String input, String algorithm)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(input.getBytes("cp1251"));
        byte[] hash = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(byteToHex(b));
        }
        return sb.toString();
    }

    private static String byteToHex(byte b) {
        return String.format("%02X", b);
    }
}
