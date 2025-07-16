package business;

import entity.BookType;

import java.util.List;

public interface BookTypeBusiness {
    //Danh sách loại sách
    List<BookType> findAllBookTypes();

    //Thêm mới loại sách
    boolean checkNameExist(String typeName);

    boolean createBookType(BookType bookType);

    //Cập nhật loại sách
    BookType findBookTypeById(int typeId);

    boolean updateBookType(BookType bookType);

    //Xóa
    boolean deleteBookType(int typeId);


}
