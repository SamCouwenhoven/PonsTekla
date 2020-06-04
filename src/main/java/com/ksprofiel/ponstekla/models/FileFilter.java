package com.ksprofiel.ponstekla.models;

import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileFilter{
    private ObservableList<File> files;

    public FileFilter(ObservableList<File> files){
        this.files = files;
    }

    public LinkedList<Hole> calculateDiffrentHoles(){
        LinkedList<Hole> uniqueHoleList = new LinkedList<>();
        for (File file : files){

            LinkedList<Hole> holes =  findUNr(readFile(file));

            for (Hole hole : holes){
                if (!uniqueHoleList.contains(hole)){
                    uniqueHoleList.add(hole);
                }
            }
        }
        return uniqueHoleList;
    }

    private LinkedList<String> readFile(File file){

        LinkedList<String> text = new LinkedList<>();
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

    private LinkedList<Hole> findUNr(LinkedList<String> text){
        ArrayList<String> alphabets = new ArrayList<>(Arrays.asList("BO"));
        List<String> holeList = text.subList(text.indexOf("BO") + 1,text.size() - 1);
        holeList.removeAll(alphabets);

        LinkedList<Hole> uniqueHoleList = new LinkedList<>();

        for (String line : holeList) {
            String[] arrayLine = line.split("\\s+");

            Hole hole = new Hole(arrayLine);
            if(!uniqueHoleList.contains(hole)){
                uniqueHoleList.add(hole);
            }
        }

        return uniqueHoleList;
    }
}