package com.cantvas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cantvas.api.repositories.SiteUserRepository;
import com.cantvas.api.config.RegistrationForm;
import com.cantvas.api.models.SiteUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired private SiteUserRepository siteUserRepo;
    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registrationForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistrationForm(RegistrationForm form) {
        siteUserRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";   
    }
}
