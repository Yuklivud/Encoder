package com.javarush;

public class CaesarCipher {

    private String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    private String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String alphabetLowerUa = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
    private String alphabetUpperUa = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    private String symbols = ".,«»\"\':!? ";



    public String bruteForce(String encryptedText) {
        StringBuilder result = new StringBuilder();

        for (int key = 1; key < 26; key++) {
            for (char symbol : encryptedText.toCharArray()) {
                if (Character.isUpperCase(symbol)) {
                    if (alphabetUpper.indexOf(symbol) + key >= alphabetUpper.length()) {
                        symbol = alphabetUpper.charAt(Math.abs((alphabetUpper.indexOf(symbol) + key) - alphabetUpper.length()));
                    } else {
                        symbol = alphabetUpper.charAt(alphabetUpper.indexOf(symbol) + key);
                    }
                } else if (Character.isLowerCase(symbol)) {
                    if (alphabetLower.indexOf(symbol) + key >= alphabetLower.length()) {
                        symbol = alphabetLower.charAt(Math.abs((alphabetLower.indexOf(symbol) + key) - alphabetLower.length()));
                    } else {
                        symbol = alphabetLower.charAt(alphabetLower.indexOf(symbol) + key);
                    }
                }
                result.append(symbol);
            }
            result.append(" ");
        }
        return result.toString();
    }

    public String encrypt(String textToEncrypt, int key) {

        if (textToEncrypt.isEmpty()) return "Error";
        if (key == 0) return textToEncrypt;
        if (key > 26) return "The key must be between 1 and 25!";

        return operateEncrypt(textToEncrypt, key).toString();
    }

    public String decrypt(String encryptedText, int key) {

        if (encryptedText.isEmpty()) return "Error";
        if (key == 0) return encryptedText;

        return operateDecrypt(encryptedText, key).toString();
    }
    private StringBuilder operateEncrypt(String textToOperate, int key){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < textToOperate.length(); i++) {
            char symbol = textToOperate.charAt(i);
            if (Character.isUpperCase(symbol)) {
                if(checkWhatIsLanguage(symbol).equals("eng")){
                    if (alphabetUpper.indexOf(symbol) + key >= alphabetUpper.length()) {
                        symbol = alphabetUpper.charAt(Math.abs((alphabetUpper.indexOf(symbol) + key) - alphabetUpper.length()));
                    } else {
                        symbol = alphabetUpper.charAt(alphabetUpper.indexOf(symbol) + key);
                    }
                } else if (checkWhatIsLanguage(symbol).equals("ua")) {
                    if (alphabetUpperUa.indexOf(symbol) + key >= alphabetUpperUa.length()) {
                        symbol = alphabetUpperUa.charAt(Math.abs((alphabetUpperUa.indexOf(symbol) + key) - alphabetUpperUa.length()));
                    } else {
                        symbol = alphabetUpperUa.charAt(alphabetUpperUa.indexOf(symbol) + key);
                    }
                }
            } else if (Character.isLowerCase(symbol)) {
                if(checkWhatIsLanguage(symbol).equals("eng")){
                    if (alphabetLower.indexOf(symbol) + key >= alphabetLower.length()) {
                        symbol = alphabetLower.charAt(Math.abs((alphabetLower.indexOf(symbol) + key) - alphabetLower.length()));
                    } else {
                        symbol = alphabetLower.charAt(alphabetLower.indexOf(symbol) + key);
                    }
                } else if (checkWhatIsLanguage(symbol).equals("ua")) {
                    if (alphabetLowerUa.indexOf(symbol) + key >= alphabetLowerUa.length()) {
                        symbol = alphabetLowerUa.charAt(Math.abs((alphabetLowerUa.indexOf(symbol) + key) - alphabetLowerUa.length()));
                    } else {
                        symbol = alphabetLowerUa.charAt(alphabetLowerUa.indexOf(symbol) + key);
                    }
                }
            }
            result.append(symbol);
        }
        return result;
    }

    private StringBuilder operateDecrypt(String textToOperate, int key){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < textToOperate.length(); i++) {
            char symbol = textToOperate.charAt(i);
            if (Character.isUpperCase(symbol)) {
                if(checkWhatIsLanguage(symbol).equals("eng")){
                    if (alphabetUpper.indexOf(symbol) - key >= 0) {
                        symbol = alphabetUpper.charAt(alphabetUpper.indexOf(symbol) - key);
                    } else {
                        symbol = alphabetUpper.charAt((alphabetUpper.indexOf(symbol) - key) + alphabetUpper.length());
                    }
                } else if (checkWhatIsLanguage(symbol).equals("ua")) {
                    if (alphabetUpperUa.indexOf(symbol) - key >= 0) {
                        symbol = alphabetUpperUa.charAt(alphabetUpperUa.indexOf(symbol) - key);
                    } else {
                        symbol = alphabetUpperUa.charAt((alphabetUpperUa.indexOf(symbol) - key) + alphabetUpperUa.length());
                    }
                }
            } else if (Character.isLowerCase(symbol)) {
                if(checkWhatIsLanguage(symbol).equals("eng")){
                    if (alphabetLower.indexOf(symbol) - key >= 0) {
                        symbol = alphabetLower.charAt(alphabetLower.indexOf(symbol) - key);
                    } else {
                        symbol = alphabetLower.charAt((alphabetLower.indexOf(symbol) - key) + alphabetLower.length());
                    }
                } else if (checkWhatIsLanguage(symbol).equals("ua")) {
                    if (alphabetLowerUa.indexOf(symbol) - key >= 0) {
                        symbol = alphabetLowerUa.charAt(alphabetLowerUa.indexOf(symbol) - key);
                    } else {
                        symbol = alphabetLowerUa.charAt((alphabetLowerUa.indexOf(symbol) - key) + alphabetLowerUa.length());
                    }
                }

            }
            result.append(symbol);
        }
        return result;
    }
    private String checkWhatIsLanguage(char symbol){
        if(alphabetLower.indexOf(Character.toLowerCase(symbol)) != -1){
            return "eng";
        } else if (alphabetLowerUa.indexOf(Character.toLowerCase(symbol)) != -1) {
            return "ua";
        } else {
            return "skip";
        }
    }
}