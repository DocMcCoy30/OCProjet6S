package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Secteur;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurResource extends AbstractResource {

    public void createSecteur (Secteur pSecteur) throws TechnicalException {
        getManagerFactory().getSecteurManager().createSecteur(pSecteur);
    }

    public void updateSecteur(Secteur pSecteur) throws TechnicalException {
        getManagerFactory().getSecteurManager().updateSecteur(pSecteur);
    }

    public List<Secteur> getSecteursBySiteId (int pSiteId) {
        return getManagerFactory().getSecteurManager().getSecteursBySiteId(pSiteId);
    }

    public Secteur getSecteurById (int pSecteurId) {
        return getManagerFactory().getSecteurManager().getSecteurById(pSecteurId);
    }


}
