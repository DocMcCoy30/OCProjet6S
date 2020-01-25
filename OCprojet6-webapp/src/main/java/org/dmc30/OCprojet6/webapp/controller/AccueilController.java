package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Region;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Ville;
import org.dmc30.OCprojet6.webapp.resource.GeographicResource;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping({"/", "/accueil"})
public class AccueilController extends AbstractController{

    @Inject
    GeographicResource geographicResource;
    @Inject
    SiteResource siteResource;

    @GetMapping
    public String welcomePage(Model model) {
        afficherListeCommune(model);
        return "accueil";
    }
}

