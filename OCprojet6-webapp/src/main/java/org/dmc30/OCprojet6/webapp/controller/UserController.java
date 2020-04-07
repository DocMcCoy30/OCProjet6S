package org.dmc30.OCprojet6.webapp.controller;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.UserRoles;
import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.dmc30.OCprojet6.webapp.resource.UserResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    Logger logger = LogManager.getLogger(UserController.class);

    @Inject
    private UserResource userResource;
    @Inject
    private AccueilController accueilController;

    /**
     * Affiche le formulaire de connexion.
     *
     * @return La vue.
     */
    @GetMapping("/signin")
    public String showUserAccountForm() {
        return "signin";
    }

    /**
     * Gère les erreurs de saisie et la deconnexion.
     *
     * @param error  Les erreurs de connexion.
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
     * Gère la création d'un nouveau compte utilisateur.
     *
     * @param pUsers Le nouvel utilisateur
     * @return Un message de confirmation ou d'erreur.
     */
    @PostMapping("/signup")
    public ModelAndView saveUsers(@ModelAttribute("users") Users pUsers) {
        ModelAndView vModel = new ModelAndView();
        try {
            userResource.createUsers(pUsers);
            vModel.addObject("message", "Votre compte est créé !");
            vModel.setViewName("login");
        } catch (TechnicalException e) {
            vModel.addObject("message", e.getMessage());
            vModel.setViewName("login");
        }
        return vModel;
    }

    @PostMapping("/updateUserRole")
    public void updateUserRole(@RequestParam(value = "username") String pUsername,
                               @RequestParam(value = "newRole") String pNewRole,
                               HttpServletResponse response) throws TechnicalException, IOException {
        logger.debug(pUsername);
        logger.debug(pNewRole);
        UserRoles vUserRoles = userResource.getUserRoleByUsername(pUsername);
        vUserRoles.setUserRole(pNewRole);
        userResource.updateUserRole(vUserRoles);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String vJSONCommentaire = new Gson().toJson(vUserRoles);
        logger.debug("vJSONCommentaire = " + vJSONCommentaire);
        response.getWriter().write(vJSONCommentaire);
    }

    @PostMapping("/updateUserMail")
    public ModelAndView updateUserMail(@RequestParam(value = "username") String pUsername,
                                       @RequestParam(value = "email") String pEmail,
                                       @RequestParam(value = "password", required = false) String pPassword) throws TechnicalException {
        ModelAndView vMaV = new ModelAndView();
        Users vUser = new Users();
        String vMessageSucces = "";
        String vMessageAlert = "";
        try {
            vUser = userResource.getUserByName(pUsername);
            vUser.setEmail(pEmail);
            if (!pPassword.isEmpty()) {
                vUser.setPassword(pPassword);
            } else if (pPassword.isEmpty()) {
                vUser.setPassword("AucuneModificationDemandee");
            }
            userResource.updateUser(vUser);
            vMessageSucces = "Vos données ont été modifiées";
        } catch (TechnicalException e) {
            vMessageAlert = e.getMessage();
        }

        return accueilController.showPagePerso(vUser.getUsername(), vMessageSucces, vMessageAlert);
    }

}