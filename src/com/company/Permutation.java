package com.company;

import java.util.*;

public class Permutation {
    private int appNum;
    private int rows;
    private boolean isNegative;

    public String PermEncrypt(String permEncInput, int key) {
        String permEncOutput = "";

        appNum = (int) (Math.pow(key, 2) - permEncInput.length());

        permEncOutput += appNum + "|";

        if(appNum >= 0) {
            isNegative = false;

            for(int i=0; i<appNum; i++) {
                Random rand = new Random();
                int randomNum = rand.nextInt((126 - 32) + 1) + 32;

                permEncInput += (char) randomNum;
            }

            for(int i=0; i<key; i++){
                for(int j=0; j<key; j++){
                    int charNum = key * j + i;

                    permEncOutput += permEncInput.charAt(charNum);
                }
            }

            return permEncOutput;

        } else {
            isNegative = true;

            rows = (int) Math.sqrt(Math.pow(Math.ceil(Math.sqrt(permEncInput.length())), 2));
            appNum = (int) Math.pow(rows, 2) - permEncInput.length();

            for(int i=0; i<appNum; i++) {
                Random rand = new Random();
                int randomNum = rand.nextInt((126 - 32) + 1) + 32;

                permEncInput += (char) randomNum;
            }

            for(int i=0; i<rows; i++){
                for(int j=0; j<rows; j++){
                    int charNum = rows * j + i;

                    permEncOutput += permEncInput.charAt(charNum);
                }
            }

            return permEncOutput;

        }
    }

    public String PermDecrypt(String permDecInput, int key) {
        String permDecOutput = "";

        if(isNegative) {
            for(int i=0; i<rows; i++){
                for(int j=0; j<rows; j++){
                    int charNum = rows * j + i;

                    permDecOutput += permDecInput.charAt(charNum);
                }
            }
        } else {
            for(int i=0; i<key; i++){
                for(int j=0; j<key; j++){
                    int charNum = key * j + i;

                    permDecOutput += permDecInput.charAt(charNum);
                }
            }
        }

        return permDecOutput;
    }

}
