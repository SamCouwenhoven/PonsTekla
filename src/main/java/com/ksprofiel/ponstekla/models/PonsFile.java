package com.ksprofiel.ponstekla.models;


import javafx.scene.control.TextField;

import java.time.LocalDate;

import static com.ksprofiel.ponstekla.factories.PonsFileFactory.NEWLINE;


public class PonsFile {


    private final String SYSTEM = "[system]" + NEWLINE;
    private final String VERSION = "version=3" + NEWLINE;
    private final String COMPANY = "company= KsProfiel" + NEWLINE;
    private final String JOB = "[job]" + NEWLINE;
    private final String DATE;
    private final String DRAWING;
    private final String COMMENT = "comment= made with ponstekla - SC" + NEWLINE;
    private final String NC_CODE_1 = "[nc-code-1]" + NEWLINE;
    private final String LENGTH;
    private final String NUMBER;
    private final String CHECKED = "checked=1" + NEWLINE;
    private final String NC_CODE_2 = "[nc-code-2]" + NEWLINE;

    public PonsFile(double length,int number,String drawing){
        DATE = "date=" + LocalDate.now().toString() + NEWLINE;
        LENGTH = "length=" + length + NEWLINE;
        NUMBER = "number=" + number + NEWLINE;
        DRAWING = "drawing=" + drawing + NEWLINE;
    }

    public String createPonsFile(){
        return SYSTEM +
                VERSION +
                COMPANY +
                JOB +
                DATE +
                DRAWING +
                COMMENT +
                NC_CODE_1 +
                LENGTH +
                NUMBER +
                CHECKED +
                NC_CODE_2;
    }


}
