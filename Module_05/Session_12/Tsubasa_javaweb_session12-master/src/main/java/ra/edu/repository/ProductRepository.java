package ra.edu.repository;

import ra.edu.model.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product  findById(int productId);
    void save(Product product); // = persist()
    void delete(int productId);
    void update(Product product, int productId);  // = merge()
    List<Product> findByName(String name);
}
