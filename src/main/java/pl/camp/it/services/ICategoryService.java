package pl.camp.it.services;

import pl.camp.it.model.Category;
import java.util.List;

public interface ICategoryService {

    void generateAndSaveCategory(String categoryName);
    Category getCategoryByName(String cateogryName);
    List<Category> getAllCategories();
    void deleteCategory(Category category);
    boolean categoryExist(String categoryName);
    boolean categoryExistWithDeleted(String categoryName);
}
