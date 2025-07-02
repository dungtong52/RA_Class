package ra.entity;

import java.util.Scanner;

public class CategoriesManager {
	public static Categories[] categories = new Categories[100];
	public static int currentCate = 0;

	public CategoriesManager () {
	}

	public void categoriesMenu (Scanner scanner) {
		do {
			System.out.println(
					"\n********************CATEGORIES MENU********************\n" +
							"1. Nhập thông tin các danh mục\n" +
							"2. Hiển thị thông tin các danh mục\n" +
							"3. Cập nhật thông tin danh mục\n" +
							"4. Xóa danh mục\n" +
							"5. Cập nhật trạng thái danh mục\n" +
							"6. Thoát");
			System.out.print("Lựa chọn của bạn: ");
			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
				case 1:
					addCategories(scanner);
					break;
				case 2:
					showAllCategories();
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					return;
				default:
					System.out.println("Nhập vào số trong khoảng 1-6");

			}
		} while (true);
	}

	public void addCategories (Scanner scanner) {
		System.out.printf("Nhập vào số danh mục muốn thêm: ");
		int cntCategory = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < cntCategory; i++) {
			categories[currentCate] = new Categories();
			categories[currentCate].inputDataCategories(scanner);
			currentCate++;
		}
		System.out.println("Đã thêm thành công!");
	}

	public void showAllCategories () {
		System.out.println("Danh sách các danh mục đã có: ");
		System.out.printf("|%-10s|%-15s|%-20s|%10s\n",
				"Catalog ID", "Catalog Name", "Description", "Catalog Status");
		System.out.println("-----------------------------------");
		for (int i = 0; i < currentCate; i++) {
			categories[i].displayData();
			System.out.println("-----------------------------------");
		}
	}

	public void updateCategories (Scanner scanner) {
		System.out.printf("Nhập vào mã danh mục muốn cập nhật: ");
		int catalogIdForUpdate = Integer.parseInt(scanner.nextLine());
		int indexIdUpdate = findIndexById(catalogIdForUpdate);

		if (indexIdUpdate == -1) {
			System.out.println("Mã danh mục không tồn tại");
		} else {
			do {
				System.out.println("1. Cập nhật tên danh mục");
				System.out.println("2. Cập nhật mô tả danh mục");
				System.out.println("3. Thoát cập nhật");
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
					case 1:
						categories[indexIdUpdate].inputCatalogName(scanner);
						break;
					case 2:
						categories[indexIdUpdate].inputDescription(scanner);
						break;
					case 3:
						return;
					default:
						System.err.println("Nhập vào số trong khoảng 1-3");
				}
			} while (true);
		}
	}

	public void deleteCategory (Scanner scanner) {
		System.out.printf("Nhập vào mã danh mục muốn xóa: ");
		int catalogIdForDelete = Integer.parseInt(scanner.nextLine());
		int indexIdDelete = findIndexById(catalogIdForDelete);
		if (indexIdDelete == -1) {
			System.out.println("Mã danh mục không tồn tại");
		} else {
			if (hasProduct(catalogIdForDelete)) {
				System.err.println("Danh mục có chứa sản phẩm. Không thể xóa!");
			} else {
				for (int i = indexIdDelete; i < currentCate - 1; i++) {
					categories[i] = categories[i + 1];
				}
				categories[currentCate - 1] = null;
				currentCate--;
			}
		}
	}

	public void updateCatalogStatus (Scanner scanner) {
		System.out.print("Nhập vào mã danh mục muốn cập nhật trạng thái: ");
		int catalogIdForUpdateStatus = Integer.parseInt(scanner.nextLine());
		int indexIdUpdateStatus = findIndexById(catalogIdForUpdateStatus);

		if (indexIdUpdateStatus == -1) {
			System.out.println("Mã danh mục không tồn tại");
		} else {
			categories[indexIdUpdateStatus].setCatalogStatus(!categories[indexIdUpdateStatus].isCatalogStatus());
		}
		System.out.println("Đã cập nhật trạng thái thành công!");
	}

	public int findIndexById (int id) {
		for (int i = 0; i < currentCate; i++) {
			if (categories[i].getCatalogId() == id) {
				return i;
			}
		}
		return -1;
	}

	public boolean hasProduct (int catalogId) {
		for (int i = 0; i < ProductManager.currentProd; i++) {
			if (ProductManager.products[i].getCatalogId() == catalogId) {
				return true;
			}
		}
		return false;
	}
}
