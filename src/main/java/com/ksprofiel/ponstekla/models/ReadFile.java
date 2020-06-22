package com.ksprofiel.ponstekla.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadFile {

    public static List<String> toList(File file){

        List<String> text = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                text.add(line);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return text;
    }
}
