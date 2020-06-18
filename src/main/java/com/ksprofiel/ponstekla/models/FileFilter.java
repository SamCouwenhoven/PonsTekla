package com.ksprofiel.ponstekla.models;

import com.ksprofiel.ponstekla.factories.ContourFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class FileFilter{
    private final static String HOLE_FILTER = "BO";
    private final static String EXTERNAL_CONTOUR_FILTER = "AK";
    private final static String INTERNAL_CONTOUR_FILTER = "IK";

    public static LinkedList<Hole> findHoles(File file){

        LinkedList<String> holeTextList = filterText(ReadFile.toList(file),HOLE_FILTER);
        LinkedList<Hole> holeList = new LinkedList<>();

        for (String line : holeTextList) {

            String[] arrayLine = line.split(Regex.WHITESPACE);
            Hole hole = new Hole(arrayLine);
            holeList.add(hole);
        }

        return holeList;
    }

    public static LinkedList<Contour> findContour(File file){
        LinkedList<String> contourTextList = filterText(ReadFile.toList(file),EXTERNAL_CONTOUR_FILTER);
        ContourFactory contourFactory = new ContourFactory();
        LinkedList<Contour> contourList = contourFactory.createContours(contourTextList);


        return contourList;
    }

    private static LinkedList<String> filterText(LinkedList<String> text,String filter){
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
}