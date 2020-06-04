package com.ksprofiel.ponstekla.models;

public enum ViewFile {
    CHOOSE("views/choose_view_v1.fxml"),
    TEST("views/unique_view.fxml");

    private final String fileName;
    ViewFile(String fileName){
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
