package dao.imp;

import dao.BookTypeDAO;
import entity.BookType;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class BookTypeDAOImp implements BookTypeDAO {
    @Override
    public List<BookType> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<BookType> listBookTypes = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_book_type()}");
            ResultSet rs = callSt.executeQuery();
            listBookTypes = new ArrayList<>();
            while (rs.next()) {
                BookType bookType = new BookType();
                bookType.setTypeId(rs.getInt("type_id"));
                bookType.setTypeName(rs.getString("type_name"));
                bookType.setDescription(rs.getString("type_description"));
                bookType.setStatus(rs.getBoolean("type_status"));
                listBookTypes.add(bookType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listBookTypes;
    }

    @Override
    public boolean checkNameExist(String typeName) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call check_exists_type_name(?,?)}");
            callSt.setString(1, typeName);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();
            int cntBookType = callSt.getInt(2);
            if (cntBookType == 0) {
                return true;//Không trùng
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;//Trùng
    }

    @Override
    public boolean save(BookType bookType) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_new_book_type(?,?)}");
            callSt.setString(1, bookType.getTypeName());
            callSt.setString(2, bookType.getDescription());
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public BookType findById(int typeId) {
        Connection conn = null;
        CallableStatement callSt = null;
        BookType bookType = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_book_type_by_id(?)}");
            callSt.setInt(1, typeId);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                bookType = new BookType();
                bookType.setTypeId(rs.getInt("type_id"));
                bookType.setTypeName(rs.getString("type_name"));
                bookType.setDescription(rs.getString("type_description"));
                bookType.setStatus(rs.getBoolean("type_status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return bookType;
    }

    @Override
    public boolean update(BookType bookType) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_book_type(?,?,?,?)}");
            callSt.setInt(1, bookType.getTypeId());
            callSt.setString(2, bookType.getTypeName());
            callSt.setString(3, bookType.getDescription());
            callSt.setBoolean(4, bookType.isStatus());
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean delete(int typeId) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_book_type(?)}");
            callSt.setInt(1, typeId);
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
