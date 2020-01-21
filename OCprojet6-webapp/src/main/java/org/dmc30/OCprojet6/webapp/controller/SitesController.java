package org.dmc30.OCprojet6.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sites")
public class SitesController {


    @GetMapping
    public String showSitesPage() {
        return "sites";
    }

    @GetMapping("/secteurs")
    public String showSecteursPage(){
        return "secteurs";
    }
}
