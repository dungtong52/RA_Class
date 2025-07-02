package ra.entity;

import java.util.Scanner;

public class ProductManager {
	public static Product[] products = new Product[100];
	public static int currentProd = 0;

	public ProductManager () {
	}

	public void productMenu (Scanner scanner) {
		do {
			System.out.println(
					"\n*******************PRODUCT MANAGEMENT*******************\n" +
							"1. Nhập thông tin các sản phẩm\n" +
							"2. Hiển thị thông tin các sản phẩm\n" +
							"3. Sắp xếp các sản phẩm theo giá\n" +
							"4. Cập nhật thông tin sản phẩm theo mã sản phẩm\n" +
							"5. Xóa sản phẩm theo mã sản phẩm\n" +
							"6. Tìm kiếm các sản phẩm theo tên sản phẩm\n" +
							"7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)" +
							"8. Thoát"
			);
			System.out.print("Lựa chọn của bạn: ");
			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
				case 1:
					addProduct(scanner);
					break;
				case 2:
					showAllProduct();
					break;
				case 3:
					sortProductByPriceASC();
					break;
				case 4:
					updateProduct(scanner);
					break;
				case 5:
					deleteProductById(scanner);
					break;
				case 6:
					findProductByName(scanner);
					break;
				case 7:

					break;
				case 8:
					return;
				default:
					System.out.println("Nhập vào số trong khoảng 1-8");
			}
		} while (true);
	}

	public void addProduct (Scanner scanner) {
		System.out.printf("Nhập vào số sản phẩm muốn thêm: ");
		int cntProduct = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < cntProduct; i++) {
			products[currentProd] = new Product();
			products[currentProd].inputDataProduct(scanner);
			currentProd++;
		}
		System.out.println("Đã thêm thành công!");
	}

	public void showAllProduct () {
		System.out.println("Danh sách các sản phẩm đã có: ");
		System.out.printf("|%-5s|%-15s|%,8.1f|%15s|%-5d|%8s\n",
				"Product ID", "Product Name", "Price", "Description", "Catalog ID", "Product Status");
		System.out.println("-----------------------------------");
		for (int i = 0; i < currentProd; i++) {
			products[i].displayData();
			System.out.println("-----------------------------------");
		}
	}

	public void sortProductByPriceASC () {
		for (int i = 0; i < currentProd - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < currentProd; j++) {
				if (products[minIndex].getPrice() > products[j].getPrice()) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				Product temp = products[i];
				products[i] = products[minIndex];
				products[minIndex] = temp;
			}
		}
		System.out.println("Đã sắp xếp mảng sản phẩm theo giá tăng dần");
	}

	public void updateProduct (Scanner scanner) {
		System.out.print("Nhập vào mã sản phẩm muốn cập nhật: ");
		String productIdForUpdate = scanner.nextLine();
		int indexIdUpdate = findIndexById(productIdForUpdate);

		if (indexIdUpdate == -1) {
			System.out.println("Mã danh mục không tồn tại");
		} else {
			do {
				System.out.println("1. Cập nhật tên sản phẩm");
				System.out.println("2. Cập nhật giá sản phẩm");
				System.out.println("3. Cập nhật mô tả sản phẩm");
				System.out.println("4. Cập nhật mã danh mục mà sản phẩm thuộc về");
				System.out.println("5. Cập nhật trạng thái sản phẩm");
				System.out.println("6. Thoát cập nhật");
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
					case 1:
						products[indexIdUpdate].inputProductName(scanner);
						break;
					case 2:
						products[indexIdUpdate].inputPrice(scanner);
						break;
					case 3:
						products[indexIdUpdate].inputDescription(scanner);
						break;
					case 4:
						products[indexIdUpdate].inputCatalodId(scanner);
						break;
					case 5:
						products[indexIdUpdate].inputProductStatus(scanner);
						break;
					case 6:
						return;
					default:
						System.err.println("Nhập vào số trong khoảng 1-6");
				}
			} while (true);
		}

	}

	public int findIndexById (String id) {
		for (int i = 0; i < currentProd; i++) {
			if (products[i].getProductId().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}

	public void deleteProductById (Scanner scanner) {
		System.out.printf("Nhập vào mã sản phẩm muốn xóa: ");
		String productIdForDelete = scanner.nextLine();
		int indexIdDelete = findIndexById(productIdForDelete);
		if (indexIdDelete == -1) {
			System.out.println("Mã sản phẩm không tồn tại");
		} else {
			for (int i = indexIdDelete; i < currentProd - 1; i++) {
				products[i] = products[i + 1];
			}
			products[currentProd - 1] = null;
			currentProd--;
			System.out.printf("Xóa thành công!");
		}
	}

	public void findProductByName (Scanner scanner) {
		System.out.print("Nhập tên sản phẩm muốn tìm kiếm: ");
		String nameToFind = scanner.nextLine();

		System.out.println("Danh sách sản phẩm");
		System.out.printf("|%-5s|%-15s|%,8.1f|%15s|%-5d|%8s\n",
				"Product ID", "Product Name", "Price", "Description", "Catalog ID", "Product Status");

		for (int i = 0; i < currentProd; i++) {
			if (products[i].getProductName().equalsIgnoreCase(nameToFind.trim())) {
				products[i].displayData();
				System.out.println("-----------------------------------");
			}
		}
	}

	public void findProductBetweenPrice (Scanner scanner) {
		System.out.print("Nhập giá nhỏ nhất muốn tìm: ");
		float minPrice = Float.parseFloat(scanner.nextLine());

		System.out.print("Nhập giá lớn nhất muốn tìm: ");
		float maxPrice = Float.parseFloat(scanner.nextLine());

		System.out.printf("Danh sách sản phẩm trong khoảng giá %,.1f - %,.1f\n", minPrice, maxPrice);
		System.out.printf("|%-5s|%-15s|%,8.1f|%15s|%-5d|%8s\n",
				"Product ID", "Product Name", "Price", "Description", "Catalog ID", "Product Status");
		System.out.println("-----------------------------------");
		for (int i = 0; i < currentProd; i++) {
			if (products[i].getPrice() >= minPrice && products[i].getPrice() <= maxPrice) {
				products[i].displayData();
				System.out.println("-----------------------------------");
			}
		}
	}
}
