package com.javarush.fileservice;

import com.javarush.caesarcipher.CaesarCipher;
import com.javarush.files.FileReader;
import com.javarush.files.FileWriter;

class FileDecrypt {
    private final static CaesarCipher caesarCipher = new CaesarCipher();

    public static void decryptFile(String filePath, String targetFilePath, int key) {
        try {
            String string = new String(FileReader.read(filePath));
            String decryptedData = caesarCipher.decrypt(string, key);
            FileWriter.write(targetFilePath, decryptedData);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
