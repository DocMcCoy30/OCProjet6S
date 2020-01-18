package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.webapp.resource.MainResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Inject
    private MainResource mainResource;

	@GetMapping({"/","/accueil"})
    public String welcomePage() {
	    return "page-accueil";
    }

    @GetMapping("/signin")
    public String showUserAccountForm() {
        return "signin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              @RequestParam(value = "match", required = false) String match) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Identifiant ou mot de passe incorrect !");
		}
		if (logout != null) {
			model.addObject("msg", "Vous êtes deconnecté !");
		}
//		if (match != null) {
//		    model.addObject("match", "Vous êtes connecté");
//        }
		model.setViewName("login");
		return model;
	}

	@GetMapping("/userPage")
    public String showUserPage() {
        return "page-utilisateur";
    }

    @PostMapping("/creationCompte")
    public ModelAndView saveUsers(@ModelAttribute("users") Users pUsers, HttpServletRequest request) {
        ModelAndView vModel = new ModelAndView();
        int[] vResult = mainResource.rechercheDoublon(pUsers);
        if (vResult[0] != 0) {
            vModel.addObject("error", "Cet identifiant existe déjà !");
            vModel.setViewName("signin");
        } else if (vResult[1] != 0) {
            vModel.addObject("error", "Cet email existe déjà !");
            vModel.setViewName("signin");
        } else {
            mainResource.createUsers(pUsers);
            vModel.addObject("message", "Votre compte est créé !");
            vModel.setViewName("signin");
        }
        return vModel;
    }
}