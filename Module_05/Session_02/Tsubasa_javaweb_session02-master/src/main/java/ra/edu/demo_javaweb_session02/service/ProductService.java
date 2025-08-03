package ra.edu.demo_javaweb_session02.service;

import ra.edu.demo_javaweb_session02.entiy.Product;
import ra.edu.demo_javaweb_session02.repository.ProductReposity;

import java.util.List;

public class ProductService {
    private final ProductReposity productReposity;

    public ProductService() {
        productReposity = new ProductReposity();
    }

    public List<Product> getProducts() {
        return productReposity.getProducts();

    }
    public boolean addProduct(Product p) {
        return productReposity.addProduct(p);
    }
}
