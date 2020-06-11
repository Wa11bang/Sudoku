package sudoku.handlers;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import sudoku.misc.HibernateUtils;
import sudoku.models.Users;

/**
 *
 * @author Waldo
 */
public class UserHandlerExec implements UserHandler {

    @Override
    public boolean addUser(Users user) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        Transaction tx = null;
        boolean status = false;
        
        try {
            tx = session.beginTransaction();
            session.save(user);
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
    public boolean modifyUser(Users user) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        Transaction tx = null;
        boolean status = false;
        
        try {
            tx = session.beginTransaction();
            session.merge(user);
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
    public boolean deleteUser(Users user) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        Transaction tx = null;
        boolean status = false;
        try {
            tx = session.beginTransaction();
            session.delete(user);
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
    public Users getUserByID(String username) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        Transaction tx = null;
        Users user = null;

        try {
            Criteria crit = session.createCriteria(Users.class);
            crit.add(Restrictions.eq("username", username));
            crit.setMaxResults(1);
            List<Users> results = crit.list();
            
            tx = session.beginTransaction();
            if(results.size() > 0)
            {
                user = (Users) results.get(0);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return user;
    }

    @Override
    public List<Users> retrieveAllUsers() {        
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        List<Users> usersList = null;
        Transaction tx = null;

        try {
            Criteria crit = session.createCriteria(Users.class);
            List<Users> results = crit.list();

            tx = session.beginTransaction();
            usersList = results;
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return usersList;
    }

    @Override
    public Users login(String username, String password) {
        SessionFactory sessionFac = HibernateUtils.getSessionFactory();
        Session session = sessionFac.openSession();
        
        Transaction tx = null;
        Users user = null;

        try {
            Criteria crit = session.createCriteria(Users.class);
            crit.add(Restrictions.eq("username", username));
            crit.add(Restrictions.eq("password", password));
            crit.setMaxResults(1);
            List<Users> results = crit.list();
            
            tx = session.beginTransaction();
            if(results.size() > 0)
            {
                user = (Users) results.get(0);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return user;
    }
    
}
