/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.handlers;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import sudoku.misc.HibernateUtils;
import sudoku.models.Game;
import sudoku.models.Score;
import sudoku.models.Users;

/**
 *
 * @author Waldo
 */
public class ScoreHandlerExec implements ScoreHandler {

    @Override
    public boolean addScore(Score score) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        Transaction tx = null;
        boolean status = false;
        
        try {
            tx = session.beginTransaction();
            session.save(score);
            tx.commit();
            status = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return status;
    }

    @Override
    public List<Score> getScoresByUser(Users user) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        List<Score> scoreList = null;
        Transaction tx = null;

        try {
            Criteria crit = session.createCriteria(Score.class);            
            crit.add(Restrictions.eq("user",user));
            crit.addOrder(Order.desc("score_id"));
            crit.setMaxResults(20);
            
            List<Score> results = crit.list();

            tx = session.beginTransaction();
            scoreList = results;
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return scoreList;
    }
    
    @Override
    public List<Score> retrieveAllScores() {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        List<Score> scoreList = null;
        Transaction tx = null;

        try {
            Criteria crit = session.createCriteria(Score.class);            
            crit.addOrder(Order.asc("score_time"));

            List<Score> results = crit.list();            
            tx = session.beginTransaction();
            scoreList = results;
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return scoreList;
    }
    
}
