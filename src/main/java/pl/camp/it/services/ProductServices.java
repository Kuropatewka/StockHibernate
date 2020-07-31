package pl.camp.it.services;

import pl.camp.it.dao.IProductDAO;
import pl.camp.it.dao.ProductDAO;
import pl.camp.it.model.Category;
import pl.camp.it.model.Product;

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
}
