package pl.camp.it.services;

import pl.camp.it.dao.CategoryDAO;
import pl.camp.it.dao.ICategoryDAO;
import pl.camp.it.model.Category;

public class CategoryServices implements ICategoryService{

    public static ICategoryDAO iCategoryDAO = new CategoryDAO();

    @Override
    public void generateAndSaveCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setDeleted(false);

        iCategoryDAO.saveCategoryToDatabase(category);
    }

}
