package pl.camp.it.dao;

import pl.camp.it.model.Category;
import java.util.List;

public interface ICategoryDAO {

    void saveCategoryToDatabase(Category category);
    Category getCategoryFromDatabase(int id);
    Category getCategoryFromDatabase(String categoryName);
    List<Category> getAllCategoriesFromDatabase();
    List<Category> getAllCategoriesFromDatabaseWithDeleted();
}
