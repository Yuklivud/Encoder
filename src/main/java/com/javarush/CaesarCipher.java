package com.javarush;

public class CaesarCipher {

    private String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    private String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public void BruteForce(){}
    public String Encrypt(String textToEncrypt, int key){

        if(textToEncrypt.isEmpty()){ return "Error";}
        if(key == 0) return textToEncrypt;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < textToEncrypt.length(); i++){
            int count = key;
            char symbol = textToEncrypt.charAt(i);
            if(Character.isUpperCase(symbol)){
                if (alphabetUpper.indexOf(symbol) + key > alphabetUpper.length()){
                    symbol = alphabetUpper.charAt(Math.abs((alphabetUpper.indexOf(symbol)+ key) - alphabetUpper.length()));
                } else {
                    symbol = alphabetUpper.charAt(alphabetUpper.indexOf(symbol) + key);
                }
            } else if (Character.isLowerCase(symbol)) {
                if (alphabetLower.indexOf(symbol) + key > alphabetLower.length()){
                    symbol = alphabetLower.charAt(Math.abs((alphabetLower.indexOf(symbol)+ key) - alphabetLower.length()));
                } else {
                    symbol = alphabetLower.charAt(alphabetLower.indexOf(symbol) + key);
                }
            }
            result.append(symbol);
        }

        return result.toString();
    }
    public void Decrypt(){}
}
