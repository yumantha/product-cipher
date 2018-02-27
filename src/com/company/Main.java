package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Encrypt encryptFile = new Encrypt();
        encryptFile.encrypt();

        Decrypt decryptFile = new Decrypt();
        decryptFile.decrypt();

    }
}
