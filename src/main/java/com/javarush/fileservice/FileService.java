package com.javarush.fileservice;

import com.javarush.CaesarCipher;

import java.io.File;

public class FileService {
    public void operateFile(String filePath, String mode, int key) {
        File fileToCheck = new File(filePath);
        if (!checkValidation(fileToCheck)) {
            return;
        }
        checkWorkMode(filePath, mode, key, fileToCheck);
    }

    private boolean checkValidation(File file) {
        if (!file.exists()) {
            System.out.println("File does not exists!");
            return false;
        } else if (!file.isAbsolute()) {
            System.out.println("File path is not absolute!");
            return false;
        } else {
            return true;
        }
    }

    private void checkWorkMode(String filePath, String mode, int key, File fileToCheck) {
        try {
            if (mode.toLowerCase().equals("encrypt")) {
                String parentDirectory = fileToCheck.getParent();
                String newFilePath = parentDirectory + File.separator + "encrypt.txt";
                FileEncrypt.encryptFile(filePath, newFilePath, key);
            } else if (mode.toLowerCase().equals("decrypt")) {
                String parentDirectory = fileToCheck.getParent();
                String newFilePath = parentDirectory + File.separator + "decrypt.txt";
                FileDecrypt.decryptFile(filePath, newFilePath, key);
            } else if (mode.toLowerCase().equals("brute_force")) {
                String parentDirectory = fileToCheck.getParent();
                String newFilePath = parentDirectory + File.separator + "bruteForce.txt";
                FileBruteForce.bruteForceFile(filePath, newFilePath);
            }
        } catch (Throwable ignored) {
            System.out.println(ignored.getMessage());
        }
    }
}
