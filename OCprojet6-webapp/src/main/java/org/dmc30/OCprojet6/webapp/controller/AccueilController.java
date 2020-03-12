package org.dmc30.OCprojet6.webapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmc30.OCprojet6.model.bean.*;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.dmc30.OCprojet6.webapp.resource.TopoResource;
import org.dmc30.OCprojet6.webapp.resource.UserResource;
import org.dmc30.OCprojet6.webapp.resource.CommentaireResource;
import org.dmc30.OCprojet6.webapp.resource.PhotoResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AccueilController extends AbstractController {

    @Inject
    PhotoResource photoResource;
    @Inject
    CommentaireResource commentaireResource;
    @Inject
    UserResource userResource;
    @Inject
    TopoResource topoResource;

    Logger logger = LogManager.getLogger(AccueilController.class);

    /**
     * Affiche la page d'accueil.
     *
     * @param pModel Les données qui alimentent les liste déroulantes.
     * @return La liste des photos et la vue.
     */
    @GetMapping({"/", "/accueil"})
    public ModelAndView showWelcomePage(Model pModel) {
        List<Photo> vListPhotos = photoResource.getAllPhotos();
        ModelAndView vMaV = new ModelAndView("accueil");
        vMaV.addObject("photos", vListPhotos);
        afficherListe(pModel);
        return vMaV;
    }

    /**
     * Affiche la page de recherche de sites
     *
     * @param pModel Les données qui alimentent les liste déroulantes.
     * @return la vue.
     */
    @GetMapping("/showSearchSitePage")
    public ModelAndView showSearchSitePage(Model pModel) {
        afficherListe(pModel);
        ModelAndView vMaV = new ModelAndView();
        vMaV.setViewName("recherche-site");
        return vMaV;
    }

    @GetMapping("/jsTestPage")
    public ModelAndView jsTestPage(Model pModel) {
        ModelAndView vMav = new ModelAndView();
        afficherListe(pModel);
        return vMav;
    }

    /**
     * Affiche la page personnelle d'un utilisateur
     *
     * @return la vue avec :
     * Pour les utilisateurs : la liste des sites enregistrés dans "mes sites".
     * Pour les administrateurs : la lsite des commentaires à valider, la liste des utilisateurs et leur rôle pour modification
     */
    @GetMapping("/showPagePerso")
    public ModelAndView showPagePerso(@RequestParam(value = "userName") String pUserName) throws TechnicalException {
        ModelAndView vMaV = new ModelAndView();
        List<Commentaire> vListCommentaire = new ArrayList<>();
        List<Users> vListUsers = new ArrayList<>();
        List<Topo> vListTopos = new ArrayList<>();

        //Lister les sites enregistrés, topos, réservations liés à l'utilisateur
        logger.debug("Page perso du User : " + pUserName);
        vListTopos = topoResource.getTopoByUser(pUserName);
        for (Topo vTopo:vListTopos
             ) {
            List<TopoReservation> vTopoReservations = topoResource.getTopoReservationsByTopoId(vTopo.getId());
            vTopo.setListReservations(vTopoReservations);
        }
        //récupérer la liste des commentaires non validés
        vListCommentaire = commentaireResource.getNonValidatedCommentaires();
        //récupérer la liste des utilisateurs et leur role
        vListUsers = userResource.getAllUsers();
        for (Users vUser : vListUsers
        ) {
            UserRoles userRole = userResource.getUserRoleByUsername(vUser.getUsername());
            vUser.setUserRole(userRole.getUserRole());
        }

        vMaV.addObject("topos", vListTopos);
        vMaV.addObject("users", vListUsers);
        vMaV.addObject("commentaires", vListCommentaire);
        vMaV.setViewName("page-perso");
        return vMaV;
    }

}

