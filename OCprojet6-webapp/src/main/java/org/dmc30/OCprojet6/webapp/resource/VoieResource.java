package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Voie;

import javax.inject.Named;
import java.util.List;

@Named
public class VoieResource extends AbstractResource{

    public List<Voie> getVoiesBySecteurId (int pSecteurId) {
        return getManagerFactory().getVoieManager().getVoiesBySecteurId(pSecteurId);
    }

    public void createVoie (Voie pVoie) {
        getManagerFactory().getVoieManager().createVoie(pVoie);
    }

    public Integer getHauteurMaxBySecteur(int pSecteurId) {
        return getManagerFactory().getVoieManager().getHauteurMaxBySecteur(pSecteurId);
    }

    public Integer getNbDeVoiesBySecteur(int pSecteurId) {
        return getManagerFactory().getVoieManager().getNbDeVoiesBySecteur(pSecteurId);
    }

    public int[] getCotationMinMaxBySecteur(int pSecteurId) {
        return getManagerFactory().getVoieManager().getCotationMinMaxBySecteur(pSecteurId);
    }
}
