package com.javarush;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static CaesarCipher caesarCipher = new CaesarCipher();
    private static FileService fileService = new FileService();

    public static void runner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose work mode:\n▶ 1 - Work with files.\n▶ 2 - Work in console.");
        String filePath = null, command = null, textToOperate = null, workMode = scanner.nextLine();
        int key = 0, mode = 0;

        if(workMode.equals("1")){
            System.out.println("Enter next string: [command] [filePath] [key]\n ▶ command: ENCRYPT, DECRYPT, BRUTE_FORCE\n ▶ filePath - must be absolute!\n ▶ key: 1-25");
            mode = 1;
        } else if(workMode.equals("2")){
            System.out.println("Enter next string: [command] [text] [key]\n ▶ command: ENCRYPT, DECRYPT, BRUTE_FORCE\n ▶ text: Text to operate \n ▶ key: 1-25");
            mode = 2;
        } else {
            return;
        }

        ArrayList<String> list = new ArrayList<>(List.of(scanner.nextLine().split(" ")));
        if (list.size() > 3 || list.size() < 3) {
            System.out.println("Syntax error");
            return;
        } else if(list.get(0) == null || list.get(1) == null || list.get(2) == null) {
            System.out.println("Invalid command or path");
            return;
        }
        try {
            command = list.get(0);
            filePath = list.get(1);
            textToOperate = list.get(1);
            key = Integer.parseInt(list.get(2));
            if(mode == 2){
                if(command.toLowerCase().equals("encrypt")){
                    System.out.println(caesarCipher.Encrypt(textToOperate, key));
                } else if (command.toLowerCase().equals("decrypt")) {
                    System.out.println(caesarCipher.Decrypt(textToOperate, key));
                } else if (command.toLowerCase().equals("brute_force")) {
                    System.out.println("Brute Force completed!\nResult: " + caesarCipher.BruteForce(caesarCipher.BruteForce(textToOperate)));
                }
            } else if (mode == 1) {
                fileService.operateFile(filePath, command, key);
            }

        } catch (Throwable e){
            System.out.println("Oops, something wrong!");
        }
    }
}
