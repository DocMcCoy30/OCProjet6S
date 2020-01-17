package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.webapp.resource.UsersResource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Inject
    private UsersResource usersResource;

    @GetMapping("/connection")
    public String showConnexionForm() {
        return "formulaire-connection";
    }

    @GetMapping("/creation")
    public String showUserAccountForm() {
        return "formulaire-creation-compte";
    }

    @PostMapping("creationCompte")
    public String saveUsers(@ModelAttribute("users") Users pUsers, HttpServletRequest request) {
        String vMessage, vError;
        String vPath;
        boolean vDoublon = usersResource.rechercheDoublon(pUsers.getUsername());
        if (!vDoublon) {
            usersResource.createUsers(pUsers);
            vMessage = "Votre compte est créé !";
            vPath = "formulaire-creation-compte";
            request.setAttribute("message", vMessage);
        }
        else {
            vError = "L'identifiant existe déjà !";
            vPath = "formulaire-creation-compte";
            request.setAttribute("error", vError);
        }
        return vPath;
}
}
