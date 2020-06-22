package com.ksprofiel.ponstekla.factories;

import com.ksprofiel.ponstekla.models.Hole;
import com.ksprofiel.ponstekla.models.PonsFile;
import com.ksprofiel.ponstekla.models.Profile;

public class PonsFileFactory {

    public static final String NEWLINE = "\n";
    private final String PADDING_UNR = "U%02d";
    private final String PADDING_NR = "%03d=";
    private final String ROW_TEXT = " 0,00 left ";
    private int nr;

    private Profile profile;

    public PonsFileFactory() {
        nr = 0;
    }

    public String createPonsFile(){
        String holeText = createHoleText();
        PonsFile ponsFile = new PonsFile(profile.getLength(),nr,profile.getName());
        return ponsFile.createPonsFile() + holeText;
    }

    private String createHoleText(){
        StringBuilder holeTextBuilder = new StringBuilder();
        for (Hole hole : profile.getHoles()){
            holeTextBuilder.append(getNR());
            holeTextBuilder.append(hole.getX());
            holeTextBuilder.append(ROW_TEXT);
            holeTextBuilder.append(getUNR(hole.getUNr()));
            holeTextBuilder.append(NEWLINE);
        }
        return holeTextBuilder.toString();
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        this.nr = 0;
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