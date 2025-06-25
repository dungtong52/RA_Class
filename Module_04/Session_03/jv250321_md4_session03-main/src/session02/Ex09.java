package session02;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        //Nhập số N là số nguyên dương (validate)
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Nhập vào số lớn nhất cần tìm số Amstrong:");
        do {
            if (scanner.hasNextInt()) {
                number = Integer.parseInt(scanner.nextLine());
                if (number > 0) {
                    break;
                } else {
                    System.err.println("Đây không phải là số nguyên duơng, vui lòng nhập lại");
                }
            } else {
                System.err.println("Giá trị nhập vào không phải số nguyên, vui lòng nhập lại");
            }
        } while (true);
        //B2. Xét các số từ 0 đến number để tìm các số Amstrong và in ra
        System.out.printf("Các số Amstrong trong khoảng %d đến %d là: \n", 0, number);
        for (int i = 0; i <= number; i++) {
            //Kiểm tra i có phải là số amstrong hay không
            int currentNumber = i;
            int length = 0;
            //567/10 = 56 (1), 56/10=5(2), 5/10=0(3)
            while (currentNumber != 0) {
                currentNumber /= 10;
                length++;
            }
            int total = 0;
            currentNumber = i;
            while (currentNumber != 0) {
                int digit = currentNumber % 10;
                currentNumber /= 10;
                total += (int) Math.pow(digit, length);
            }
            if (total == i) {
                System.out.printf("%d\t", i);
            }
        }
    }
}
