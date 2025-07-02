package ra.presentation;

import ra.entity.CategoriesManager;
import ra.entity.ProductManager;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		CategoriesManager categoriesManager = new CategoriesManager();
		ProductManager productManager = new ProductManager();
		do {
			System.out.println(
					"\n******************SHOP MENU*******************\n" +
							"1. Quản lý danh mục sản phẩm\n" +
							"2. Quản lý sản phẩm\n" +
							"3. Thoát");
			System.out.print("Lựa chọn của bạn: ");
			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
				case 1:
					categoriesManager.categoriesMenu(scanner);
					break;
				case 2:
					productManager.productMenu(scanner);
					break;
				case 3:
					System.exit(0);
				default:
					System.err.println("Nhập vào số 1-3");
			}
		} while (true);
	}
}
