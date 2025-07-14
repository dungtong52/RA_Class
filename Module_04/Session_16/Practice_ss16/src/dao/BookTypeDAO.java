package dao;

import entity.BookType;

import java.util.List;

public interface BookTypeDAO {
    List<BookType> getListBookType();

    boolean checkExistBookType(String name);

    boolean addBookType(BookType bookType);

    BookType getBookTypeById(int id);

    boolean updateBookType(int id, BookType bookType);

    boolean deleteBookType(int id);
}
