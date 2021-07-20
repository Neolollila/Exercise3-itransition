package com.javacours.se.lesson5;

public class Common {
    public static String bytesToHex (byte[] bytes) {          // computer
        StringBuilder sb = new StringBuilder(bytes.length*2);
        for(byte b: bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
