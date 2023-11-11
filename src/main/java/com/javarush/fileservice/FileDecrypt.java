package com.javarush.fileservice;

import com.javarush.caesarcipher.CaesarCipher;
import com.javarush.files.FileReader;
import com.javarush.files.FileWriter;

class FileDecrypt {
    private static CaesarCipher caesarCipher = new CaesarCipher();

    public static void decryptFile(String filePath, String targetFilePath, int key) {
        try {
            StringBuilder stringBuilder = new StringBuilder(FileReader.read(filePath));
            String decryptedData = caesarCipher.decrypt(stringBuilder.toString(), key);
            FileWriter.write(targetFilePath, decryptedData);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
