package business;

import entity.Book;

import java.util.List;
import java.util.Scanner;

public interface BookBusiness {
    void getListBook();

    void addBook(Scanner scanner);

    void addBatchBook(Scanner scanner);

    void updateBook(Scanner scanner);

    void deleteBook(Scanner scanner);

    void findBookByName(Scanner scanner);

    void statisticBookByAuthor();
}
