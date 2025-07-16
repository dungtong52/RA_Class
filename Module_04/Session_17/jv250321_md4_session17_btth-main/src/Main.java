import presentation.BookTypePresentation;

import java.util.Scanner;

public class Main {
    /*
     * 1. Tạo Database
     * 2. Tạo các bảng
     * 3. Tạo Procedure
     * 4. Tạo lớp ConnectionDB trong util - openConnection, closeConnection
     * 5. Tạo các entity ánh xạ tới các bảng trong CSDL
     * 6. Tạo Interface Dao --> Lớp triển khai DaoImp kế thừa từ Interface
     * 7. Tạo Interface Business --> Lớp triển khai BuisinessImp kế thừa từ Interface --> tiêm Dao vào
     * 8. Triển khai các lớp presentation nếu có để hiển thị menu quản lý
     * 9. Triển khai lớp Main
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookTypePresentation bookTypePresentation = new BookTypePresentation();
        do {
            System.out.println("****************BOOK MANAGEMENT*****************");
            System.out.println("1. Quản lý loại sách");
            System.out.println("2. Quản lý sách");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookTypePresentation.displayBookTypeMenu(scanner);
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-3");
            }
        } while (true);
    }
}
