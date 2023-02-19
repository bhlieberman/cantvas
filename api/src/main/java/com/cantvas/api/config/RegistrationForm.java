package com.cantvas.api.config;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cantvas.api.models.SiteUser;

@Data
public class RegistrationForm {
    private String username;
    private String password;

    public SiteUser toUser(PasswordEncoder passwordEncoder) {
        return new SiteUser(username, passwordEncoder.encode(password));
    }
}
