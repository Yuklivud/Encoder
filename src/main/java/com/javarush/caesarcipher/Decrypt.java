package com.javarush.caesarcipher;

class Decrypt {
    public StringBuilder operateDecrypt(String textToOperate, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < textToOperate.length(); i++) {
            char symbol = textToOperate.charAt(i);
            symbol = shiftCharacterDecrypt(symbol, key, Alphabet.alphabetEngUaAndSymbols);
            result.append(symbol);

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
