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
            byteToHexSB(b, sb);
        }
        return sb.toString();
    }

    private static void byteToHexSB(byte number, StringBuilder sb) {
        // convert signed byte to unsigned int
        int n = 256 + number & 255;
        char highNibble = (char) (n / 16 + '0');
        char lowNibble = (char) (n % 16 + '0');
        highNibble += (highNibble > '9') ? 7 : 0;
        lowNibble += (lowNibble > '9') ? 7 : 0;
        sb.append(highNibble).append(lowNibble);
    }
}
