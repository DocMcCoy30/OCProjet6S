package org.dmc30.OCprojet6.webapp.controller;

public class labo {



//    @PostMapping("/searchSites")
//    public ModelAndView searchSites(Model pModel,
//                                    @RequestParam(value = "site", required = false) Integer pSiteId,
//                                    @RequestParam(value = "region", required = false) Integer pRegionId,
//                                    @RequestParam(value = "departement", required = false) Integer pDepartementCode,
//                                    @RequestParam(value = "ville", required = false) Integer pVilleId) {
//        ModelAndView vMaV = new ModelAndView();
//        List<Site> vListSite = null;
//        //DEBUG
//        System.out.println("VilleId = " + pVilleId);
//        System.out.println("DepartementCode = " + pDepartementCode);
//        System.out.println("RegionId = " + pRegionId);
//        System.out.println("SiteId = " + pSiteId);
//        vListSite = siteResource.searchSites(pSiteId, pRegionId, pDepartementCode, pVilleId);
//
//        if (vListSite.size() == 0) {
//            //DEBUG
//            System.out.println("liste = 0");
//            vMaV.addObject("message", "Aucun site ne correspond à vos critères de recherche !");
//        } else {
//            //DEBUG
//            System.out.println("liste > 0");
//            vMaV.addObject("listeSitesSearchResult", vListSite);
//        }
//
//        vMaV.setViewName("accueil");
//        afficherListe(pModel);
//        return vMaV;
//    }
}
