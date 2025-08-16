package ra.edu.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.model.entity.Product;
import ra.edu.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List list = session.createQuery("from Product").list();
        return list;
    }
    @Override
    public Product findById(int productId) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Product.class, productId);
    }

    @Override
    public void save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public void delete(int productId) {
        Product product = findById(productId);
        Session session = sessionFactory.getCurrentSession();
        session.remove(product);
    }

    @Override
    public void update(Product product, int productId) {
        Product p = findById(productId);
        if(p==null)
            throw new NoSuchElementException("Khong ton tai product co id :"+productId);

        product.setProductId(productId);
        Session session = sessionFactory.getCurrentSession();
        session.merge(product);
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        List list = session.createQuery("from Product where productName like :name")
                .setParameter("name",name)
                .getResultList();
        return list;
    }
}
