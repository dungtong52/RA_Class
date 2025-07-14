package dao;

import entity.Book;
import entity.StatisticBook;

import java.util.List;

public interface BookDAO {
    List<Book> getListBookSortPriceASC();

    boolean checkExistBookName(String name);

    boolean addBook(Book book);

    boolean addBatchBook(List<Book> bookList);

    Book getBookById(String id);

    boolean updateBook(String id, Book book);

    boolean deleteBook(String id);

    List<Book> searchBookByName(String name);

    List<StatisticBook> statisticBookByAuthor();
}
