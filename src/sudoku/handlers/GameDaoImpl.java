package sudoku.handlers;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import sudoku.models.Game;
import sudoku.misc.HibernateUtils;
import sudoku.models.Users;

/**
 *
 * @author Waldo
 */
public class GameDaoImpl implements GameDao {

    @Override
    public boolean addGame(Game game) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        Transaction tx = null;
        boolean status = false;
        
        try {
            tx = session.beginTransaction();
            session.save(game);
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
    public boolean modifyGame(Game game) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        Transaction tx = null;
        boolean status = false;
        
        try {
            tx = session.beginTransaction();
            session.merge(game);
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
    public boolean deleteGame(int game_id) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        Transaction tx = null;
        boolean status = false;
        try {
            tx = session.beginTransaction();
            Game game = (Game) session.load(Game.class, game_id);
            session.delete(game);
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
    public Game getGameByID(int game_id) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        Transaction tx = null;
        Game game = null;
        
        try {
            tx = session.beginTransaction();
            game = (Game) session.load(Game.class, game_id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return game;
    }

    @Override
    public List<Game> retrieveAllUserGames(Users user, boolean completed) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        List<Game> gameList = null;
        Transaction tx = null;

        try {
            Criteria crit = session.createCriteria(Game.class);            
            crit.setFetchMode("blocks", FetchMode.SELECT);
            crit.add(Restrictions.eq("user",user));
            crit.add(Restrictions.eq("complete", completed));
            List<Game> results = crit.list();
            
            tx = session.beginTransaction();
            gameList = results;
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return gameList;
    }

    @Override
    public boolean checkRow(Game game, int row, int checkVal) {
        int count = 0;
            for(int i = 0; i < 9; ++i)
            {
                if(checkVal == game.getBlocks().get(i + (9 * row)).getValue())
                {
                    count++;
                }
            }            
        return count == 1;
    }
    
    @Override
    public boolean checkColumn(Game game, int col, int checkVal) {
        int count = 0;
            for(int i = 0; i < 9; ++i)
            {
                if(checkVal == game.getBlocks().get((i * 9) + col).getValue())
                {
                    count++;
                }
            }
        return count == 1;
    }

}
