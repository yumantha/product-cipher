package com.company;

import java.util.Scanner;

public class Decrypt {
    private Substitution sub = new Substitution();
    private Permutation perm = new Permutation();
    private KeyGen keyGen = new KeyGen();
    private FileHandler fileHandler = new FileHandler();

    private String secretDec;
    private String permDecrypt;
    private String subDecrypt;
    private String input;
    private String toDec;

    private int appNum;
    private int keyDec;

    private StringBuffer inputText;

    public void decrypt() {
        inputText = fileHandler.readFromFile("EncryptedText.txt");

        input = inputText.toString();

        appNum = Integer.parseInt(input.substring(0, input.indexOf("|")));
        toDec = input.substring(input.indexOf("|")+1);

        System.out.println("Enter the secret for decryption: ");
        secretDec = new Scanner(System.in).nextLine();

        keyDec = keyGen.GenerateKey(secretDec);

        try {
            permDecrypt = perm.PermDecrypt(toDec, keyDec);
            subDecrypt = sub.SubDecrypt(permDecrypt, keyDec);

            fileHandler.writeToFile("DecryptedText.txt", subDecrypt.substring(0, subDecrypt.length()-appNum));
        } catch(Exception e) {
            System.out.println("Invalid Secret");
            fileHandler.writeToFile("DecryptedText.txt", "Invalid Secret");
        }
    }
}
