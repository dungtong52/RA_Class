package localDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("Ngày hiện tại: " + now);
        LocalDate birthDay = LocalDate.of(1984, 04, 23);
        System.out.println("Ngày sinh nhật: " + birthDay);
        LocalTime nowTime = LocalTime.now();
        System.out.println("Thời gian hiện tại: " + nowTime);
        LocalTime birthTime = LocalTime.of(5, 30, 20);
        System.out.println("Giờ sinh: " + birthTime);
        LocalDateTime dateTimeNow = LocalDateTime.now();
        System.out.println("Ngày giờ hiện tại: " + dateTimeNow);
        Period period = Period.between(now, birthDay);
        System.out.println("Tuổi của bạn là: " + period.getYears());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Ngày sinh theo định dạng dd/MM/yyyy: " + formatter.format(birthDay));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào ngày sinh của bạn:");
        LocalDate userBirthDay;
        do {
            try {
                userBirthDay = LocalDate.parse(scanner.nextLine(), formatter);
                break;
            } catch (Exception e) {
                System.err.println("Ngày sinh không đúng định dạng, vui lòng nhập lại");
            }
        } while (true);
        System.out.println("Ngày sinh vừa nhập là: " + userBirthDay);
    }
}
