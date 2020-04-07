package org.dmc30.OCprojet6.consumer.impl.rowmapper;

import org.dmc30.OCprojet6.consumer.contract.dao.UsersDao;
import org.dmc30.OCprojet6.model.bean.Commentaire;
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
    UsersDao usersDao;

    @Override
    public Commentaire mapRow(ResultSet resultSet, int i) throws SQLException {
        Commentaire vCommentaire = new Commentaire(resultSet.getInt("commentaire_id"),
                resultSet.getString("commentaire"),
                resultSet.getDate("date_publication"),
                resultSet.getInt("reference_id"),
                resultSet.getInt("ref_id"),
                resultSet.getBoolean("valide"));
        // utilisation de dao
        Users vUsers = null;
        try {
            vUsers = usersDao.getUsersByName(resultSet.getString("username"));
        } catch (TechnicalException e) {
            e.printStackTrace();
        }
        vCommentaire.setUsers(vUsers);
        return vCommentaire;
    }
}
