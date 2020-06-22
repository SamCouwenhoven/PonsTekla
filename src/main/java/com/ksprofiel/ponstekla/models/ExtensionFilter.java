package com.ksprofiel.ponstekla.models;

public enum ExtensionFilter {
    NC("NC Files", "*.nc*"),
    ALL("All Files", "*.*"),
    BEER("Just for Beer", "*.beer");

    private final String text;
    private final String extension;

    ExtensionFilter(String text,String extension){
        this.text = text;
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    public String getText() {
        return text;
    }
}
