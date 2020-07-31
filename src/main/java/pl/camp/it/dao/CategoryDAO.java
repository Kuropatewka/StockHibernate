package pl.camp.it.dao;

import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.camp.it.model.Category;
import pl.camp.it.model.Product;
import pl.camp.it.session.SessionFactory;

import java.util.List;

public class CategoryDAO implements ICategoryDAO{

    @Override
    public void saveCategoryToDatabase(Category category) {
        Session session = SessionFactory.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(category);
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
    public Category getCategoryFromDatabase(int id) {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("From pl.camp.it.Category WHERE id = :id");
        query.setParameter("id", id);
        Category result = query.getSingleResult();
        session.close();
        return result;
    }

    @Override
    public Category getCategoryFromDatabase(String categoryName) {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("From pl.camp.it.Category WHERE categoryName = :categoryName");
        query.setParameter("categoryName", categoryName);
        Category result = query.getSingleResult();
        session.close();
        return result;
    }

    @Override
    public List<Category> getAllCategoriesFromDatabase() {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("From pl.camp.it.Category WHERE deleted = false");
        List<Category> categories = query.getResultList();
        session.close();
        return categories;
    }

    @Override
    public List<Category> getAllCategoriesFromDatabaseWithDeleted() {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("From pl.camp.it.Category");
        List<Category> categories = query.getResultList();
        session.close();
        return categories;
    }
}

