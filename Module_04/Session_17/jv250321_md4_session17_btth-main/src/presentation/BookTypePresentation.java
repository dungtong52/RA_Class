package presentation;

import business.BookTypeBusiness;
import business.imp.BookTypeBusinessImp;
import entity.BookType;

import java.util.Scanner;

public class BookTypePresentation {
    private final BookTypeBusiness bookTypeBusiness;

    public BookTypePresentation() {
        bookTypeBusiness = new BookTypeBusinessImp();
    }

    public void displayBookTypeMenu(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("**************BOOK TYPE MENU**************");
            System.out.println("1. Danh sách loại sách");
            System.out.println("2. Thêm mới loại sách");
            System.out.println("3. Cập nhật loại sách");
            System.out.println("4. Xóa loại sách");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayListBookType();
                    break;
                case 2:
                    createBookType(scanner);
                    break;
                case 3:
                    udpateBookType(scanner);
                    break;
                case 4:
                    deleteBookType(scanner);
                    break;
                case 5:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (isExit);
    }

    public void displayListBookType() {
        bookTypeBusiness.findAllBookTypes().forEach(System.out::println);
    }

    public String inputTypeName(Scanner scanner) {
        System.out.println("Nhập vào tên loại sách:");
        do {
            String typeName = scanner.nextLine();
            if (typeName != null && !typeName.isEmpty()) {
                if (bookTypeBusiness.checkNameExist(typeName)) {
                    return typeName;
                } else {
                    System.err.println("Tên loại sách đã tồn tại, vui lòng nhập lại");
                }
            } else {
                System.err.println("Vui lòng nhập tên loại sách");
            }
        } while (true);
    }

    public void createBookType(Scanner scanner) {
        BookType bookType = new BookType();
        bookType.setTypeName(inputTypeName(scanner));
        System.out.println("Nhập vào mô tả loại sách:");
        bookType.setDescription(scanner.nextLine());
        boolean result = bookTypeBusiness.createBookType(bookType);
        if (result) {
            System.out.println("Thêm mới thành công");
        } else {
            System.err.println("Có lỗi trong quá trình thêm mới loại sách");
        }
    }

    public void udpateBookType(Scanner scanner) {
        System.out.println("Nhập vào mã loại sách cần cập nhật:");
        int typeId = Integer.parseInt(scanner.nextLine());
        BookType bookType = bookTypeBusiness.findBookTypeById(typeId);
        if (bookType != null) {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên loại sách");
                System.out.println("2. Cập nhật mô tả");
                System.out.println("3. Cập nhật trạng thái");
                System.out.println("4. Thoát");
                System.out.print("Lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        bookType.setTypeName(inputTypeName(scanner));
                        break;
                    case 2:
                        System.out.println("Nhập vào mô tả mới");
                        bookType.setDescription(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập vào trạng thái mới");
                        bookType.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 4:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-3");
                }
            } while (isExit);
        } else {
            System.err.println("Mã loại sách không tồn tại");
        }
        //Cập nhật
        boolean result = bookTypeBusiness.updateBookType(bookType);
        if (result) {
            System.out.println("Cập nhật thành công");
        } else {
            System.err.println("Có lỗi trong quá trình cập nhật loại sách");
        }
    }

    public void deleteBookType(Scanner scanner) {
        System.out.println("Nhập vào mã loại sách cần xóa:");
        int typeId = Integer.parseInt(scanner.nextLine());
        BookType bookType = bookTypeBusiness.findBookTypeById(typeId);
        if (bookType != null) {
            boolean result = bookTypeBusiness.deleteBookType(typeId);
            if (result) {
                System.out.println("Xóa hoặc cập nhật trạng thái loại sách thành công");
            } else {
                System.err.println("Có lỗi trong quá trình xóa loại sách");
            }
        } else {
            System.err.println("Mã loại sách không tồn tại");
        }
    }
}
