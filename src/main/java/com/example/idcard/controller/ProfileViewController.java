package com.example.idcard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.idcard.service.ProfileService;

@Controller
public class ProfileViewController {

    private final ProfileService service;

    public ProfileViewController(ProfileService service) {
        this.service = service;
    }

    @GetMapping("/profiles")
    public String list(Model model) {
        model.addAttribute("profiles", service.getAll());
        return "profiles/list";
    }
}