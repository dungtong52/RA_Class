package session07.abstraction;

import java.util.Scanner;

public class Product implements IShop{
    @Override
    public void hello() {
        System.out.println("Bonjour");
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập thông tin cho sản phẩm");
    }

    @Override
    public void displayData() {
        System.out.println("Hiển thị thông tin sản phẩm");
    }
}
