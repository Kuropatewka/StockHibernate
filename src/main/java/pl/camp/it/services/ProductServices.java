package pl.camp.it.services;

import pl.camp.it.dao.IProductDAO;
import pl.camp.it.dao.ProductDAO;
import pl.camp.it.model.Category;
import pl.camp.it.model.Product;

import java.util.List;

public class ProductServices implements IProductService{

    public static IProductDAO iProductDAO = new ProductDAO();

    @Override
    public void generateAndSaveProduct(String name, String amount, String price, String barcode, Category category) {
        Product product = new Product();
        product.setName(name);
        product.setAmount(Integer.parseInt(amount));
        product.setPrice(Double.parseDouble(price));
        product.setBarcode(Long.parseLong(barcode));
        product.setCategory(category);

        iProductDAO.saveProductToDatabase(product);
    }

    @Override
    public void generateAndSaveProductWithNewCategory(String name, String amount, String price, String barcode, String category) {
        Product product = new Product();
        product.setName(name);
        product.setAmount(Integer.parseInt(amount));
        product.setPrice(Double.parseDouble(price));
        product.setBarcode(Long.parseLong(barcode));

        Category category1 = new Category();
        category1.setName(category);
        category1.setDeleted(false);
        product.setCategory(category1);

        iProductDAO.saveProductToDatabase(product);

    }

    @Override
    public List<Product> getAllProducts() {
        return iProductDAO.getAllProductsFromDatabase();
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return iProductDAO.getProductByCategoryFromDatabase(category.getId());
    }

    @Override
    public void updateProductCategoryToBrakKategorii(List<Product> products, Category brakKategorii) {
        for (Product product : products) {
            product.setCategory(brakKategorii);
            iProductDAO.saveProductToDatabase(product);
        }
    }
}
