package pl.camp.it.services;

import pl.camp.it.dao.CategoryDAO;
import pl.camp.it.model.Category;

public class CategoryServices {

    public static void generateAndSaveCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setExist(false);

        CategoryDAO.saveCategoryToDatabase(category);
    }
}
