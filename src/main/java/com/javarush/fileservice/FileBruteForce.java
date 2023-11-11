package com.javarush.fileservice;

import com.javarush.caesarcipher.CaesarCipher;
import com.javarush.files.FileReader;
import com.javarush.files.FileWriter;

class FileBruteForce {
    private static CaesarCipher caesarCipher = new CaesarCipher();

    public static void bruteForceFile(String filePath, String targetFilePath) {
        try {
            StringBuilder stringBuilder = new StringBuilder(FileReader.read(filePath));
            String decryptedData = caesarCipher.bruteForce(stringBuilder.toString());
            FileWriter.write(targetFilePath, decryptedData);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
