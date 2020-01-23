package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Departement;
import org.dmc30.OCprojet6.model.bean.Region;
import org.dmc30.OCprojet6.model.bean.Ville;
import org.dmc30.OCprojet6.webapp.resource.GeographicResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping({"/", "/accueil"})
public class AccueilController {

    @Inject
    GeographicResource geographicResource;

    @GetMapping
    public String welcomePage(Model model) {
        List<Region> vListRegions = geographicResource.getListRegions();
        model.addAttribute("regions", vListRegions);

//        Region vRegion = geographicResource.getRegionById(3);  //DEBUG
//        model.addAttribute("region", vRegion);

        List<Departement> vListDepartements = geographicResource.getListDepartements();
        model.addAttribute("departements", vListDepartements);
        List<Ville> vListVilles = geographicResource.getListVilles();
        model.addAttribute("villes", vListVilles);
        return "accueil";
    }

    @GetMapping("/secteurs")
    public String showSecteursPage() {
        return "secteurs";
    }

}

