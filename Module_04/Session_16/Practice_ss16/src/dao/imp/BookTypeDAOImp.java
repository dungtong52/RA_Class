package dao.imp;

import entity.BookType;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookTypeDAOImp implements dao.BookTypeDAO {
    @Override
    public List<BookType> getListBookType() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<BookType> bookTypeList = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call get_all_book_type}");

            ResultSet resultSet = callableStatement.executeQuery();
            bookTypeList = new ArrayList<>();
            while (resultSet.next()) {
                BookType bookType = new BookType();
                bookType.setId(resultSet.getInt("id"));
                bookType.setName(resultSet.getString("name"));
                bookType.setDescription(resultSet.getString("description"));
                bookType.setStatus(resultSet.getBoolean("status"));

                bookTypeList.add(bookType);
            }
            connection.commit();

        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.err.println("Có lỗi trong quá trình rollback: " + ex.getMessage());
                }
            }
            System.err.println("Có lỗi trong quá trình lấy danh sách danh mục: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return bookTypeList;
    }

    @Override
    public boolean checkExistBookType(String name) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call check_exist_book_type(?)}");
            callableStatement.setString(1, name);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                connection.commit();
                return true;
            }
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.err.println("Có lỗi trong quá trình rollback: " + ex.getMessage());
                }
            }
            System.err.println("Có lỗi trong quá trình kiểm tra: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return false;
    }

    @Override
    public boolean addBookType(BookType bookType) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call add_book_type(?, ?)}");
            callableStatement.setString(1, bookType.getName());
            callableStatement.setString(2, bookType.getDescription());
            callableStatement.executeUpdate();
            connection.commit();
            return true;
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.err.println("Có lỗi trong quá trình rollback: " + ex.getMessage());
                }
            }
            System.err.println("Có lỗi trong quá trình thêm danh mục: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return false;
    }

    @Override
    public BookType getBookTypeById(int id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        BookType bookType = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call get_book_type_by_id(?)}");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            bookType = new BookType();
            if (resultSet.next()) {
                bookType.setId(resultSet.getInt("id"));
                bookType.setName(resultSet.getString("name"));
                bookType.setDescription(resultSet.getString("description"));
                bookType.setStatus(resultSet.getBoolean("status"));
                connection.commit();
            }
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.err.println("Có lỗi trong quá trình rollback: " + ex.getMessage());
                }
            }
            System.err.println("Có lỗi trong quá trình lấy danh mục theo ID: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return bookType;
    }

    @Override
    public boolean updateBookType(int id, BookType bookType) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call update_book_type(?,?,?,?)}");
            callableStatement.setInt(1, id);
            callableStatement.setString(2, bookType.getName());
            callableStatement.setString(3, bookType.getDescription());
            callableStatement.setBoolean(4, bookType.isStatus());
            callableStatement.executeUpdate();
            connection.commit();
            return true;
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.err.println("Có lỗi trong quá trình rollback: " + ex.getMessage());
                }
            }
            System.err.println("Có lỗi trong quá trình update book type: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return false;
    }

    @Override
    public boolean deleteBookType(int id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call delete_book_type(?)}");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
            connection.commit();
            return true;
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    System.err.println("Có lỗi trong quá trình rollback: " + ex.getMessage());
                }
            }
            System.err.println("Có lỗi trong quá trình delete book type: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return false;
    }
}
