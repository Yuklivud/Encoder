package com.javarush.fileservice;

import com.javarush.caesarcipher.CaesarCipher;
import com.javarush.files.FileReader;
import com.javarush.files.FileWriter;

class FileBruteForce {
    private final static CaesarCipher caesarCipher = new CaesarCipher();

    public static void bruteForceFile(String filePath, String targetFilePath) {
        try {
            String string = new String(FileReader.read(filePath));
            String decryptedData = caesarCipher.bruteForce(string);
            FileWriter.write(targetFilePath, decryptedData);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
