package com.javarush.fileservice;

import com.javarush.caesarcipher.CaesarCipher;
import com.javarush.files.FileReader;
import com.javarush.files.FileWriter;

class FileEncrypt {
    private static CaesarCipher caesarCipher = new CaesarCipher();

    public static void encryptFile(String filePath, String targetFilePath, int key) {
        try {
            StringBuilder stringBuilder = new StringBuilder(FileReader.read(filePath));
            String encryptedData = caesarCipher.encrypt(stringBuilder.toString(), key);
            FileWriter.write(targetFilePath, encryptedData);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
