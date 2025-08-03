package ra.com.service;

import ra.com.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    boolean createCategory(Category catalog);

    Category findById(int catalogId);

    boolean updateCategory(Category catalog);

    boolean deleteCategory(int catalogId);
}
