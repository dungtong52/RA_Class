package presentation;

import business.BookTypeBusiness;
import business.imp.BookTypeBusinessImp;
import validation.Validation;

import java.util.Scanner;

public class BookTypePresentation {
    private final BookTypeBusiness bookTypeBusiness;

    public BookTypePresentation() {
        bookTypeBusiness = new BookTypeBusinessImp();
    }

    public void showMenu(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n********************BOOK TYPE****************\n" +
                    "1. Danh sách loại sách\n" +
                    "2. Thêm mới loại sách\n" +
                    "3. Cập nhật loại sách\n" +
                    "4. Xóa loại sách\n" +
                    "5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine();
            if (Validation.isIntegerInRange(choice, 1, 5)) {
                switch (Integer.parseInt(choice)) {
                    case 1 -> bookTypeBusiness.getListBookType();
                    case 2 -> bookTypeBusiness.addBookType(scanner);
                    case 3 -> bookTypeBusiness.updateBookType(scanner);
                    case 4 -> bookTypeBusiness.deleteBookType(scanner);
                    default -> exit = true;
                }
            } else {
                System.err.println("Nhập vào số nguyên từ 1-5");
            }
        }
    }
}
