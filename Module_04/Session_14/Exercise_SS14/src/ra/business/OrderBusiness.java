package ra.business;

import ra.entity.Order;
import ra.entity.OrderStatus;
import ra.validator.Validation;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class OrderBusiness {
    private final List<Order> orderList = new ArrayList<>();

    public void addOrder(Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner, this);
        orderList.add(order);
        System.out.println("Thêm đơn hàng thành công!");
    }

    public void displayOrderList() {
        System.out.println("Danh sách đơn hàng sắp xếp theo giá trị giảm dần:");
        orderList.stream()
                .sorted(Comparator.comparing(Order::getOrderAmount).reversed())
                .forEach(System.out::println);
    }

    public void updateStatusById(Scanner scanner) {
        System.out.print("Nhập vào mã đơn hàng muốn cập nhật trạng thái: ");
        String idInput = scanner.nextLine();
        if (Validation.isPositiveInteger(idInput)) {
            int idUpdate = Integer.parseInt(idInput);
            orderList.stream()
                    .filter(order -> order.getOrderId() == idUpdate).findFirst()
                    .ifPresentOrElse(order -> {
                        String orderStatus = order.getStatus().toString().toLowerCase();
                        if (orderStatus.equals("pending")) {
                            order.setStatus(OrderStatus.SHIPPED);
                        } else {
                            order.setStatus(OrderStatus.DELIVERED);
                        }
                    }, () -> System.err.println("Mã đơn hàng này không tồn tại"));
        } else {
            System.err.println("Phải nhập số nguyên dương");
        }
    }

    public void deleteOrderById(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng muốn xóa: ");
        String idInput = scanner.nextLine();
        if (Validation.isPositiveInteger(idInput)) {
            int idDelete = Integer.parseInt(idInput);
            orderList.stream()
                    .filter(order -> order.getOrderId() == idDelete).findFirst()
                    .ifPresentOrElse(order -> {
                        if (order.getStatus().toString().equalsIgnoreCase("pending")) {
                            orderList.remove(order);
                        }
                    }, () -> System.err.println("Mã đơn hàng không tồn tại!"));
        } else {
            System.err.println("Phải nhập số nguyên dương");
        }
    }

    public void searchOrderByCustomerName(Scanner scanner) {
        System.out.print("Nhập tên khách hàng muốn tìm đơn hàng: ");
        String customerName = scanner.nextLine();
        if (!Validation.isEmpty(customerName)) {
            List<Order> searchOrder = orderList.stream()
                    .filter(order -> order.getCustomerName().equalsIgnoreCase(customerName)).toList();
            if (!searchOrder.isEmpty()) {
                searchOrder.forEach(System.out::println);
            } else {
                System.err.println("Khách hàng này không có đơn hàng nào!");
            }
        } else {
            System.err.println("Không được để trống!");
        }
    }

    public void statisticOrder() {
        System.out.println("Tổng số đơn hàng: " + orderList.size());
    }

    public void statisticTotalAmountByStatus() {
        double totalAmount = orderList.stream()
                .filter(order -> order.getStatus().toString().equalsIgnoreCase("delivered"))
                .mapToDouble(Order::getOrderAmount)
                .sum();
        System.out.printf("Tổng doanh thu từ các đơn hàng 'Delivered': %.1f\n", totalAmount);
    }

    public void statisticOrderByStatus() {
        Map<OrderStatus, Long> orderGroupByStatus = orderList.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));
        for (Map.Entry<OrderStatus, Long> entry : orderGroupByStatus.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void findOrderAmountMax() {
        orderList.stream()
                .max(Comparator.comparing(Order::getOrderAmount))
                .ifPresent(System.out::println);
    }

    public int findMaxIdInList() {
        return orderList.stream()
                .mapToInt(Order::getOrderId)
                .max()
                .orElse(0);
    }

}
