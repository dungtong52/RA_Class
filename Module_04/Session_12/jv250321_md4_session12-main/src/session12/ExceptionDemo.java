package session12;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("***************BẮT ĐẦU CHƯƠNG TRÌNH****************");
        Scanner scanner = new Scanner(System.in);
        int firstNumber;
        int secondNumber;
        try {
            //Bắt exception dùng khối lệnh try
            System.out.println("Nhập vào số nguyên thứ nhất:");
            firstNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập vào số nguyên thứ hai:");
            secondNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException | ArithmeticException ex) {
            //xử lý exception trong khối lệnh catch
            System.out.println("Dữ liệu nhập vào không đúng yêu cầu");
            firstNumber = 1;
            secondNumber = 1;
            ex.fillInStackTrace();
//        } catch (ArithmeticException e) {
//            e.fillInStackTrace();
//        }
//        finally {
            System.out.println("Kết thúc quá trình nhập dữ liệu");
        }

        int divNumber = divNumbers(firstNumber, secondNumber);
        System.out.println("Thương 2 số là: " + divNumber);
        System.out.println("****************KẾT THÚC CHƯƠNG TRÌNH***************");
    }

    public static int divNumbers(int firstNumber, int secondNumber) throws ArithmeticException{
//        if (secondNumber == 0) {
//            throw new ArithmeticException("Lỗi chia cho 0");
//        }
        return firstNumber / secondNumber;
    }
}
