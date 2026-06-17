package com.example.idcard.service.impl;

import com.example.idcard.model.Profile;
import com.example.idcard.repository.ProfileRepository;
import com.example.idcard.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile update(Long id, Profile profile) {
        Profile existing = getById(id);
        existing.setFullName(profile.getFullName());
        existing.setEmail(profile.getEmail());
        existing.setPhone(profile.getPhone());
        existing.setDepartment(profile.getDepartment());
        existing.setType(profile.getType());
        return profileRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        profileRepository.deleteById(id);
    }
}