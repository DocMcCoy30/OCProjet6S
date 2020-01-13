package org.dmc30.OCprojet6.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UtilisateurController {

    @GetMapping("/connection")
    public String showConnexionForm () {
        return "formulaire-connection";
    }

    @GetMapping("/creation")
    public String showUserAccountForm () {
        return "formulaire-creation-compte";
    }
}
