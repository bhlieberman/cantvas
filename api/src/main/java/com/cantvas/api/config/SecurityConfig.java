package com.cantvas.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import com.cantvas.api.models.SiteUser;
import com.cantvas.api.repositories.SiteUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(SiteUserRepository userRepo) {
        return username -> {
            SiteUser user = userRepo.findByUsername(username);
            if (user != null) {
                log.info("found user");
                return user;
            }
            throw new UsernameNotFoundException("User" + username + "not found!");
        };
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/courses", "/teachers", "/students")
                .hasRole("USER")
                .requestMatchers("/", "/**").permitAll()
                .and()
                .cors().and().csrf().disable()
                .formLogin(form -> {
                    form.loginPage("/login")
                            .defaultSuccessUrl("/courses", true);
                }).logout(logout -> logout.permitAll());
        return http.build();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(toH2Console());
    }
}
