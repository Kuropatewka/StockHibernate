package pl.camp.it.services;

import pl.camp.it.model.Category;
import pl.camp.it.model.Product;

public interface IProductService {

    void generateAndSaveProduct(String name, String amount, String price, String barcode, Category category);
}
