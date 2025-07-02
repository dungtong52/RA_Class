package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Product implements IShop {
	private String productId;
	private String productName;
	private float price;
	private String description;
	private int catalogId;
	private int productStatus;

	public Product () {
	}

	public Product (String productId, String productName, float price, String description, int catalogId, int productStatus) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.catalogId = catalogId;
		this.productStatus = productStatus;
	}

	public String getProductId () {
		return productId;
	}

	public void setProductId (String productId) {
		this.productId = productId;
	}

	public String getProductName () {
		return productName;
	}

	public void setProductName (String productName) {
		this.productName = productName;
	}

	public float getPrice () {
		return price;
	}

	public void setPrice (float price) {
		this.price = price;
	}

	public String getDescription () {
		return description;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	public int getCatalogId () {
		return catalogId;
	}

	public void setCatalogId (int catalogId) {
		this.catalogId = catalogId;
	}

	public int getProductStatus () {
		return productStatus;
	}

	public void setProductStatus (int productStatus) {
		this.productStatus = productStatus;
	}

	public void inputDataProduct (Scanner scanner) {
		this.productId = inputProductId(scanner);
		this.productName = inputProductName(scanner);
		this.price = inputPrice(scanner);
		this.description = inputDescription(scanner);
		this.catalogId = inputCatalodId(scanner);
		this.productStatus = inputProductStatus(scanner);
	}

	public String inputProductId (Scanner scanner) {
		String productNameRegex = "[ACS]\\d{3}";
		System.out.print("Nhập mã sản phẩm: ");
		do {
			String productId = scanner.nextLine();
			if (isEmpty(productId) || !Pattern.matches(productNameRegex, productId)) {
				System.err.println("Vui lòng nhập vào mã sản phẩm hợp lệ!");
			} else {
				// Kiểm tra không trùng lặp
				boolean isExists = false;
				for (int i = 0; i < ProductManager.currentProd; i++) {
					if (ProductManager.products[i].getProductId().equalsIgnoreCase(productId)) {
						isExists = true;
						break;
					}
				}
				if (!isExists) {
					return productId;
				} else {
					System.err.println("Mã sản phẩm này đã tồn tại! Hãy nhập vào mã khác");
				}
			}
		} while (true);
	}

	public String inputProductName (Scanner scanner) {
		String productNameRegex = "\\w{10,50}";
		do {
			System.out.print("Nhập tên sản phẩm: ");
			String productName = scanner.nextLine();
			if (isEmpty(productName) || !Pattern.matches(productNameRegex, productName)) {
				System.err.println("Vui lòng nhập vào tên của sản phẩm hợp lệ");
			} else {
				// Kiểm tra không trùng lặp
				boolean isExists = false;
				for (int i = 0; i < ProductManager.currentProd; i++) {
					if (ProductManager.products[i].getProductName().equalsIgnoreCase(productName)) {
						isExists = true;
						break;
					}
				}
				if (!isExists) {
					return productName;
				} else {
					System.err.println("Tên sản phẩm này đã tồn tại! Hãy nhập vào tên khác");
				}
			}
		} while (true);
	}

	public float inputPrice (Scanner scanner) {
		do {
			System.out.print("Nhập vào giá sản phẩm: ");
			if (scanner.hasNextFloat()) {
				float productPrice = Float.parseFloat(scanner.nextLine());
				if (productPrice > 0) {
					return productPrice;
				}
				System.err.println("Giá sản phẩm phải lớn hơn 0");
			}
			System.err.println("Vui lòng nhập vào giá tiền hợp lệ!");
		} while (true);
	}

	public String inputDescription (Scanner scanner) {
		do {
			System.out.println("Nhập mô tả sản phẩm: ");
			String description = scanner.nextLine();
			if (isEmpty(description)) {
				System.err.println("Nhập vào mô tả không hợp lệ!");
			} else {
				return description;
			}
		} while (true);
	}

	public int inputCatalodId (Scanner scanner) {
		CategoriesManager categoriesManager = new CategoriesManager();
		categoriesManager.showAllCategories();

		System.out.println("Sản phẩm đã có mã danh mục ở trên chưa? Nếu có rồi, nhập 'y'.\n" +
				"Nếu chưa có, nhập phím bất kỳ để thêm danh mục mới.");
		char choice = scanner.nextLine().trim().toLowerCase().charAt(0);
		if (choice == 'y') {
			return inputCatalogIdExists(scanner);
		} else {
			CategoriesManager.categories[CategoriesManager.currentCate] = new Categories();
			CategoriesManager.categories[CategoriesManager.currentCate].inputDataCategories(scanner);
			CategoriesManager.currentCate++;
			return CategoriesManager.categories[CategoriesManager.currentCate - 1].getCatalogId();
		}
	}

	public int inputProductStatus (Scanner scanner) {
		do {
			System.out.print("Nhập vào trạng thái sản phẩm: ");
			if (scanner.hasNextInt()) {
				int productStatus = Integer.parseInt(scanner.nextLine());
				if (productStatus != 0 && productStatus != 1 && productStatus != 2) {
					System.err.println("Vui lòng nhập vào số 0, 1 hoặc 2!");
				}
				return productStatus;
			}
			System.err.println("Vui lòng nhập vào số 0, 1 hoặc 2!");
		} while (true);
	}

	@Override
	public void displayData () {
		System.out.printf("|%-5s|%-15s|%,8.1f|%15s|%-5d|%8s\n",
				productId, productName, price, description, catalogId, displayForProductStatus());
	}

	public boolean isEmpty (String data) {
		if (data != null && !data.trim().isEmpty()) {
			return false;
		}
		return true;
	}

	public String displayForProductStatus () {
		String status = "";
		switch (productStatus) {
			case 0:
				status = "Đang bán";
				break;
			case 1:
				status = "Hết hàng";
				break;
			case 2:
				status = "Không bán";
				break;
		}
		return status;
	}

	public boolean isExistsCatalogId (int catalogId) {
		boolean isExists = false;
		for (int i = 0; i < CategoriesManager.currentCate; i++) {
			if (CategoriesManager.categories[i].getCatalogId() == catalogId) {
				isExists = true;
				break;
			}
		}
		return isExists;
	}

	public int inputCatalogIdExists (Scanner scanner) {
		do {
			System.out.print("Nhập vào mã danh mục: ");
			if (scanner.hasNextInt()) {
				int catalogId = Integer.parseInt(scanner.nextLine());
				if (catalogId > 0 && isExistsCatalogId(catalogId)) {
					return catalogId;
				}
				System.err.println("Mã danh mục không tồn tại.");
			}
			System.err.println("Mã danh mục không hợp lệ!");
		} while (true);
	}
}
