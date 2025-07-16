package business.imp;

import business.BookTypeBusiness;
import dao.BookTypeDAO;
import dao.imp.BookTypeDAOImp;
import entity.BookType;

import java.util.List;

public class BookTypeBusinessImp implements BookTypeBusiness {
    private BookTypeDAO bookTypeDAO;

    public BookTypeBusinessImp() {
        bookTypeDAO = new BookTypeDAOImp();
    }

    @Override
    public List<BookType> findAllBookTypes() {
        return bookTypeDAO.findAll();
    }

    @Override
    public boolean checkNameExist(String typeName) {
        return bookTypeDAO.checkNameExist(typeName);
    }

    @Override
    public boolean createBookType(BookType bookType) {
        return bookTypeDAO.save(bookType);
    }

    @Override
    public BookType findBookTypeById(int typeId) {
        return bookTypeDAO.findById(typeId);
    }

    @Override
    public boolean updateBookType(BookType bookType) {
        return bookTypeDAO.update(bookType);
    }

    @Override
    public boolean deleteBookType(int typeId) {
        return bookTypeDAO.delete(typeId);
    }
}
