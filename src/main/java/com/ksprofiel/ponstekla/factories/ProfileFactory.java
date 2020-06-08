package com.ksprofiel.ponstekla.factories;

import com.ksprofiel.ponstekla.models.FileFilter;
import com.ksprofiel.ponstekla.models.Profile;
import com.ksprofiel.ponstekla.models.ReadFile;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.LinkedList;

public class ProfileFactory {
    private ObservableList<File> files;

    public ProfileFactory(ObservableList<File> files){
        this.files = files;
    }

    public LinkedList<Profile> createAllProfiles(){
        LinkedList<Profile> profiles = new LinkedList<>();
        for (File file:files
             ) {
            profiles.add( createProfile( file ) );
        }
        return profiles;
    }

    private Profile createProfile(File file){
        Profile newProfile = new Profile();
        newProfile.setHoles(FileFilter.findHoles(file));


        return newProfile;
    }

}
