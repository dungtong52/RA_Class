package ra;

import java.util.Scanner;

public class ExPractice {
    public static void main(String[] args) {
        /*
         * Input: customerName, productName, price, quantity, isMember
         * Process:
         *   - TotalAmount = quantity * price
         *   - VAT = totalAmount * 0.08
         *   - Discount = isMember ? totalAmount * 0.1 : 0
         *   - PaymentAmount = TotalAmount + VAT - Discount
         * Output:
         *   - CustomerName
         *   - ProductName
         *   - Quantity
         *   - Price
         *   - VAT
         *   - Discount
         *   - PaymentAmount
         * */
        //B1: Nhập dữ liệu đầu vào
        //--1.1. Khởi tạo đối tượng Scanner
        Scanner scanner = new Scanner(System.in);
        //--1.2. Thông báo nhập
        System.out.println("Nhập vào tên khách hàng:");
        //--1.3. Sử dụng các phương thức của Scanner lấy dữ liệu nhập vào từ bàn phím và lưu vào biến
        String customerName = scanner.nextLine();
        System.out.println("Nhập vào tên sản phẩm:");
        String productName = scanner.nextLine();
        System.out.println("Nhập vào giá sản phẩm:");
//        float price = scanner.nextFloat();
        float price = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào số lượng sản phẩm:");
//        int quantity = scanner.nextInt();
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Bạn có phải là thành viên hay không (true|false)?");
//        boolean isMember = scanner.nextBoolean();
        //Ctrl + Alt + L
        boolean isMember = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhập vào địa chỉ của bạn:");
        String address = scanner.nextLine();
        //B2: Tính toán tổng tiền, giảm giá, vat, tiền thanh toán
        //float * int --> float
        float totalAmount = price * quantity;
        //float * double --> double
        float vat = totalAmount * 0.08F;
        float discount = isMember ? totalAmount * 0.1F : 0;
        float paymentAmount = totalAmount - discount + vat;
        //B3: In dữ liệu đầu ra
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Sản phẩm: " + productName);
        //1,000,000
        System.out.printf("Giá: %,.0f\n", price);
        System.out.println("Số lượng: " + quantity);
        System.out.printf("Thành tiền: %,.0f\n", totalAmount);
        System.out.printf("Giảm giá: %,.0f\n", discount);
        System.out.printf("Tiền VAT: %,.0f\n", vat);
        System.out.printf("Tổng thanh toán: %,.0f\n", paymentAmount);
    }
}
