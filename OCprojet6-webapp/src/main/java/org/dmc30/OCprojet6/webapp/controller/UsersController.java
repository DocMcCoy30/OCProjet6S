package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.webapp.resource.UsersResource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView saveUsers(@ModelAttribute("users") Users pUsers, HttpServletRequest request) {
        ModelAndView vModel = new ModelAndView();
        int [] vResult = usersResource.rechercheDoublon(pUsers);
        if (vResult[0] != 0) {
            vModel.addObject("error", "Cet identifiant existe déjà !");
            vModel.setViewName("formulaire-creation-compte");
        }
        else if (vResult[1] != 0){
            vModel.addObject("error", "Cet email existe déjà !");
            vModel.setViewName("formulaire-creation-compte");
        }
        else {
            usersResource.createUsers(pUsers);
            vModel.addObject("message", "Votre compte est créé !");
            vModel.setViewName("formulaire-creation-compte");
        }
        return vModel;
}
}
