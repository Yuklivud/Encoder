package com.javarush;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class FileService {

    private static CaesarCipher caesarCipher = new CaesarCipher();
    public void operateFile(String filePath, String mode, int key){

        File fileToCheck = new File(filePath);
        if (!fileToCheck.isAbsolute() || !fileToCheck.exists()) {
            System.out.println("File does not exist or is not an absolute path.");
            return;
        }

        try{
            if(mode.toLowerCase().equals("encrypt")){
                String parentDirectory = fileToCheck.getParent();
                String newFilePath = parentDirectory + File.separator + "encrypt.txt";
                encryptFile(filePath, newFilePath, key);
            } else if (mode.toLowerCase().equals("decrypt")) {
                String parentDirectory = fileToCheck.getParent();
                String newFilePath = parentDirectory + File.separator + "decrypt.txt";
                decryptFile(filePath, newFilePath, key);
            } else if (mode.toLowerCase().equals("brute_force")) {
                String parentDirectory = fileToCheck.getParent();
                String newFilePath = parentDirectory + File.separator + "bruteForce.txt";
                bruteForceFile(filePath, newFilePath);
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
    private void encryptFile(String filePath, String targetFilePath, int key){
        try (FileInputStream fis = new FileInputStream(filePath);
             FileOutputStream fos = new FileOutputStream(targetFilePath)) {

            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while ((i = fis.read()) != -1) {
                stringBuilder.append((char) i);
            }

            String encryptedData = caesarCipher.Encrypt(stringBuilder.toString(), key);
            byte[] bytes = encryptedData.getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
    private void decryptFile(String filePath, String targetFilePath, int key){
        try (FileInputStream fis = new FileInputStream(filePath);
             FileOutputStream fos = new FileOutputStream(targetFilePath)) {

            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while ((i = fis.read()) != -1) {
                stringBuilder.append((char) i);
            }

            String encryptedData = caesarCipher.Decrypt(stringBuilder.toString(), key);
            byte[] bytes = encryptedData.getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
    private void bruteForceFile(String filePath, String targetFilePath){
        try (FileInputStream fis = new FileInputStream(filePath);
             FileOutputStream fos = new FileOutputStream(targetFilePath)) {

            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while ((i = fis.read()) != -1) {
                stringBuilder.append((char) i);
            }

            String encryptedData = caesarCipher.BruteForce(stringBuilder.toString());
            byte[] bytes = encryptedData.getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
