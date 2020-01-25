package org.dmc30.OCprojet6.consumer.impl.dao;

import org.dmc30.OCprojet6.consumer.contract.dao.CommentaireDao;
import org.dmc30.OCprojet6.consumer.impl.rowmapper.CommentaireRM;
import org.dmc30.OCprojet6.model.bean.Commentaire;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireDaoImpl extends AbstractDao implements CommentaireDao {

    @Inject
    CommentaireRM commentaireRM;

    @Override
    public void createCommentaire(Commentaire pCommentaire) {

    }

    @Override
    public Commentaire getCommentaireById(int pId) {
        String vSQL = "SELECT * FROM commentaire WHERE commentaire_id="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Commentaire> vListCommentaires = vJdbcTemplate.query(vSQL, commentaireRM);
        Commentaire vCommentaire = vListCommentaires.get(0);
        return vCommentaire;
    }

    @Override
    public List<Commentaire> getAllCommentaires() {
        String vSQL = "SELECT * FROM commentaire";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Commentaire> vListCommentaires = vJdbcTemplate.query(vSQL, commentaireRM);
        return vListCommentaires;
    }

    @Override
    public void updateCommentaire(Commentaire pCommentaire) {

    }

    @Override
    public void deleteCommentaire(int pId) {

    }

}
