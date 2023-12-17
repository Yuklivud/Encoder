package com.javarush;

import com.javarush.fileservice.FileService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Runner {
    private static final FileService FILE_SERVICE = new FileService();

    public static void runner(String[] args) {
        String filePath, command;
        int key;
        ArrayList<String> list = new ArrayList<>(List.of(args));

        if (!isValidParameters(list)) {
            return;
        }

        try {
            command = list.get(0).toLowerCase();
            filePath = list.get(1);
            key = keySetter(list);
            FILE_SERVICE.operateFile(command, filePath, key);
        } catch (Throwable ignored) {
            System.out.println("Oops, something wrong!");
        }
    }

    private static boolean isValidParameters(List<String> list) {
        if (isValidBruteForce(list) || isValidEncryptAndDecrypt(list)) {
            return true;
        }
        System.out.println("Oops, something wrong");
        return false;
    }

    private static boolean isValidBruteForce(List<String> list) {
        return list.size() == 2 && list.get(0).equalsIgnoreCase("brute_force") && Objects.nonNull(list.get(1));
    }

    private static boolean isValidEncryptAndDecrypt(List<String> list) {
        return list.size() == 3 && Objects.nonNull(list.get(0)) && Objects.nonNull(list.get(1)) && Objects.nonNull(list.get(2)) &&
                list.get(0).equalsIgnoreCase("encrypt") || list.get(0).equalsIgnoreCase("decrypt");
    }

    private static int keySetter(List<String> list) {
        if (isValidBruteForce(list)) {
            return -1;
        } else {
            return Integer.parseInt(list.get(2));
        }
    }
}
