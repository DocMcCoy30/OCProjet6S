package org.dmc30.OCprojet6.webapp.controller;

import org.dmc30.OCprojet6.model.bean.Region;
import org.dmc30.OCprojet6.webapp.resource.GeographicResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "accueil";
    }

    @GetMapping("/secteurs")
    public String showSecteursPage() {
        return "secteurs";
    }

}

