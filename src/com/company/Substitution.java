package com.company;

import java.util.*;

public class Substitution {

    public String SubEncrypt(String subEncInput, int key) {
        StringBuffer subEncOutput = new StringBuffer();
        for(int i=0; i<subEncInput.length(); i++) {
            char c = subEncInput.charAt(i);
            subEncOutput.append((char)(c+key));
        }
        return subEncOutput.toString();
    }

    public String SubDecrypt(String subDecInput, int key) {
        StringBuffer subDecOutput = new StringBuffer();
        for(int i=0; i<subDecInput.length(); i++) {
            char c = subDecInput.charAt(i);
            subDecOutput.append((char)(c-key));
        }
        return subDecOutput.toString();
    }
}
