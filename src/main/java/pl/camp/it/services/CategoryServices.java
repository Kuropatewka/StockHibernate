package pl.camp.it.services;

import pl.camp.it.dao.CategoryDAO;
import pl.camp.it.dao.ICategoryDAO;
import pl.camp.it.model.Category;

import java.util.List;

public class CategoryServices implements ICategoryService {

    public static ICategoryDAO iCategoryDAO = new CategoryDAO();

    @Override
    public void generateAndSaveCategory(String name) {
        Category category = new Category();
        category.setName(name);
        category.setDeleted(false);

        iCategoryDAO.saveCategoryToDatabase(category);
    }

    @Override
    public Category getCategoryByName(String name) {
        return iCategoryDAO.getCategoryFromDatabase(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return iCategoryDAO.getAllCategoriesFromDatabase();
    }

    @Override
    public void deleteCategory(Category category) {
        category.setDeleted(true);
        iCategoryDAO.deleteCategoryFromDataBase(category);
    }

    @Override
    public boolean categoryExist(String category) {
        return iCategoryDAO.checkCategoryInDatabase(category);
    }

    @Override
    public boolean categoryExistWithDeleted(String category) {
        return iCategoryDAO.checkCategoryInDatabaseWithDeleted(category);
    }

}
