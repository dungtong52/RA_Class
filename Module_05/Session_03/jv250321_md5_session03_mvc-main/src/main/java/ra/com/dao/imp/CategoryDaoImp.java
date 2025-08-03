package ra.com.dao.imp;

import ra.com.dao.CategoryDao;
import ra.com.entity.Category;
import ra.com.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImp implements CategoryDao {
    @Override
    public List<Category> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Category> categories = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_category()}");
            ResultSet rs = callSt.executeQuery();
            categories = new ArrayList<>();
            while (rs.next()) {
                Category catalog = new Category();
                catalog.setCatalogId(rs.getInt("catalog_id"));
                catalog.setCatalogName(rs.getString("catalog_name"));
                catalog.setDescription(rs.getString("catalog_description"));
                catalog.setStatus(rs.getBoolean("catalog_status"));
                categories.add(catalog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return categories;
    }

    @Override
    public Category findById(int catalogId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Category catalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_by_id(?)}");
            callSt.setInt(1, catalogId);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                catalog = new Category();
                catalog.setCatalogId(rs.getInt("catalog_id"));
                catalog.setCatalogName(rs.getString("catalog_name"));
                catalog.setDescription(rs.getString("catalog_description"));
                catalog.setStatus(rs.getBoolean("catalog_status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return catalog;
    }

    @Override
    public boolean save(Category catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_category(?,?,?)}");
            callSt.setString(1, catalog.getCatalogName());
            callSt.setString(2, catalog.getDescription());
            callSt.setBoolean(3, catalog.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(Category catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_category(?,?,?,?)}");
            callSt.setInt(1, catalog.getCatalogId());
            callSt.setString(2, catalog.getCatalogName());
            callSt.setString(3, catalog.getDescription());
            callSt.setBoolean(4, catalog.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int catalogId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_category(?)}");
            callSt.setInt(1, catalogId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
