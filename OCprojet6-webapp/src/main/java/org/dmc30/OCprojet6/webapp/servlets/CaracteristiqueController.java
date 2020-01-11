package org.dmc30.OCprojet6.webapp.servlets;

import org.dmc30.OCprojet6.model.bean.Caracteristique;
import org.dmc30.OCprojet6.webapp.resource.CaracteristiqueResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/caracteristique")
public class CaracteristiqueController {

    @Inject
    private CaracteristiqueResource caracteristiqueResource;

    @GetMapping("/liste")
    public String listCaracteristique (Model theModel) {
        List<Caracteristique> vCaracteristique = caracteristiqueResource.getListCaracteristique();
        theModel.addAttribute("caracteristiques", vCaracteristique);
        System.out.println(theModel.toString());
        return "liste-caracteristique";
    }

    @GetMapping("/formulaireAjout")
    public String showFormForAdd(Model theModel) {
        Caracteristique vCaracteristique = new Caracteristique();
        theModel.addAttribute("caracteristique", vCaracteristique);
        return "formulaire";
    }

    @PostMapping("/ajoutCaracteristique")
    public String saveCustomer (@ModelAttribute("caracteristique") Caracteristique pCaracteristique) {
        System.out.println(pCaracteristique.getNom());
        caracteristiqueResource.createCaracteristique(pCaracteristique);
        return "redirect:/caracteristique/liste";
    }
//
//    @GetMapping("/delete")
//    public String deleteCustomer (@RequestParam("customerId") int theId) {
//        // delete the customer using our service
//        customerService.deleteCustomer(theId);
//        return "redirect:/customer/list";
//    }
}
