package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurResource extends AbstractResource {

    public Secteur createSecteur (String pNom, String pDescription, int pSiteId) throws TechnicalException {
        Secteur vNewSecteur = new Secteur();
        vNewSecteur.setNom(pNom);
        if (pDescription.isEmpty()) {
            pDescription = "Ajouter une description pour ce site.";
        }
        vNewSecteur.setDescription(pDescription);
        Site vSite = getManagerFactory().getSiteManager().getSiteById(pSiteId);
        vNewSecteur.setSite(vSite);
        getManagerFactory().getSecteurManager().createSecteur(vNewSecteur);
        return vNewSecteur;
    }

    public void updateSecteur(String pSecteurNom, String pDescription, int pSecteurId) throws TechnicalException {
        Secteur vSecteur = getManagerFactory().getSecteurManager().getSecteurById(pSecteurId);
        vSecteur.setNom(pSecteurNom);
        if (pDescription.isEmpty()) {
            pDescription = "Ajouter une description pour ce site.";
        }
        vSecteur.setDescription(pDescription);
        getManagerFactory().getSecteurManager().updateSecteur(vSecteur);
    }

    public List<Secteur> getSecteursBySiteId (int pSiteId) {
        return getManagerFactory().getSecteurManager().getSecteursBySiteId(pSiteId);
    }

    public Secteur getSecteurById (int pSecteurId) {
        return getManagerFactory().getSecteurManager().getSecteurById(pSecteurId);
    }


}
