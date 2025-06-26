package session03;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        //B1: Khai báo và nhập giá trị 1 mảng số gnuyeen
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng:");
        int size = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("number[%d]=", i);
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
        //B2: Sử dụng thuật toán Kandane để tìm tổng lớn nhất của mảng con
        int maxHere = numbers[0];
        int maxSoFar = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i] < maxHere + numbers[i]) {
                maxHere = maxHere + numbers[i];
            }else{
                maxHere = numbers[i];
            }
            if (maxSoFar < maxHere) {
                maxSoFar = maxHere;
            }
        }
        System.out.println("Tổng mảng con lớn nhất là: " + maxSoFar);
    }
}
