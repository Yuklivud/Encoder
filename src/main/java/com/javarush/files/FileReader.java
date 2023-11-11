package com.javarush.files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileReader {
    public static StringBuilder read(String filePath) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            int i;
            while ((i = reader.read()) != -1) {
                result.append((char) i);
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
