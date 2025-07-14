package presentation;

import validation.Validation;

import java.util.Scanner;

public class Main {
    private final BookTypePresentation bookTypePresentation;
    private final BookPresentation bookPresentation;

    public Main() {
        bookPresentation = new BookPresentation();
        bookTypePresentation = new BookTypePresentation();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        while (true) {
            System.out.println("\n********************BOOK MANAGEMENT****************\n" +
                    "1. Quản lý loại sách\n" +
                    "2. Quản lý sách\n" +
                    "3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine();
            if (Validation.isIntegerInRange(choice, 1, 3)) {
                switch (Integer.parseInt(choice)) {
                    case 1 -> main.bookTypePresentation.showMenu(scanner);
                    case 2 -> main.bookPresentation.showMenu(scanner);
                    default -> System.exit(0);
                }
            } else {
                System.err.println("Nhập vào số nguyên từ 1-3");
            }
        }
    }
}
