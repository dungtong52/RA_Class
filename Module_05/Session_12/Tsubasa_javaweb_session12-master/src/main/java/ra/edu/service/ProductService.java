package ra.edu.service;

import ra.edu.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product  getProductById(int productId);
    void insertProduct(Product product); // = persist()
    void deleteProduct(int productId);
    void updateProduct(Product product, int productId);
    List<Product> getProductsByName(String name);
}
