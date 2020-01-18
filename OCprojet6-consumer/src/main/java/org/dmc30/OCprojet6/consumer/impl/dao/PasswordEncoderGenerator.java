package org.dmc30.OCprojet6.consumer.impl.dao;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Named;

@Named
public class PasswordEncoderGenerator {

    public String passwordEncoder(String pPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(pPassword);
        return hashedPassword;
    }
}
