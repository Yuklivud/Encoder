package com.javarush;

public class CaesarCipher {

    private String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    private String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public String BruteForce(String encryptedText) {
        StringBuilder result = new StringBuilder();

        for(int key = 1; key < 26; key++){
            for(char symbol : encryptedText.toCharArray()){
                if(Character.isUpperCase(symbol)){
                    if(alphabetUpper.indexOf(symbol) + key >= alphabetUpper.length()){
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

    public String Encrypt(String textToEncrypt, int key) {

        if (textToEncrypt.isEmpty()) {
            return "Error, text is EMPTY!";
        }
        if (key == 0) return textToEncrypt;
        if (key > 26) return "The key MUST BE between 1 and 25!";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < textToEncrypt.length(); i++) {
            char symbol = textToEncrypt.charAt(i);
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

        return result.toString();
    }

    public String Decrypt(String encryptedText, int key) {
        if (encryptedText.isEmpty()) {
            return "Error";
        }
        if (key == 0) return encryptedText;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {
            char symbol = encryptedText.charAt(i);
            if (Character.isUpperCase(symbol)) {
                if (alphabetUpper.indexOf(symbol) - key >= 0) {
                    symbol = alphabetUpper.charAt(alphabetUpper.indexOf(symbol) - key);
                } else {
                    symbol = alphabetUpper.charAt((alphabetUpper.indexOf(symbol) - key) + alphabetUpper.length());
                }
            } else if (Character.isLowerCase(symbol)) {
                if (alphabetLower.indexOf(symbol) - key >= 0) {
                    symbol = alphabetLower.charAt(alphabetLower.indexOf(symbol) - key);
                } else {
                    symbol = alphabetLower.charAt((alphabetLower.indexOf(symbol) - key) + alphabetLower.length());
                }
            }
            result.append(symbol);
        }


        return result.toString();
    }
}
