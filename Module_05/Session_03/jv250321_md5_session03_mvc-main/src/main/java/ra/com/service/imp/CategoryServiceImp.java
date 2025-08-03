package ra.com.service.imp;

import ra.com.dao.CategoryDao;
import ra.com.dao.imp.CategoryDaoImp;
import ra.com.entity.Category;
import ra.com.service.CategoryService;

import java.util.List;

public class CategoryServiceImp implements CategoryService {
    //DI - Dependency Injection
    private CategoryDao categoryDao;

    public CategoryServiceImp() {
        categoryDao = new CategoryDaoImp();
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public boolean createCategory(Category catalog) {
        return categoryDao.save(catalog);
    }

    @Override
    public Category findById(int catalogId) {
        return categoryDao.findById(catalogId);
    }

    @Override
    public boolean updateCategory(Category catalog) {
        return categoryDao.update(catalog);
    }

    @Override
    public boolean deleteCategory(int catalogId) {
        return categoryDao.delete(catalogId);
    }
}
