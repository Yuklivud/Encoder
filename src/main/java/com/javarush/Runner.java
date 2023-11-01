package com.javarush;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static CaesarCipher caesarCipher = new CaesarCipher();
    private static FileService fileService = new FileService();

    public static void runner() {
        System.out.println("Enter next string: [command] [filePath] [key]\n ▶ command: ENCRYPT, DECRYPT, BRUTE_FORCE\n ▶ filePath - must be absolute!\n ▶ key: 1-25");
        String filePath = null, command = null;
        int key = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>(List.of(scanner.nextLine().split(" ")));

        if (list.size() > 3 || list.size() < 3) {
            System.out.println("Error");
            return;
        }

        command = list.get(0);
        filePath = list.get(1);
        key = Integer.parseInt(list.get(2));

        if(command == null || filePath == null) {
            System.out.println("Error");
            return;
        }
        System.out.println(caesarCipher.Encrypt(command, key));
    }
}
