package ra;

import ra.business.OrderBusiness;
import ra.validator.Validation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderBusiness orderBusiness = new OrderBusiness();
        do {
            System.out.println("\n*********************QUẢN LÝ ĐƠN HÀNG********************");
            System.out.println("1. Thêm đơn hàng\n" +
                    "2. Hiển thị danh sách đơn hàng\n" +
                    "3. Cập nhật trạng thái đơn hàng theo mã đơn hàng\n" +
                    "4. Xóa đơn hàng theo mã đơn hàng\n" +
                    "5. Tìm kiếm đơn hàng theo tên khách hàng\n" +
                    "6. Thống kê tổng số đơn hàng\n" +
                    "7. Thống kê tổng doanh thu các đơn hàng có trạng thái Delivered\n" +
                    "8. Thống kê số lượng đơn hàng theo từng trạng thái\n" +
                    "9. Tìm kiếm đơn hàng có giá trị lớn nhất\n" +
                    "10.Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String choiceInput = scanner.nextLine();
            if (Validation.isIntegerInRange(choiceInput, 1, 10)) {
                int choice = Integer.parseInt(choiceInput);
                switch (choice) {
                    case 1 -> orderBusiness.addOrder(scanner);
                    case 2 -> orderBusiness.displayOrderList();
                    case 3 -> orderBusiness.updateStatusById(scanner);
                    case 4 -> orderBusiness.deleteOrderById(scanner);
                    case 5 -> orderBusiness.searchOrderByCustomerName(scanner);
                    case 6 -> orderBusiness.statisticOrder();
                    case 7 -> orderBusiness.statisticTotalAmountByStatus();
                    case 8 -> orderBusiness.statisticOrderByStatus();
                    case 9 -> orderBusiness.findOrderAmountMax();
                    default -> System.exit(0);
                }
            }
        } while (true);
    }
}
