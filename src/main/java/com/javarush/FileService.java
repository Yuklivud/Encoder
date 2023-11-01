package com.javarush;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Arrays;

public class FileService {
    public void writeFile(String filePath, String textToWrite){
        try(FileWriter fileWriter = new FileWriter(filePath)){
            File ignored = new File(filePath);
            if(!ignored.isAbsolute()){return;}
            if(!ignored.exists()){ignored.createNewFile();}

            fileWriter.write(textToWrite);

        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
