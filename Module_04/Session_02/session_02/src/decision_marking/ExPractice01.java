package decision_marking;
import java.util.Scanner;

public class ExPractice01 {
    public static void main(String[] args) {
        //B1: Nhập tuổi người đi xe bus, khai báo hằng số giá xe bus
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tuổi khách hàng:");
        int age = Integer.parseInt(scanner.nextLine());
        final float TICKET = 7000;
        float realTicket = 0;
        //B2: Sử dụng câu lệnh if-elseif-else thực hiện tính giá vé xe bus
        if (age < 0) {
            System.err.println("Tuổi phải lớn hơn không");
        } else if (age < 6 || age >= 60) {
            realTicket = 0;
        } else if (age < 18) {
            realTicket = TICKET * 0.5F;
        } else {
            realTicket = TICKET;
        }
        //B3: In giá vé xe bus của khách hàng
        System.out.println("Giá vé của bạn là: " + realTicket);
    }
}
