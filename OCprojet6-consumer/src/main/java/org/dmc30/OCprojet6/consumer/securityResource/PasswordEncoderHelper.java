package org.dmc30.OCprojet6.consumer.securityResource;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Named;

@Named
public class PasswordEncoderHelper {

    public String passwordEncoder(String pPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(pPassword);
        return hashedPassword;
    }

    public boolean comparePassword (String candidatePassword, String hashedPassword) {
        boolean match;
        if (BCrypt.checkpw(candidatePassword, hashedPassword))
            match = true;
        else
            match = false;
        return match;
    }
}
