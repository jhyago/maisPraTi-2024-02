package com.example.api_user.service;

import com.example.api_user.dto.ProfileDTO;
import com.example.api_user.model.Profile;
import com.example.api_user.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;


    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Optional<ProfileDTO> getProfile(Long id) {
        return profileRepository.findById(id)
                .map(profile -> new ProfileDTO(profile.getId(), profile.getBio()));
    }

    public Optional<ProfileDTO> updateProfile(Long id, Profile profile) {
        return profileRepository.findById(id)
                .map(existingProfile -> {
                    existingProfile.setBio(profile.getBio());
                    profileRepository.save(existingProfile);
                    return new ProfileDTO(existingProfile.getId(), existingProfile.getBio());
                });
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

}
