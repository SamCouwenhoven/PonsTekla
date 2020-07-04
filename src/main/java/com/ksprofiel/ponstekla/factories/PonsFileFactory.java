package com.ksprofiel.ponstekla.factories;

import com.ksprofiel.ponstekla.models.Hole;
import com.ksprofiel.ponstekla.models.PonsFile;
import com.ksprofiel.ponstekla.models.Profile;

public class PonsFileFactory {

    public static final String NEWLINE = "\n";
    private final String PADDING_UNR = "U%02d";
    private final String PADDING_NR = "%03d=";
    private final String ROW_TEXT = " 0,00 left ";
    private final String KYKGAT_UNR = "KYKGAT";
    private final String KYKGAT_X = "-5.00";
    private int nr;
    private boolean isKykgat;

    private Profile profile;

    public PonsFileFactory() {
        nr = 0;
        isKykgat = false;
    }

    public String createPonsFile(){
        String holeText = createHoleText();
        PonsFile ponsFile = new PonsFile(profile.getLength(),nr,profile.getName());
        return ponsFile.createPonsFile() + holeText;
    }

    private String createHoleText(){
        StringBuilder holeTextBuilder = new StringBuilder();
        if (isKykgat){
            createLine(holeTextBuilder,KYKGAT_X,KYKGAT_UNR);
        }
        for (Hole hole : profile.getHoles()){
            createLine(holeTextBuilder,hole);
        }
        return holeTextBuilder.toString();
    }

    private void createLine(StringBuilder stringBuilder,Hole hole){
        createLine(stringBuilder,Double.toString(hole.getX()),Double.toString(hole.getUNr()));
    }
    private void createLine(StringBuilder stringBuilder,String x, String uNr){
        stringBuilder.append(getNR());
        stringBuilder.append(x);
        stringBuilder.append(ROW_TEXT);
        stringBuilder.append(uNr);
        stringBuilder.append(NEWLINE);
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        this.nr = 0;
    }

    public void setKykgat(boolean kykgat) {
        isKykgat = kykgat;
    }

    private String getPaddedNr(int nr, String padding){
       return String.format(padding,nr);
    }

    private String getNR(){
        String number = getPaddedNr(nr,PADDING_NR);
        nr++;
        return number;
    }
    private String getUNR(int unr){
        return getPaddedNr(unr,PADDING_UNR) ;
    }
}