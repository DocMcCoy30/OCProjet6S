package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AccueilController extends AbstractController{

    Logger logger = LogManager.getLogger();


    @RequestMapping({"/", "/accueil"})
    public ModelAndView welcomePage(Model model) {

        //log test message
        logger.trace("Trace : Into AccueilController");
        logger.debug("Debug : Into AccueilController");
        logger.info("Info : Into AccueilController");
        logger.warn("Warn : Into AccueilController");
        logger.error("Error : Into AccueilController");
        logger.fatal("Fatal : Into AccueilController");

        ModelAndView vMaV = new ModelAndView("accueil");
        afficherListe(model);
        return vMaV;
    }
}

