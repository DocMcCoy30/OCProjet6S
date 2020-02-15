package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurResource extends AbstractResource {

    public Secteur createSecteur (String pNom, String pDescription, int pSiteId) {
        Secteur vNewSecteur = new Secteur();
        vNewSecteur.setNom(pNom);
        vNewSecteur.setDescription(pDescription);
        Site vSite = getManagerFactory().getSiteManager().getSiteById(pSiteId);
        vNewSecteur.setSite(vSite);
        getManagerFactory().getSecteurManager().createSecteur(vNewSecteur);
        return vNewSecteur;
    }

    public List<Secteur> getSecteursBySiteId (int pSiteId) {
        return getManagerFactory().getSecteurManager().getSecteursBySiteId(pSiteId);
    }

    public Secteur getSecteurById (int pSecteurId) {
        return getManagerFactory().getSecteurManager().getSecteurById(pSecteurId);
    }

}
