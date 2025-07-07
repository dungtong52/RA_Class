package practice.entity;

import java.util.Scanner;

public class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private float price;
    private String catalog;
    private int quantity;

    public Product() {
    }

    public Product(int productId, String productName, float price, String catalog, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.catalog = catalog;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm:");
        this.productId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào tên sản phẩm:");
        this.productName = scanner.nextLine();
        System.out.println("Nhập vào giá sản phẩm:");
        this.price = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào danh mục sản phẩm:");
        this.catalog = scanner.nextLine();
        System.out.println("Nhập vào số lượng tồn kho:");
        this.quantity = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String toString() {
        return String.format("Mã SP: %d - Tên SP: %s - Giá: %.1f - Danh mục: %s - Số lượng: %d\n",
                this.productId, this.productName, this.price, this.catalog, this.quantity);
    }

    //Cài đặt sắp xếp
    @Override
    public int compareTo(Product o) {
        //So sánh đối tượng hiện tại với đối tượng o
//        if (this.price > o.price) {
//            return 1;
//        } else if (this.price == o.price) {
//            return 0;
//        } else {
//            return -1;
//        }
        //Sắp xếp theo price, ASC
        //thi.price - o.price
        return Float.compare(this.price, o.price);
    }
}
