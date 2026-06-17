package com.example.idcard.service;

import java.util.List;

import com.example.idcard.model.Profile;

public interface ProfileService {
    Profile create(Profile profile);
    Profile getById(Long id);
    List<Profile> getAll();
    Profile update(Long id, Profile profile);
    void delete(Long id);
}
