package com.javarush.caesarcipher;

class BruteForce {


    public StringBuilder bruteForceOperate(String textToOperate) {
        StringBuilder result = new StringBuilder();
        for (int key = 0; key < Alphabet.alphabetEngUaAndSymbols.length(); key++) {
            for (int index = 0; index < textToOperate.length(); index++) {
                char symbol = textToOperate.charAt(index);
                result.append(shiftCharacterDecrypt(symbol, key, Alphabet.alphabetEngUaAndSymbols));
            }
            result.append(" ");
        }
        return result;
    }

    private char shiftCharacterDecrypt(char symbol, int key, String alphabet) {
        int index = alphabet.indexOf(symbol);
        if (index >= 0) {
            int newIndex = (index - key + alphabet.length()) % alphabet.length();
            return alphabet.charAt(newIndex);
        }
        return symbol;
    }
}
