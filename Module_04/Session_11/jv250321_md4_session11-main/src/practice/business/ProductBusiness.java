package practice.business;

import practice.entity.Product;

import java.util.*;

public class ProductBusiness {
    public static List<Product> listProducts = new ArrayList<>();

    public static void addProduct(Scanner scanner) {
        Product product = new Product();
        product.inputData(scanner);
        listProducts.add(product);
    }

    public static void displayListProducts() {
        for (Product product : listProducts) {
            System.out.println(product);
        }
    }

    public static int findIndexById(int productId) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần cập nhật:");
        int productId = Integer.parseInt(scanner.nextLine());
        int indexUpdate = findIndexById(productId);
        if (indexUpdate == -1) {
            System.err.println("Mã sản phẩm không tồn tại!!!");
        } else {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên sản phẩm");
                System.out.println("2. Cập nhật giá sản phẩm");
                System.out.println("3. Cập nhật danh mục");
                System.out.println("4. Cập nhật số lượng tồn kho");
                System.out.println("5. Thoát");
                System.out.print("Lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên mới của sản phẩm:");
                        listProducts.get(indexUpdate).setProductName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào giá mới của sản phẩm:");
                        listProducts.get(indexUpdate).setPrice(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập vào danh mục mới của sản phẩm:");
                        listProducts.get(indexUpdate).setCatalog(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhập vào số lượng tồn kho mới của sản phẩm:");
                        listProducts.get(indexUpdate).setQuantity(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-5");
                }
            } while (isExit);
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần xóa:");
        int productId = Integer.parseInt(scanner.nextLine());
        int indexDelete = findIndexById(productId);
        if (indexDelete == -1) {
            System.err.println("Mã sản phẩm không tồn tại");
        } else {
            listProducts.remove(indexDelete);
        }
    }

    public static void searchProductByName(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm cần tìm:");
        String productName = scanner.nextLine();
        for (Product product : listProducts) {
            if (product.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                System.out.println(product);
            }
        }
    }

    //Sắp xếp theo giá tăng dần : Comparable
    /*
     * 1. Cho lớp Product kế thừa từ Comparable
     * 2. Triển khai phương thức compareTo để cài đặt sắp xếp (sắp xếp theo tiêu chí nào và ASC | DESC)
     * 3. Sử dụng phương thức sort của Collection để sắp xếp
     * */
    public static void sortProductByPriceASC() {
        //Thực hiện sắp xếp
        Collections.sort(listProducts);
    }

    //Sắp xếp sản phẩm theo số lượng giảm dần: Comparator
    /*
     * 1. Sử dụng phương thức sort sắp xếp theo 1 đối tượng Comparator
     * 2. Triển khai phương thức compare để cài đặt sắp xếp
     * */
    /*
    * this, o1 so sánh với o2
    * o1>o2 --> dương --> ASC
    * o1>o2 --> âm --> DESC
    * */

    public void sortProductByQuantityDESC() {
        Collections.sort(listProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                //if o1>o2--> trả ra giá trị âm
                //return -(o1.getQuantity()-o2.getQuantity())
                return o2.getQuantity() - o1.getQuantity();
            }
        });
    }
}
