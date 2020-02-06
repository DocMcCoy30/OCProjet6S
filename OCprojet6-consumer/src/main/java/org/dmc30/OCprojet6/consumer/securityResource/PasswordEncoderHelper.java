package org.dmc30.OCprojet6.consumer.securityResource;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Named;

@Named
public class PasswordEncoderHelper {

    public String passwordEncoder(String pPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(pPassword);
    }

    public boolean comparePassword (String candidatePassword, String hashedPassword) {
        boolean match;
        match = BCrypt.checkpw(candidatePassword, hashedPassword);
        return match;
    }
}
