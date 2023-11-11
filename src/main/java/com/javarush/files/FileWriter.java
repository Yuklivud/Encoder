package com.javarush.files;

import java.io.FileOutputStream;

public class FileWriter {
    public static void write(String filePath, String textToWrite) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] bytes = textToWrite.getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }
}
