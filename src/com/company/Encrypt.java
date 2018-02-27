package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Encrypt {
    private Substitution sub = new Substitution();
    private Permutation perm = new Permutation();
    private KeyGen keyGen = new KeyGen();
    private FileHandler fileHandler = new FileHandler();

    private String secretEnc;
    private String subEncrypt;
    private String permEncrypt;
    private String input;

    private int keyEnc;

    private StringBuffer inputText;

    public void encrypt() {
        inputText = fileHandler.readFromFile("PlainText.txt");

        input = inputText.toString();

        System.out.println("Enter the secret for encryption: ");
        secretEnc = new Scanner(System.in).nextLine();

        keyEnc = keyGen.GenerateKey(secretEnc);

        subEncrypt = sub.SubEncrypt(input, keyEnc);
        permEncrypt = perm.PermEncrypt(subEncrypt, keyEnc);

        fileHandler.writeToFile("EncryptedText.txt", permEncrypt);
    }


}
