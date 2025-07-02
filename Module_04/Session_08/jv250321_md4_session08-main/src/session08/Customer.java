package session08;

public class Customer {
    private String customerName;
    private int customerType;
    private int loyaltyPoints;
    private int debit;

    public Customer() {
    }

    public Customer(String customerName, int customerType, int loyaltyPoints, int debit) {
        this.customerName = customerName;
        this.customerType = customerType;
        this.loyaltyPoints = loyaltyPoints;
        this.debit = debit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public boolean isVIP() {
        if (this.customerType == 1) {
            return true;
        }
        return false;
    }

    public void checkCustomerRecievePromotion() {
        if (isVIP() && this.loyaltyPoints > 0 && this.debit == 0) {
            System.out.printf("Khách %s là VIP đủ điều kiện nhận khuyến mãi\n", this.customerName);
        } else {
            System.out.printf("Khách %s là khách thường không đủ điều kiện\n", this.customerName);
        }
    }
}
