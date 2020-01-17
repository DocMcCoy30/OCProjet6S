package org.dmc30.OCprojet6.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Accueil {

    @GetMapping(value = {"/", "/accueil"})
    public String showWelcomePage() {
        return "accueil";
    }
}
