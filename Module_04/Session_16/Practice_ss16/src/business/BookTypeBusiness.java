package business;

import entity.BookType;

import java.util.Scanner;

public interface BookTypeBusiness {
    void getListBookType();

    void addBookType(Scanner scanner);

    void updateBookType(Scanner scanner);

    void deleteBookType(Scanner scanner);
}
