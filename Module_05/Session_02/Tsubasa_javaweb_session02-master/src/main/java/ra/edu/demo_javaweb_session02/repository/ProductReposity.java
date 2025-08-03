package ra.edu.demo_javaweb_session02.repository;

import ra.edu.demo_javaweb_session02.db.DBUtility;
import ra.edu.demo_javaweb_session02.entiy.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductReposity {
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = DBUtility.openConnection();
        try {
            pstmt = conn.prepareStatement("select * from products");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product p  = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(conn);
        }

        return products;
    }

    public boolean addProduct(Product p) {
        boolean flag = false;

        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = DBUtility.openConnection();
        try {
            pstmt = conn.prepareStatement("insert into products(name,price) values (?,?)");
            pstmt.setString(1, p.getName());
            pstmt.setDouble(2, p.getPrice());

            int i = pstmt.executeUpdate();
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(conn);
        }

        return flag;
    }
}
