package pl.camp.it.services;

import pl.camp.it.dao.ProductDAO;
import pl.camp.it.model.Category;
import pl.camp.it.model.Product;

public class ProductServices {

    public static void generateAndSaveProduct(String name, String amount, String barcode, String categoryName) {
        Product product = new Product();
        product.setName(name);
        product.setAmount(Integer.parseInt(amount));
        product.setBarcode(Long.parseLong(barcode));

        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setDeleted(false);

        product.setCategory(category);

        ProductDAO.saveProductToDatabase(product);
    }
}
