package com.aston.mihail.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
    public static String getHash (String passStr){
        MessageDigest digest = null;
        byte[] hash = null;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.reset();
            hash = digest.digest(passStr.getBytes("UTF-8"));
            return new String(hash, "UTF-8");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();}
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}