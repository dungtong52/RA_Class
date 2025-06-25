package session03.array;

import java.util.Scanner;

public class TwoDimensionsArray {
    public static void main(String[] args) {
        /*
         * Nhập vào số dòng và số cột của mảng 2 chiều số nguyên. Khai báo mảng.
         * - Nhập giá trị cho các phần tử của mảng
         * - In giá trị của các phần tử trong mảng theo ma trận
         * - Tính tổng các phần tử nằm trên đường biên
         * */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số dòng của mảng:");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào số cột của mảng:");
        int col = Integer.parseInt(scanner.nextLine());
        //Khai báo mảng
        int[][] numbers = new int[row][col];
        //Nhập giá trị cho các phần tử
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.printf("numbers[%d][%d]=", i, j);
                numbers[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        //In giá trị các phần tử theo ma trận
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.printf("%5d", numbers[i][j]);
            }
            System.out.println();
        }
        //Tính tổng các phần tử nằm trên đường biên
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    sum += numbers[i][j];
                }
            }
        }
        System.out.println("Tổng các phần tử nằm trên biên là: " + sum);
    }
}
