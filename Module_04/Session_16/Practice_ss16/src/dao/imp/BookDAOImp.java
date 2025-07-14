package dao.imp;

import dao.BookDAO;
import entity.Book;
import entity.StatisticBook;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImp implements BookDAO {
    @Override
    public List<Book> getListBookSortPriceASC() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Book> bookList = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call get_all_book_sort_price_ASC}");

            ResultSet resultSet = callableStatement.executeQuery();
            bookList = new ArrayList<>();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getString("id"));
                book.setBookName(resultSet.getString("name"));
                book.setBookTitle(resultSet.getString("title"));
                book.setBookPages(resultSet.getInt("pages"));
                book.setBookPrice(resultSet.getFloat("price"));
                book.setAuthor(resultSet.getString("author"));
                book.setTypeId(resultSet.getInt("type_id"));
                book.setTypeName(resultSet.getString("type_name"));
                book.setBookStatus(resultSet.getBoolean("status"));
                bookList.add(book);
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
            System.err.println("Có lỗi trong quá trình lấy sách: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return bookList;
    }

    @Override
    public boolean checkExistBookName(String name) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call check_exist_book_name(?)}");
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
    public boolean addBook(Book book) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call add_book(?,?,?,?,?,?,?)}");
            callableStatement.setString(1, book.getBookId());
            callableStatement.setString(2, book.getBookName());
            callableStatement.setString(3, book.getBookTitle());
            callableStatement.setInt(4, book.getBookPages());
            callableStatement.setString(5, book.getAuthor());
            callableStatement.setFloat(6, book.getBookPrice());
            callableStatement.setInt(7, book.getTypeId());
            callableStatement.setBoolean(8, book.isBookStatus());
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
            System.err.println("Có lỗi trong quá trình thêm sách: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return false;
    }

    @Override
    public boolean addBatchBook(List<Book> bookList) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            for (Book book : bookList) {
                callableStatement = connection.prepareCall("{call add_book(?,?,?,?,?,?,?)}");
                callableStatement.setString(1, book.getBookId());
                callableStatement.setString(2, book.getBookName());
                callableStatement.setString(3, book.getBookTitle());
                callableStatement.setInt(4, book.getBookPages());
                callableStatement.setString(5, book.getAuthor());
                callableStatement.setFloat(6, book.getBookPrice());
                callableStatement.setInt(7, book.getTypeId());
                callableStatement.setBoolean(8, book.isBookStatus());
                callableStatement.executeUpdate();
            }
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
            System.err.println("Có lỗi trong quá trình thêm sách: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return false;
    }

    @Override
    public Book getBookById(String id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        Book book = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call get_book_by_id(?)}");
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            book = new Book();
            if (resultSet.next()) {
                book.setBookId(resultSet.getString("id"));
                book.setBookName(resultSet.getString("name"));
                book.setBookTitle(resultSet.getString("title"));
                book.setBookPages(resultSet.getInt("pages"));
                book.setBookPrice(resultSet.getFloat("price"));
                book.setAuthor(resultSet.getString("author"));
                book.setTypeId(resultSet.getInt("type_id"));
                book.setBookStatus(resultSet.getBoolean("status"));
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
            System.err.println("Có lỗi trong quá trình lấy sách theo ID: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return book;
    }

    @Override
    public boolean updateBook(String id, Book book) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call update_book_type(?,?,?,?,?,?,?,?)}");
            callableStatement.setString(1, id);
            callableStatement.setString(2, book.getBookName());
            callableStatement.setString(3, book.getBookTitle());
            callableStatement.setInt(4, book.getBookPages());
            callableStatement.setString(5, book.getAuthor());
            callableStatement.setFloat(6, book.getBookPrice());
            callableStatement.setInt(7, book.getTypeId());
            callableStatement.setBoolean(8, book.isBookStatus());

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
            System.err.println("Có lỗi trong quá trình update book: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return false;
    }

    @Override
    public boolean deleteBook(String id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call delete_book(?)}");
            callableStatement.setString(1, id);
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
            System.err.println("Có lỗi trong quá trình delete book: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return false;
    }

    @Override
    public List<Book> searchBookByName(String name) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Book> bookList = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call get_book_by_name}");

            ResultSet resultSet = callableStatement.executeQuery();
            bookList = new ArrayList<>();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getString("id"));
                book.setBookName(resultSet.getString("name"));
                book.setBookTitle(resultSet.getString("title"));
                book.setBookPages(resultSet.getInt("pages"));
                book.setBookPrice(resultSet.getFloat("price"));
                book.setAuthor(resultSet.getString("author"));
                book.setTypeId(resultSet.getInt("type_id"));
                book.setTypeName(resultSet.getString("type_name"));
                book.setBookStatus(resultSet.getBoolean("status"));
                bookList.add(book);
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
            System.err.println("Có lỗi trong quá trình lấy sách: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return bookList;
    }

    @Override
    public List<StatisticBook> statisticBookByAuthor() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<StatisticBook> statisticBookList = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);
            callableStatement = connection.prepareCall("{call statistic_book_by_author}");

            ResultSet resultSet = callableStatement.executeQuery();
            statisticBookList = new ArrayList<>();
            while (resultSet.next()) {
                StatisticBook statisticBook = new StatisticBook();
                statisticBook.setAuthor(resultSet.getString("author"));
                statisticBook.setCountBook(resultSet.getInt("count_book"));
                statisticBookList.add(statisticBook);
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
            System.err.println("Có lỗi trong quá trình thống kê sách: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return statisticBookList;
    }
}