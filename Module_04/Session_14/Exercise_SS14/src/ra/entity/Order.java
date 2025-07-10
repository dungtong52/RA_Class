package ra.entity;

import ra.business.OrderBusiness;
import ra.validator.Validation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Order {
    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private float orderAmount;
    private OrderStatus status = OrderStatus.PENDING;

    public Order() {
    }

    public Order(int orderId, String customerName, String phoneNumber, String address, float orderAmount, OrderStatus status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, OrderBusiness orderBusiness) {
        this.orderId = inputId(orderBusiness);
        this.customerName = inputCustomerName(scanner);
        this.phoneNumber = inputPhoneNumber(scanner);
        this.address = inputAddress(scanner);
        this.orderAmount = inputOrderAmount(scanner);
    }

    public int inputId(OrderBusiness orderBusiness) {
        return orderBusiness.findMaxIdInList() + 1;
    }

    public String inputCustomerName(Scanner scanner) {
        do {
            System.out.print("Nhập vào tên khách hàng: ");
            String customerName = scanner.nextLine();
            if (!Validation.isEmpty(customerName)) {
                if (customerName.length() > 6 && customerName.length() < 100) {
                    return customerName;
                } else {
                    System.err.println("Độ dài tên không đúng!");
                }
            } else {
                System.err.println("Không được để trống!");
            }
        } while (true);
    }

    public String inputPhoneNumber(Scanner scanner) {
        String phoneNumberRegex = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$";
        do {
            System.out.print("Nhập vào số điện thoại khách hàng: ");
            String phoneNumber = scanner.nextLine();
            if (!Validation.isEmpty(phoneNumber)) {
                if (Pattern.matches(phoneNumberRegex, phoneNumber)) {
                    return phoneNumber;
                } else {
                    System.err.println("Số điện thoại không hợp lệ!");
                }
            } else {
                System.err.println("Không được để trống!");
            }
        } while (true);
    }

    public String inputAddress(Scanner scanner) {
        do {
            System.out.print("Nhập vào địa chỉ khách hàng: ");
            String address = scanner.nextLine();
            if (Validation.isEmpty(address)) {
                return address;
            } else {
                System.err.println("Không được để trống!");
            }
        } while (true);
    }

    public float inputOrderAmount(Scanner scanner) {
        do {
            System.out.print("Nhập vào giá trị đơn hàng: ");
            String orderAmount = scanner.nextLine();
            if (Validation.isPositiveFloat(orderAmount)) {
                return Float.parseFloat(orderAmount);
            } else {
                System.err.println("Giá trị nhập vào không hợp lệ!");
            }
        } while (true);
    }


    @Override
    public String toString() {
        return String.format("Order ID: %d - Customer Name: %s - Phone Number: %s - Address: %s - Amount: %.1f - Status: %s",
                this.orderId, this.customerName, this.phoneNumber, this.address, this.orderAmount, this.status);
    }
}
