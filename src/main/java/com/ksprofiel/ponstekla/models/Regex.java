package com.ksprofiel.ponstekla.models;

import java.util.LinkedList;

public class Regex {
    public static final String WHITESPACE = "\\s+";
    public static final String NOT_DIGIT = "[A-z &,]";


    public static <T> void addUniques(LinkedList<T> tLinkedList, LinkedList<T> uniqueTLinkedList){
        for (T t : tLinkedList){
            if (!uniqueTLinkedList.contains(t)){
                uniqueTLinkedList.add(t);
            }
        }
    }


}
