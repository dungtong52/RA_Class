package business.imp;

import business.BookTypeBusiness;
import dao.BookTypeDAO;
import dao.imp.BookTypeDAOImp;
import entity.BookType;
import validation.Validation;

import java.util.List;
import java.util.Scanner;

public class BookTypeBusinessImp implements BookTypeBusiness {
    private final BookTypeDAO bookTypeDAO;

    public BookTypeBusinessImp() {
        bookTypeDAO = new BookTypeDAOImp();
    }

    @Override
    public void getListBookType() {
        List<BookType> bookTypeList = bookTypeDAO.getListBookType();
        if (!bookTypeList.isEmpty()) {
            System.out.println("Danh sách danh mục:");
            bookTypeList.forEach(System.out::println);
        } else {
            System.err.println("Chưa có danh mục sách!");
        }
    }

    @Override
    public void addBookType(Scanner scanner) {
        while (true) {
            BookType bookType = new BookType();
            String name = bookType.inputTypeName(scanner);
            boolean isExist = bookTypeDAO.checkExistBookType(name);
            if (!isExist) {
                bookType.setName(name);
                bookType.setDescription(bookType.inputDescription(scanner));
                bookType.setStatus(true);
                boolean success = bookTypeDAO.addBookType(bookType);
                if (success) {
                    System.out.println("Thêm danh mục thành công");
                } else {
                    System.err.println("Thêm danh mục thất bại!");
                }
                break;
            } else {
                System.err.println("Tên danh mục này đã tồn tại. Nhập vào tên khác!");
            }
        }
    }

    @Override
    public void updateBookType(Scanner scanner) {
        System.out.print("Nhập vào mã danh mục muốn cập nhật: ");
        String typeId = scanner.nextLine();
        if (Validation.isPositiveInteger(typeId)) {
            BookType bookTypeUpdate = bookTypeDAO.getBookTypeById(Integer.parseInt(typeId));
            if (bookTypeUpdate != null) {
                boolean exit = false;
                boolean success;
                while (!exit) {
                    System.out.println("1. Cập nhật tên danh mục");
                    System.out.println("2. Cập nhật mô tả danh mục");
                    System.out.println("3. Cập nhật trạng thái danh mục");
                    System.out.println("4. Thoát cập nhật");
                    System.out.print("Lựa chọn của bạn: ");
                    String choice = scanner.nextLine();
                    if (Validation.isIntegerInRange(choice, 1, 4)) {
                        switch (Integer.parseInt(choice)) {
                            case 1:
                                while (true) {
                                    String name = bookTypeUpdate.inputTypeName(scanner);
                                    boolean isExist = bookTypeDAO.checkExistBookType(name);
                                    if (!isExist) {
                                        bookTypeUpdate.setName(name);
                                        success = bookTypeDAO.updateBookType(Integer.parseInt(typeId), bookTypeUpdate);
                                        if (success) {
                                            System.out.println("Cập nhật tên danh mục thành công");
                                        } else {
                                            System.err.println("Cập nhật tên danh mục thất bại!");
                                        }
                                        break;
                                    } else {
                                        System.err.println("Tên danh mục này đã tồn tại. Nhập vào tên khác!");
                                    }
                                }
                                break;
                            case 2:
                                bookTypeUpdate.setDescription(bookTypeUpdate.inputDescription(scanner));
                                success = bookTypeDAO.updateBookType(Integer.parseInt(typeId), bookTypeUpdate);
                                if (success) {
                                    System.out.println("Cập nhật mô tả danh mục thành công");
                                } else {
                                    System.err.println("Cập nhật mô tả danh mục thất bại!");
                                }
                                break;
                            case 3:
                                bookTypeUpdate.setStatus(bookTypeUpdate.inputStatus(scanner));
                                success = bookTypeDAO.updateBookType(Integer.parseInt(typeId), bookTypeUpdate);
                                if (success) {
                                    System.out.println("Cập nhật trạng thái danh mục thành công");
                                } else {
                                    System.err.println("Cập nhật trạng thái danh mục thất bại!");
                                }
                                break;
                            default:
                                exit = true;
                        }
                    } else {
                        System.err.println("Nhập vào số nguyên từ 1-4");
                    }
                }
            } else {
                System.err.println("Danh mục sách này không tồn tại!");
            }
        } else {
            System.err.println("Mã nhập vào không hợp lệ!");
        }
    }

    @Override
    public void deleteBookType(Scanner scanner) {
        System.out.print("Nhập vào mã danh mục muốn xóa: ");
        String typeId = scanner.nextLine();
        if (Validation.isPositiveInteger(typeId)) {
            BookType bookTypeDelete = bookTypeDAO.getBookTypeById(Integer.parseInt(typeId));
            if (bookTypeDelete != null) {
                System.out.printf("Bạn có chắc chắn muốn xóa danh mục %s? (Y/N): ", bookTypeDelete.getName());
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    boolean success = bookTypeDAO.deleteBookType(Integer.parseInt(typeId));
                    if (success) {
                        System.out.println("Xóa danh mục thành công");
                    } else {
                        System.err.println("Xóa danh mục thất bại!");
                    }
                } else {
                    System.out.println("Danh mục chưa bị xóa!");
                }
            } else {
                System.err.println("Danh mục sách này không tồn tại!");
            }
        } else {
            System.err.println("Mã nhập vào không hợp lệ!");
        }
    }
}
