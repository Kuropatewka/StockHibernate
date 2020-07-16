package pl.camp.it.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.camp.it.model.Product;
import pl.camp.it.session.SessionFactory;

public class ProductDAO {

    public static void saveProductToDatabase(Product product) {
        Session session = SessionFactory.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

        } finally {
            session.close();
        }
    }
}
