package com.ksprofiel.ponstekla.models;

public enum ScreenLayout {
    CHOOSE_LAYOUT("choose_view_v1"),
    TEST_LAYOUT("test_view");

    private String fileName;
    ScreenLayout(String fileName){
        this.fileName=fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
