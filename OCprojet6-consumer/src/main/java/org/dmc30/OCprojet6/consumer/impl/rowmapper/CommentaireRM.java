package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.SiteDao;
import org.dmc30.OCprojet6.consumer.contract.dao.UsersDao;
import org.dmc30.OCprojet6.model.bean.Commentaire;
import org.dmc30.OCprojet6.model.bean.Site;
import org.dmc30.OCprojet6.model.bean.Users;
import org.dmc30.OCprojet6.model.exception.TechnicalException;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class CommentaireRM implements RowMapper<Commentaire> {

    @Inject
    SiteDao siteDao;
    @Inject
    UsersDao usersDao;

    @Override
    public Commentaire mapRow(ResultSet resultSet, int i) throws SQLException {
        Commentaire vCommentaire = new Commentaire(resultSet.getInt("commentaire_id"),
                resultSet.getString("commentaire"));
        // utilisation de dao
        Site vSite = siteDao.getSiteById(resultSet.getInt("site_id"));
        vCommentaire.setSite(vSite);
        Users vUsers = null;
        try {
            vUsers = usersDao.getUsersByName(resultSet.getString("users_username"));
        } catch (TechnicalException e) {
            e.printStackTrace();
        }
        vCommentaire.setUsers(vUsers);
        return vCommentaire;
    }
}
