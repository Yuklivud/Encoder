package com.javarush.caesarcipher;

public class CaesarCipher {

    public String encrypt(String textToEncrypt, int key) {
        if (isTextEmpty(textToEncrypt)) return "Error";
        if (key == 0) return textToEncrypt;

        return new Encrypt().operateEncrypt(textToEncrypt, key).toString();
    }

    public String decrypt(String encryptedText, int key) {
        if (isTextEmpty(encryptedText)) return "Error";
        if (key == 0) return encryptedText;

        return new Decrypt().operateDecrypt(encryptedText, key).toString();
    }

    public String bruteForce(String textToOperate) {
        if (isTextEmpty(textToOperate)) return "Error";

        return new BruteForce().bruteForceOperate(textToOperate).toString();
    }

    private boolean isTextEmpty(String text) {
        return text.isEmpty();
    }
}