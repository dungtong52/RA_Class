package ra.entity;

import java.util.Scanner;

public class Categories implements IShop {
    public static int AUTO_ID = 0;

    private int catalogId;
    private String catalogName;
    private String description;
    private boolean catalogStatus;

    public Categories() {
        this.catalogId = AUTO_ID++;
    }

    public Categories(int catalogId, String catalogName, String description, boolean catalogStatus) {
        this.catalogId = AUTO_ID++;
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner) {
        this.catalogName = inputCatalogName(scanner);
        this.description = inputDescription(scanner);
        this.catalogStatus = inputCatalogStatus(scanner);
    }

    public boolean isEmpty(String data) {
        if (data != null && !data.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    // Nhập vào tên Catalog
    public String inputCatalogName(Scanner scanner) {
        System.out.print("Nhập vào tên danh mục: ");
        do {
            String catalogName = scanner.nextLine();
            if (isEmpty(catalogName) || catalogName.length() > 50) {
                System.err.println("Vui lòng nhập tên danh mục. Tên danh mục phải ít hơn 50 ký tự!");
            } else {
                boolean isExists = false;
                for (int i = 0; i < CategoriesManager.currentCate; i++) {
                    if (CategoriesManager.categories[i].getCatalogName().equals(catalogName)) {
                        isExists = true;
                        break;
                    }
                }
                if (!isExists) {
                    return catalogName;
                }
            }
        } while (true);
    }

    // Nhập vào mô tả danh mục
    public String inputDescription(Scanner scanner) {
        System.out.print("Nhập vào tên danh mục: ");
        String catalogDescription = scanner.nextLine();
        if (isEmpty(catalogDescription)) {
            return catalogDescription;
        }
        return null;
    }

    // Nhập status cho danh mục
    public boolean inputCatalogStatus(Scanner scanner) {
        do {
            System.out.print("Nhập vào trạng thái danh mục: ");
            String catalogStatus = scanner.nextLine();
            if (catalogStatus.trim().equalsIgnoreCase("true") ||
                    catalogStatus.trim().equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(catalogStatus);
            }
        } while (true);
    }

    @Override
    public void displayData() {

    }
}
