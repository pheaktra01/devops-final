package com.example.idcard.builder;

import com.example.idcard.model.Profile;
import com.example.idcard.model.ProfileType;

public class ProfileBuilder {

    private Profile profile = new Profile();

    public ProfileBuilder fullName(String name) {
        profile.setFullName(name);
        return this;
    }

    public ProfileBuilder email(String email) {
        profile.setEmail(email);
        return this;
    }

    public ProfileBuilder type(ProfileType type) {
        profile.setType(type);
        return this;
    }

    public Profile build() {
        return profile;
    }
}
