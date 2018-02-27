package com.company;

import java.io.*;

public class FileHandler {

    public StringBuffer readFromFile(String filename) {
        StringBuffer plainText = new StringBuffer("");
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line =  null;

            while ((line = br.readLine()) != null) {
                plainText.append(line);
                plainText.append("\n");
            }

            br.close();
            fr.close();
            System.out.println("Plain text read");

        }
        catch(IOException e){
            System.out.println("Error reading the given file");
        }

        return plainText;
    }

    public void writeToFile(String filename, String text) {
        try{
            FileWriter fw = new FileWriter(filename, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(text);
            bw.newLine();
            bw.close();
            fw.close();
            System.out.println("Text saved");
        }
        catch(IOException e){
            System.out.println("Error saving to the give file");
        }
    }
}
