package com.ksprofiel.ponstekla.factories;

import com.ksprofiel.ponstekla.models.FileFilter;
import com.ksprofiel.ponstekla.models.Profile;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.LinkedList;

public class ProfileFactory {

    public LinkedList<Profile> createAllProfiles(ObservableList<File> files){
        LinkedList<Profile> profiles = new LinkedList<>();
        for (File file:files
             ) {
            profiles.add( createProfile( file ) );
        }
        return profiles;
    }

    private Profile createProfile(File file){
        Profile profile = new Profile();
        profile.setName(file.getName());
        profile.setHoles(FileFilter.findHoles(file));
        profile.setContourAK(FileFilter.findContour(file));


        return profile;
    }

}
