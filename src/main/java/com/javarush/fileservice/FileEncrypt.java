package com.javarush.fileservice;

import com.javarush.caesarcipher.CaesarCipher;
import com.javarush.files.FileReader;
import com.javarush.files.FileWriter;

class FileEncrypt {
    private final static CaesarCipher caesarCipher = new CaesarCipher();

    public static void encryptFile(String filePath, String targetFilePath, int key) {
        try {
            String string = new String(FileReader.read(filePath));
            String encryptedData = caesarCipher.encrypt(string, key);
            FileWriter.write(targetFilePath, encryptedData);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
