package ra.com.dao;

import ra.com.entity.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();

    Category findById(int catalogId);

    boolean save(Category catalog);

    boolean update(Category catalog);

    boolean delete(int catalogId);
}
