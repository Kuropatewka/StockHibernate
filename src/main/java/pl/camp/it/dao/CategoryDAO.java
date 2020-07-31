package pl.camp.it.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.camp.it.App;
import pl.camp.it.model.Category;
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
    public void deleteCategoryFromDataBase(Category category) {
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
        Query<Category> query = session.createQuery("FROM pl.camp.it.model.Category WHERE id = :id");
        query.setParameter("id", id);
        Category result = query.getSingleResult();
        session.close();
        return result;
    }

    @Override
    public Category getCategoryFromDatabase(String name) {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("FROM pl.camp.it.model.Category WHERE name = :name");
        query.setParameter("name", name);
        Category result = query.getSingleResult();
        session.close();
        return result;
    }

    @Override
    public List<Category> getAllCategoriesFromDatabase() {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("FROM pl.camp.it.model.Category WHERE deleted = false");
        List<Category> categories = query.getResultList();
        session.close();
        return categories;
    }

    @Override
    public List<Category> getAllCategoriesFromDatabaseWithDeleted() {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("FROM pl.camp.it.model.Category");
        List<Category> categories = query.getResultList();
        session.close();
        return categories;
    }

    @Override
    public boolean checkCategoryInDatabase(String category) {
        for (Category category2 : getAllCategoriesFromDatabase()) {
            if(category2.getName().equals(category)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkCategoryInDatabaseWithDeleted(String category) {
        for (Category category2 : getAllCategoriesFromDatabaseWithDeleted()) {
            if(category2.getName().equals(category)) {
                return true;
            }
        }
        return false;
    }
}

