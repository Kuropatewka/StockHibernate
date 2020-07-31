package pl.camp.it.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.camp.it.model.User;
import pl.camp.it.session.SessionFactory;

import java.util.List;

public class UserDAO implements IUserDAO{

    @Override
    public void saveUserToDatabase(User user) {
        Session session = SessionFactory.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUserFromDatabase() {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.camp.it.model.User");
        List<User> result = query.getResultList();
        session.close();
        return result;
    }
}
