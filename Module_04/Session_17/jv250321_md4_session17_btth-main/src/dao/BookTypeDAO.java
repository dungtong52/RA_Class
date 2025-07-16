package dao;

import entity.BookType;

import java.util.List;

public interface BookTypeDAO {
    //Danh sách
    List<BookType> findAll();

    //Thêm mới
    boolean checkNameExist(String typeName);

    boolean save(BookType bookType);

    //Cập nhật
    BookType findById(int typeId);

    boolean update(BookType bookType);

    //Xóa
    boolean delete(int typeId);
}
