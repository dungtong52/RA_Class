package session03.array;

import java.util.Scanner;

public class SingleDimesionArray {
    public static void main(String[] args) {
        /*
         * Nhập số phần tử (n) và Khai báo mảng 1 chiều số nguyên gồm n phần tử.
         * In menu và thực hiện các chức năng theo menu
         * *****************MENU***************
         * 1. Nhập giá trị các phần tử
         * 2. Hiển trị giá trị các phần tử
         * 3. Tính tổng các phần tử
         * 4. In ra các phần tử có giá trị chẵn trong mảng
         * 5. Thoát
         * */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng:");
        int size = Integer.parseInt(scanner.nextLine());
        //Khai báo mảng số nguyên 1 chiều gồm size phẩn tử
        int[] numbers = new int[size];
        do {
            System.out.println("****************MENU*****************");
            System.out.println("1. Nhập giá trị các phần tử");
            System.out.println("2. In giá trị các phần tử");
            System.out.println("3. Tính tổng các phần tử");
            System.out.println("4. In các chỉ số phần tử có giá trị chẵn");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < numbers.length; i++) {
                        System.out.printf("numbers[%d]=", i);
                        numbers[i] = Integer.parseInt(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Giá trị các phần tử trong mảng là:");
                    for (int element : numbers) {
                        System.out.printf("%d\t", element);
                    }
                    System.out.printf("\n");
                    break;
                case 3:
                    int sumElement = 0;
                    for (int element : numbers) {
                        sumElement += element;
                    }
                    System.out.println("Tổng các phần tử là: " + sumElement);
                    break;
                case 4:
                    System.out.println("Chỉ số các phần tử có giá trị chẵn là:");
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] % 2 == 0) {
                            System.out.printf("%d\t", i);
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (true);
    }
}
