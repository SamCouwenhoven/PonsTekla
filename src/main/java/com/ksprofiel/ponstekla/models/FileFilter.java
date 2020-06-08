package com.ksprofiel.ponstekla.models;

import javafx.collections.ObservableList;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class FileFilter{
    private final static String HOLE_FILTER = "BO";
    private final static String EXTERNAL_CONTOUR_FILTER = "AK";
    private final static String INTERNAL_CONTOUR_FILTER = "IK";
    private final ObservableList<File> files;

    public FileFilter(ObservableList<File> files){
        this.files = files;
    }

    public LinkedList<Hole> calculateDifferentHoles(){
        LinkedList<Hole> uniqueHoleList = new LinkedList<>();
        for (File file : files){

            LinkedList<Hole> holes = findHoleUNr(ReadFile.toList(file));
            addUniques(holes,uniqueHoleList);

        }
        return uniqueHoleList;
    }

    private LinkedList<Hole> findHoleUNr(LinkedList<String> text){

        List<String> holeList = filterText(text,HOLE_FILTER);
        LinkedList<Hole> uniqueHoleList = new LinkedList<>();

        for (String line : holeList) {
            String[] arrayLine = line.split(Regex.WHITESPACE);

            Hole hole = new Hole(arrayLine);
            if(!uniqueHoleList.contains(hole)){
                uniqueHoleList.add(hole);
            }
        }

        return uniqueHoleList;
    }

    private LinkedList<String> filterText(LinkedList<String> text,String filter){
        LinkedList<String> filteredList = new LinkedList<>();
        boolean add = true;
        for (String line : text){

            if (line.length() == 2 && !line.equals(filter)){
                add = false;
            }else if(line.length() == 2){
                add = true;
            }

            if (add){
                filteredList.add(line);
            }
        }

        ArrayList<String> alphabets = new ArrayList<>(Arrays.asList(filter));
        filteredList.removeAll(alphabets);

        return filteredList;
    }

    private <T> void addUniques(LinkedList<T> tLinkedList, LinkedList<T> uniqueTLinkedList){
        for (T t : tLinkedList){
            if (!uniqueTLinkedList.contains(t)){
                uniqueTLinkedList.add(t);
            }
        }
    }

}