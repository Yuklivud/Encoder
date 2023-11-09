package com.javarush.fileservice;

import com.javarush.CaesarCipher;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileBruteForce {
    public static void bruteForceFile(String filePath, String targetFilePath){
        CaesarCipher caesarCipher = new CaesarCipher();
        try (FileInputStream fis = new FileInputStream(filePath);
             FileOutputStream fos = new FileOutputStream(targetFilePath)) {

            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while ((i = fis.read()) != -1) {
                stringBuilder.append((char) i);
            }

            String encryptedData = caesarCipher.bruteForce(stringBuilder.toString());
            byte[] bytes = encryptedData.getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (Throwable ignored) {
            System.out.println(ignored.getMessage());
        }
    }
}
