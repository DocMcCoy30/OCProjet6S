package org.dmc30.OCprojet6.consumer.securityResource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Named;

@Named
public class PasswordEncoderHelper {

    Logger logger = LogManager.getLogger(PasswordEncoderHelper.class);

    public String passwordEncoder(String pPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(pPassword);
    }

    public boolean comparePassword (String candidatePassword, String hashedPassword) {
        boolean match;
        logger.debug("Nouveau mot de passe = " + candidatePassword);
        logger.debug("Ancien mot de passe = " + hashedPassword);
        match = BCrypt.checkpw(candidatePassword, hashedPassword);
        return match;
    }
}
