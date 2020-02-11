package org.dmc30.OCprojet6.webapp.controller;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.webapp.resource.SiteResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AutoSearchController {

    Logger logger = LogManager.getLogger(AutoSearchController.class);

    @Inject
    SiteResource siteResource;

    @GetMapping("/AutocompleteController")
    public void autocompleteTheSearchInput(@RequestParam(value = "term") String pTerm,
                                           HttpServletResponse response) throws IOException {

        List<String> vListSearchResult = new ArrayList<>();
        logger.debug("le Term est = " + pTerm);

        List<Site> vListSites = siteResource.getMatchingSites(pTerm);
        for (Site vSite : vListSites
        ) {
            String vNomSite = vSite.getNom();
            logger.debug("Noms des sites : " + vNomSite);
            vListSearchResult.add(vNomSite);
            logger.debug("Liste des sites correspondants au mot clé = " + vSite.getNom());
        }

        // test tuto JQueryUI autocomplete
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String vJSONSearchResult = new Gson().toJson(vListSearchResult);
        logger.debug("JSON searchList = " + vJSONSearchResult);

        response.getWriter().write(vJSONSearchResult);
    }


}
