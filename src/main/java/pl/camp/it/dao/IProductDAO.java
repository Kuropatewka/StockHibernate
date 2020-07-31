package pl.camp.it.dao;

import pl.camp.it.model.Product;
import java.util.List;

public interface IProductDAO {

    void saveProductToDatabase(Product product);
    List<Product> getAllProductsFromDatabase();
    List<Product> getProductByCategoryFromDatabase(int id);
}
