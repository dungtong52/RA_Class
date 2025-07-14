package business.imp;

import business.BookBusiness;
import dao.BookDAO;
import dao.imp.BookDAOImp;
import entity.Book;
import validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookBusinessImp implements BookBusiness {
    private final BookDAO bookDAO;

    public BookBusinessImp() {
        bookDAO = new BookDAOImp();
    }

    @Override
    public void getListBook() {
        List<Book> bookList = bookDAO.getListBookSortPriceASC();
        if (bookList != null) {
            System.out.println("Danh sách sách: ");
            bookList.forEach(System.out::println);
        } else {
            System.err.println("Chưa có sách!");
        }

    }

    @Override
    public void addBook(Scanner scanner) {
        while (true) {
            Book newBook = new Book();
            String name = newBook.inputBookName(scanner);
            boolean isExist = bookDAO.checkExistBookName(name);
            if (!isExist) {
                newBook.setBookId(newBook.inputBookId(scanner));
                newBook.setBookName(name);
                newBook.setBookTitle(newBook.inputBookTitle(scanner));
                newBook.setBookPages(newBook.inputBookPages(scanner));
                newBook.setAuthor(newBook.inputAuthor(scanner));
                newBook.setBookPrice(newBook.inputPrice(scanner));
                newBook.setTypeId(newBook.inputTypeId(scanner));
                newBook.setBookStatus(true);
                boolean success = bookDAO.addBook(newBook);
                if (success) {
                    System.out.println("Thêm sách thành công");
                } else {
                    System.err.println("Thêm sách thất bại!");
                }
                break;
            } else {
                System.err.println("Tên sách này đã tồn tại. Nhập vào tên khác!");
            }
        }
    }

    @Override
    public void addBatchBook(Scanner scanner) {
        List<Book> batchBook = new ArrayList<>();
        System.out.print("Nhập số sách muốn thêm: ");
        String number = scanner.nextLine();
        if (Validation.isPositiveInteger(number)) {
            for (int i = 0; i < Integer.parseInt(number); i++) {
                System.out.printf("Nhập thông tin sách thứ %d\n", i + 1);
                while (true) {
                    Book newBook = new Book();
                    String name = newBook.inputBookName(scanner);
                    boolean isExist = bookDAO.checkExistBookName(name);
                    if (!isExist) {
                        newBook.setBookId(newBook.inputBookId(scanner));
                        newBook.setBookName(name);
                        newBook.setBookTitle(newBook.inputBookTitle(scanner));
                        newBook.setBookPages(newBook.inputBookPages(scanner));
                        newBook.setAuthor(newBook.inputAuthor(scanner));
                        newBook.setBookPrice(newBook.inputPrice(scanner));
                        newBook.setTypeId(newBook.inputTypeId(scanner));
                        newBook.setBookStatus(true);
                        batchBook.add(newBook);
                        break;
                    } else {
                        System.err.println("Tên sách này đã tồn tại. Nhập vào tên khác!");
                    }
                }
            }
            boolean success = bookDAO.addBatchBook(batchBook);
            if (success) {
                System.out.println("Thêm sách thành công");
            } else {
                System.err.println("Thêm sách thất bại!");
            }
        } else {
            System.err.println("Phải nhập số nguyên dương!");
        }
    }

    @Override
    public void updateBook(Scanner scanner) {
        System.out.print("Nhập vào mã sách muốn cập nhật: ");
        String id = scanner.nextLine();
        if (Validation.isValidLength(id, 5)) {
            Book bookUpdate = bookDAO.getBookById(id);
            if (bookUpdate != null) {
                boolean exit = false;
                boolean success;
                while (!exit) {
                    System.out.println("1. Cập nhật tên sách");
                    System.out.println("2. Cập nhật tiêu đề sách");
                    System.out.println("3. Cập nhật số trang sách");
                    System.out.println("4. Cập nhật tác giả");
                    System.out.println("5. Cập nhật giá sách");
                    System.out.println("6. Cập nhật danh mục");
                    System.out.println("7. Cập nhật trạng thái");
                    System.out.println("8. Thoát cập nhật");
                    System.out.print("Lựa chọn của bạn: ");
                    String choice = scanner.nextLine();
                    if (Validation.isIntegerInRange(choice, 1, 4)) {
                        switch (Integer.parseInt(choice)) {
                            case 1:
                                while (true) {
                                    String name = bookUpdate.inputBookName(scanner);
                                    boolean isExist = bookDAO.checkExistBookName(name);
                                    if (!isExist) {
                                        bookUpdate.setBookName(name);
                                        success = bookDAO.updateBook(id, bookUpdate);
                                        if (success) {
                                            System.out.println("Cập nhật thành công");
                                        } else {
                                            System.err.println("Cập nhật thất bại!");
                                        }
                                        break;
                                    } else {
                                        System.err.println("Tên sách này đã tồn tại. Nhập vào tên khác!");
                                    }
                                }
                                break;
                            case 2:
                                bookUpdate.setBookTitle(bookUpdate.inputBookTitle(scanner));
                                success = bookDAO.updateBook(id, bookUpdate);
                                if (success) {
                                    System.out.println("Cập nhật thành công");
                                } else {
                                    System.err.println("Cập nhật thất bại!");
                                }
                                break;
                            case 3:
                                bookUpdate.setBookPages(bookUpdate.inputBookPages(scanner));
                                success = bookDAO.updateBook(id, bookUpdate);
                                if (success) {
                                    System.out.println("Cập nhật thành công");
                                } else {
                                    System.err.println("Cập nhật thất bại!");
                                }
                                break;
                            case 4:
                                bookUpdate.setAuthor(bookUpdate.inputAuthor(scanner));
                                success = bookDAO.updateBook(id, bookUpdate);
                                if (success) {
                                    System.out.println("Cập nhật thành công");
                                } else {
                                    System.err.println("Cập nhật thất bại!");
                                }
                                break;
                            case 5:
                                bookUpdate.setBookPrice(bookUpdate.inputPrice(scanner));
                                success = bookDAO.updateBook(id, bookUpdate);
                                if (success) {
                                    System.out.println("Cập nhật thành công");
                                } else {
                                    System.err.println("Cập nhật thất bại!");
                                }
                                break;
                            case 6:
                                bookUpdate.setTypeId(bookUpdate.inputTypeId(scanner));
                                success = bookDAO.updateBook(id, bookUpdate);
                                if (success) {
                                    System.out.println("Cập nhật thành công");
                                } else {
                                    System.err.println("Cập nhật thất bại!");
                                }
                                break;
                            case 7:
                                bookUpdate.setBookStatus(bookUpdate.inputStatus(scanner));
                                success = bookDAO.updateBook(id, bookUpdate);
                                if (success) {
                                    System.out.println("Cập nhật thành công");
                                } else {
                                    System.err.println("Cập nhật thất bại!");
                                }
                                break;
                            default:
                                exit = true;
                        }
                    } else {
                        System.err.println("Nhập vào số nguyên từ 1-8");
                    }
                }
            } else {
                System.err.println("Sách này không tồn tại!");
            }
        } else {
            System.err.println("Mã nhập vào không hợp lệ!");
        }
    }

    @Override
    public void deleteBook(Scanner scanner) {
        System.out.print("Nhập vào mã sách muốn xóa: ");
        String id = scanner.nextLine();
        if (Validation.isValidLength(id, 5)) {
            Book bookDelete = bookDAO.getBookById(id);
            if (bookDelete != null) {
                System.out.printf("Bạn có chắc chắn muốn xóa %s? (Y/N): ", bookDelete.getBookName());
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    boolean success = bookDAO.deleteBook(id);
                    if (success) {
                        System.out.println("Xóa thành công");
                    } else {
                        System.err.println("Xóa thất bại!");
                    }
                } else {
                    System.out.println("Sách chưa bị xóa!");
                }
            } else {
                System.err.println("Sách này không tồn tại!");
            }
        } else {
            System.err.println("Mã nhập vào không hợp lệ!");
        }
    }

    @Override
    public void findBookByName(Scanner scanner) {
        System.out.println("Nhập vào tên sách cần tìm:");
        String bookName = scanner.nextLine();
        List<Book> bookList = bookDAO.searchBookByName(bookName);
        if (bookList == null) {
            System.out.println("Không tìm thấy sách thỏa mãn điều kiện tìm kiếm");
        } else {
            bookList.forEach(System.out::println);
        }
    }

    @Override
    public void statisticBookByAuthor() {
        bookDAO.statisticBookByAuthor().forEach(System.out::println);
    }
}
