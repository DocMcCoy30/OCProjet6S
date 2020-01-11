package org.dmc30.OCprojet6.webapp.servlets;

import org.dmc30.OCprojet6.model.bean.Caracteristique;
import org.dmc30.OCprojet6.webapp.resource.CaracteristiqueResource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/Test")
public class CaracTestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CaracteristiqueResource caracteristiqueResource = new CaracteristiqueResource();
        List<Caracteristique> listeCaracteristiques = caracteristiqueResource.getListCaracteristique();
        request.setAttribute("caracteristiques", listeCaracteristiques);
        this.getServletContext().getRequestDispatcher("/WEB-INF/view/test.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String definition = request.getParameter("definition");
        Caracteristique vCaracteristique = new Caracteristique();
        vCaracteristique.setNom(nom);
        vCaracteristique.setDefinition(definition);
        CaracteristiqueResource caracteristiqueResource = new CaracteristiqueResource();
        caracteristiqueResource.createCaracteristique(vCaracteristique);

        this.getServletContext().getRequestDispatcher("/WEB-INF/view/test.jsp").forward(request,response);


    }
}
