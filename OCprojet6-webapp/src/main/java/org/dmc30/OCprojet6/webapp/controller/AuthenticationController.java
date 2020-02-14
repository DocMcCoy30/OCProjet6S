package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.dmc30.OCprojet6.webapp.resource.AuthenticationResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class AuthenticationController {

    @Inject
    private AuthenticationResource authenticationResource;

    /**
     * Affiche le formulaire de connexion.
     * @return La vue.
     */
    @GetMapping("/signin")
    public String showUserAccountForm() {
        return "signin";
    }

    /**
     * Gère les erreurs de saisie et la deconnexion.
     * @param error Les erreurs de connexion.
     * @param logout L'information de déconnexion.
     * @return Les messages et la vue.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Identifiant ou mot de passe incorrect !");
        }
        if (logout != null) {
            model.addObject("msg", "Vous êtes deconnecté !");
        }
        model.setViewName("login");
        return model;
    }

    /**
     * Gère la création d'un nouveau compte utilisateur (avec recherche de doublons username et email => un bug dans Postgrès+IntelliJ
     * ne permet pas de récupérer les erreurs de contrainte d'unicité...
     * @param pUsers Le nouvel utilisateur
     * @return Un message de confirmation ou d'erreur.
     */
    @PostMapping("/signup")
    public ModelAndView saveUsers(@ModelAttribute("users") Users pUsers) {
        ModelAndView vModel = new ModelAndView();
//        int[] vResult = authenticationResource.rechercheDoublon(pUsers);
//        if (vResult[0] != 0) {
//            vModel.addObject("error", "Cet identifiant existe déjà !");
//            vModel.setViewName("signin");
//        } else if (vResult[1] != 0) {
//            vModel.addObject("error", "Cet email existe déjà !");
//            vModel.setViewName("signin");
//        } else {
            try {
                authenticationResource.createUsers(pUsers);
                vModel.addObject("message", "Votre compte est créé !");
                vModel.setViewName("login");
            }
            catch (TechnicalException e) {
                vModel.addObject("message", e.getMessage());
                vModel.setViewName("login");
            }
//        }
        return vModel;
    }

}