package com.javarush;

import com.javarush.fileservice.FileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Runner {
    private static FileService fileService = new FileService();

    public static void runner(String[] args) {
        String filePath, command;
        int key;
        ArrayList<String> list = new ArrayList<>(List.of(args));
        if (!checkValidation(list)) {return;}

        try {
            command = list.get(0);
            filePath = list.get(1);
            key = Integer.parseInt(list.get(2));
            fileService.operateFile(filePath, command, key);
        } catch (Throwable ignored){
            System.out.println("Oops, something wrong!");
        }
    }
    private static boolean checkValidation(List<String> list){

        // This method check the arguments passed by the user

        if(list.get(0).equalsIgnoreCase("brute_force") && !Objects.isNull(list.get(1))){
            return true;
        } else if (Objects.isNull(list.get(0)) || Objects.isNull(list.get(1)) || Objects.isNull(list.get(2))) {
            System.out.println("Something is wrong...");
            return false;
        } else if (list.size() != 3) {
            System.out.println("Something is wrong...");
            return false;
        } else return true;
    }
}
