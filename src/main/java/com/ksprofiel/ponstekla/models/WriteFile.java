package com.ksprofiel.ponstekla.models;

import java.io.*;

public class WriteFile {

    public static void write(String text, String path) {
        BufferedWriter bw = null;
        try {

            File file = new File(path + ".txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(text);
            System.out.println("succesfully wrote file: " + path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ ex + path);
            }
        }
    }
}
