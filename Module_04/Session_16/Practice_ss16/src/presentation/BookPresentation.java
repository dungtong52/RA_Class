package presentation;

import business.BookBusiness;
import business.imp.BookBusinessImp;
import validation.Validation;

import java.util.Scanner;

public class BookPresentation {
    private final BookBusiness bookBusiness;

    public BookPresentation() {
        bookBusiness = new BookBusinessImp();
    }

    public void showMenu(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n********************BOOK****************\n" +
                    "1. Danh sách sách\n" +
                    "2. Thêm mới sách\n" +
                    "3. Thêm mới nhiều sách\n" +
                    "4. Cập nhật sách\n" +
                    "5. Xóa sách\n" +
                    "6. Tìm kiếm sách\n" +
                    "7. Thông kê số lượng sách theo tác giả\n" +
                    "8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine();
            if (Validation.isIntegerInRange(choice, 1, 8)) {
                switch (Integer.parseInt(choice)) {
                    case 1 -> bookBusiness.getListBook();
                    case 2 -> bookBusiness.addBook(scanner);
                    case 3 -> bookBusiness.addBatchBook(scanner);
                    case 4 -> bookBusiness.updateBook(scanner);
                    case 5 -> bookBusiness.deleteBook(scanner);
                    case 6 -> bookBusiness.findBookByName(scanner);
                    case 7 -> bookBusiness.statisticBookByAuthor();
                    default -> exit = true;
                }
            } else {
                System.err.println("Nhập vào số nguyên từ 1-8");
            }
        }
    }
}
