package org.dmc30.OCprojet6.webapp.resource;

import org.dmc30.OCprojet6.model.bean.Voie;
import org.dmc30.OCprojet6.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class VoieResource extends AbstractResource{

    public List<Voie> getVoiesBySecteurId (int pSecteurId) {
        return getManagerFactory().getVoieManager().getVoiesBySecteurId(pSecteurId);
    }

    public void createVoie (Voie pVoie) throws TechnicalException {
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

    public Voie getVoiesById(Integer pVoieId) {
        return getManagerFactory().getVoieManager().getVoieById(pVoieId);
    }

    public void updateVoie(Voie pVoie) throws TechnicalException {
        getManagerFactory().getVoieManager().updateVoie(pVoie);
    }
}
