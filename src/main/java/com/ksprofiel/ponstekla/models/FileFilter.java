package com.ksprofiel.ponstekla.models;

import javafx.collections.ObservableList;
import java.io.File;
import java.util.*;
import java.util.zip.CheckedOutputStream;

public class FileFilter{
    private final static String HOLE_FILTER = "BO";
    private final static String EXTERNAL_CONTOUR_FILTER = "AK";
    private final static String INTERNAL_CONTOUR_FILTER = "IK";
    private final ObservableList<File> files;

    public FileFilter(ObservableList<File> files){
        this.files = files;
    }

    public Set<Hole> calculateDifferentHoles(){
        Set<Hole> holeSet = new HashSet<>();
        for (File file : files){

            holeSet.addAll( findHoleUNr(ReadFile.toList(file) ));

        }
        return holeSet;
    }

    private Set<Hole> findHoleUNr(LinkedList<String> text){

        List<String> textList = filterText(text,HOLE_FILTER);
        Set<Hole> holeSet = new HashSet<>();

        for (String line : textList) {

            String[] arrayLine = line.split(Regex.WHITESPACE);
            Hole hole = new Hole(arrayLine);
            holeSet.add(hole);

        }

        return holeSet;
    }

    private List<String> filterText(List<String> text,String filter){
        List<String> filteredList = new LinkedList<>();
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

}