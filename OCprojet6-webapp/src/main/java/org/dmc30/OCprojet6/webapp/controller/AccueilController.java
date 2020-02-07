package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Photo;
import org.dmc30.OCprojet6.webapp.resource.PhotoResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;


@Controller
public class AccueilController extends AbstractController {

    @Inject
    PhotoResource photoResource;

    Logger logger = LogManager.getLogger();

    @GetMapping({"/", "/accueil"})
    public ModelAndView welcomePage(Model pModel) {
        List<Photo> vListPhotos = photoResource.getAllPhotos();
        ModelAndView vMaV = new ModelAndView("accueil");
        vMaV.addObject("listPhotos", vListPhotos);
        afficherListe(pModel);
        return vMaV;
    }

    @GetMapping("/showSearchSitePage")
    public ModelAndView showSearchSitePage(Model pModel) {
        afficherListe(pModel);
        ModelAndView vMaV = new ModelAndView();
        vMaV.setViewName("recherche-site");
        return vMaV;
    }

    @GetMapping("/tb")
    public String testBootstrap() {
        return "testBootstrap";
    }

}

