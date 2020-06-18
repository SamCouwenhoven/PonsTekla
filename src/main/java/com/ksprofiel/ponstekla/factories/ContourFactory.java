package com.ksprofiel.ponstekla.factories;

import com.ksprofiel.ponstekla.models.Contour;
import com.ksprofiel.ponstekla.models.Regex;

import java.util.LinkedList;
import java.util.ListIterator;



public class ContourFactory {
    private static final int LENGTH_COLUMN = 1;
    private static final int HEIGHT_COLUMN = 2;
    private LinkedList<String[]> vSideList = new LinkedList<>();
    private LinkedList<String[]> oSideList = new LinkedList<>();
    private LinkedList<String[]> uSideList = new LinkedList<>();
    private LinkedList<String[]> hSideList = new LinkedList<>();

    public LinkedList<Contour> createContours( LinkedList<String> contourTextList){

    String side = "";
    LinkedList<Contour> contourList  = new LinkedList<>();

    for (String string: contourTextList){
        String[] wordArray = string.split(Regex.WHITESPACE);
        if (wordArray[1].matches(Regex.NOT_DIGIT)){
            side = wordArray[1];
        }
        addSideList(wordArray,side);
    }
        contourList.addAll(makeContour(vSideList, "v"));
        contourList.addAll(makeContour(oSideList, "o"));
        contourList.addAll(makeContour(uSideList, "u"));
        contourList.addAll(makeContour(hSideList, "h"));

        return contourList;
    }

    private void addSideList(String[] line, String side){
        switch (side){
            case "v":
                vSideList.add(line);
                break;
            case "o":
                oSideList.add(line);
                break;
            case "u":
                uSideList.add(line);
                break;
            case "h":
                hSideList.add(line);
                break;
        }
    }

    private LinkedList<String[]> cleanSideList(LinkedList<String[]> sideList){
        for (String[] line : sideList){
            for (int i = 0 ; i < line.length ; i++){
                line[i] = line[i].replaceAll(Regex.NOT_DIGIT,"");
            }
        }
        return sideList;
    }

    private LinkedList<Contour> makeContour(LinkedList<String[]> sideList, String side){
        LinkedList<Contour> contourLinkedList = new LinkedList<>();
        sideList = cleanSideList(sideList);
        double maxLength = findMax(sideList,LENGTH_COLUMN);
        double maxHeight = findMax(sideList,HEIGHT_COLUMN);
        double length = 0;
        double height = 0;

        ListIterator<String[]> listIterator = sideList.listIterator();

        double savedHeight = 0;
        double savedX = 0;
        boolean foundContour = false;

        while (listIterator.hasNext()){
            String[] current = listIterator.next();
            double currentHeight = Double.parseDouble( current[2] );
            double currentX = 0;

            if (foundContour){
                while (listIterator.hasNext()){
                    current = listIterator.next();
                    currentX = Double.parseDouble(current[1]);
                    currentHeight = Double.parseDouble( current[2] );

                    if (currentX != savedX){
                        length = currentX - savedX;

                        while(listIterator.hasNext()){
                            currentX = Double.parseDouble(current[1]);
                            currentHeight = Double.parseDouble( current[2] );
                            if (savedHeight != currentHeight){

                                height = Math.abs( currentHeight - savedHeight );

                            }

                            current = listIterator.next();


                        }
                    }

                }
                foundContour = false;
                current = listIterator.previous();
                contourLinkedList.add(new Contour(height,length,side));
                continue;
            }

            if (current[1].length() > 0) {
                currentX = Double.parseDouble(current[1]);
            }

            if (currentHeight != maxHeight && currentHeight != 0){
                savedX = currentX;
                savedHeight = currentHeight;
                foundContour = true;
            }



        }
        //logic of making a contour form string

        return contourLinkedList;
    }

    private double findMax(LinkedList<String[]> sideList,int column){
        double length = 0;
        for (String[] line : sideList){
            if (! line[column].equals( "" )) {
               length = Math.max(length,Double.parseDouble(line[column]));
            }

        }
        return length;
    }


}
