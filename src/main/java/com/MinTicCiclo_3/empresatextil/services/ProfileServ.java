package com.MinTicCiclo_3.empresatextil.services;

import com.MinTicCiclo_3.empresatextil.entity.Profile;
import com.MinTicCiclo_3.empresatextil.repositories.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServ {
    @Autowired
    private ProfileRepo profileRepo;

    public List<Profile> getAllProfiles() {

        return (List<Profile>) this.profileRepo.findAll();
    }

    public Profile getProfileById(Long idProfile) {

        Optional<Profile> opcionalProfile = this.profileRepo.findById(idProfile);
        if (opcionalProfile.isEmpty()) {
            return null;
        }
        return opcionalProfile.get();
    }

    public Profile createProfile(Profile newProfile) {

        return this.profileRepo.save(newProfile);
    }

    public void deleteProfile(Long idProfile) {
        this.profileRepo.deleteById(idProfile);
    }
}
