package com.javarush.fileservice;

import java.io.File;

public class FileService {
    public void operateFile(String command, String filePath, int key) {
        File file = new File(filePath);
        if (!isValidFile(file)) {
            return;
        }
        performFileOperationBasedOnCommand(command, filePath, key, file);
    }

    private boolean isValidFile(File file) {
        return file.exists() && file.isAbsolute();
    }

    private void performFileOperationBasedOnCommand(String command, String filePath, int key, File file) {
        try {
            switch (command) {
                case "encrypt":
                    encryptOperation(filePath, key, file);
                    break;
                case "decrypt":
                    decryptOperation(filePath, key, file);
                    break;
                case "brute_force":
                    bruteForceOperation(filePath, file);
                    break;
            }
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void encryptOperation(String filePath, int key, File file) {
        String parentDirectory = file.getParent();
        String newFilePath = parentDirectory + File.separator + "encrypt.txt";
        FileEncrypt.encryptFile(filePath, newFilePath, key);
    }

    private void decryptOperation(String filePath, int key, File file) {
        String parentDirectory = file.getParent();
        String newFilePath = parentDirectory + File.separator + "decrypt.txt";
        FileDecrypt.decryptFile(filePath, newFilePath, key);
    }

    private void bruteForceOperation(String filePath, File file) {
        String parentDirectory = file.getParent();
        String newFilePath = parentDirectory + File.separator + "bruteForce.txt";
        FileBruteForce.bruteForceFile(filePath, newFilePath);
    }
}
