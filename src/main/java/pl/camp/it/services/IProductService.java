package pl.camp.it.services;

import pl.camp.it.model.Category;
import pl.camp.it.model.Product;
import java.util.List;

public interface IProductService {

    void generateAndSaveProduct(String name, String amount, String price, String barcode, Category category);
    void generateAndSaveProductWithNewCategory(String name, String amount, String price, String barcode, String categoryName);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Category categoryName);
    void updateProductCategoryToBrakKategorii(List<Product> products, Category brakkategorii);
}
