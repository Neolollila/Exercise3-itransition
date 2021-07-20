package com.javacours.se.lesson5;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Computer {
    int al;

    public Computer(int al) {
        this.al = al;
    }

    public byte[] getSecretKey() {
        SecureRandom random = new SecureRandom(); //computer
        byte secret[] = new byte[16];
        random.nextBytes(secret);
        return secret;
    }

    public int getChoiceComputer() {
        int x = 1+(int)(Math.random()*al);
        return x;
    }

    public String getHmacWithMessage(byte [] secret, String messageStr) {
        Mac sha256 = null;
        try {
            sha256 = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKeySpec s_key = new SecretKeySpec(secret,"HmacSHA256");
        try {
            sha256.init(s_key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return Common.bytesToHex(sha256.doFinal(messageStr.getBytes()));
    }

    public void printSecretKey(byte [] secret) {
        System.out.println("HMAC: "+Common.bytesToHex(secret));
    }
}
