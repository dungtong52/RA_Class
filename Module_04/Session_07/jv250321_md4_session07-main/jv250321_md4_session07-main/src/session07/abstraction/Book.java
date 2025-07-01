package session07.abstraction;

import java.util.Scanner;

public class Book implements IShop{
    @Override
    public void hello() {
        System.out.println("Hello World");
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập thông tin cho sách");
    }

    @Override
    public void displayData() {
        System.out.println("Hiển thị thông tin sách");
    }
}
