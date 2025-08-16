package ra.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.entity.Product;
import ra.edu.repository.ProductRepository;
import ra.edu.service.ProductService;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findById(productId);
    }

    @Override
    public void insertProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.delete(productId);
    }

    @Override
    public void updateProduct(Product product, int productId) {
        productRepository.update(product, productId);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        if(name==null)
            name = "%";
        else name = "%"+name+"%";
        return productRepository.findByName(name);
    }
}
