package com.ksprofiel.ponstekla.models;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileFilter{
    private final static String HOLE_FILTER = "BO";
    private final static String EXTERNAL_CONTOUR_FILTER = "AK";
    private final static String INTERNAL_CONTOUR_FILTER = "IK";

    public static List<Hole> findHoles(File file){

        List<String> holeTextList = filterText(ReadFile.toList(file),HOLE_FILTER);
        List<Hole> holeList = new LinkedList<>();

        for (String line : holeTextList) {

            String[] arrayLine = line.split(Regex.WHITESPACE);
            Hole hole = new Hole(arrayLine);
            holeList.add(hole);
        }

        return holeList;
    }

    private static List<String> filterText(List<String> text,String filter){
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

        List<String> alphabets = new ArrayList<>(Arrays.asList(filter));
        filteredList.removeAll(alphabets);

        return filteredList;
    }
}