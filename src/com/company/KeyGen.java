package com.company;

public class KeyGen {

    public int GenerateKey(String secret) {
        int tot = 0;

        for(int i=0; i<secret.length(); i++) {
            tot += (int) secret.charAt(i) - 31;
        }

        return tot%256;
    }
}
