package session03;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        //In menu và thực hiện các chức năng theo menu
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        do {
            System.out.println("************THAO TÁC MẢNG**************");
            System.out.println("1. Nhập giá trị các phần tử mảng");
            System.out.println("2. Hiển thị giá trị các phần tử");
            System.out.println("3. Sắp xếp mảng giảm dần");
            System.out.println("4. Tìm kiếm phần tử theo thuật toán tuyến tính");
            System.out.println("5. Tìm kiếm phần tử theo thuật toán nhị phân");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < numbers.length; i++) {
                        System.out.printf("number[%d]=", i);
                        numbers[i] = Integer.parseInt(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Giá tr các phần tử trong mảng là:");
                    for (int element : numbers) {
                        System.out.printf("%5d", element);
                    }
                    System.out.println();
                    break;
                case 3:
                    //Duyệt các phần tử chưa được sắp xếp
                    for (int i = 0; i < numbers.length - 1; i++) {
                        int indexMax = i;
                        for (int j = i + 1; j < numbers.length; j++) {
                            if (numbers[indexMax] < numbers[j]) {
                                indexMax = j;
                            }
                        }
                        if (indexMax != i) {
                            int temp = numbers[indexMax];
                            numbers[indexMax] = numbers[i];
                            numbers[i] = temp;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhập vào giá trị cần tìm:");
                    int searchValue = Integer.parseInt(scanner.nextLine());
                    boolean isFound = false;
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] == searchValue) {
                            System.out.printf("Tìm thấy phần tử có chỉ số %d có giá trị là %d\n", i, searchValue);
                            isFound = true;
                            break;
                        }
                    }
                    //isFound == false --> true
                    //!isFount --> true
                    if (!isFound) {
                        System.out.printf("Không tìm thấy phần tử nào có giá trị là %d\n", searchValue);
                    }
                    break;
                case 5:
                    //1.Sắp xếp mảng tăng dần
                    for (int i = 0; i < numbers.length - 1; i++) {
                        for (int j = i + 1; j < numbers.length; j++) {
                            if (numbers[i] > numbers[j]) {
                                int temp = numbers[i];
                                numbers[i] = numbers[j];
                                numbers[j] = temp;
                            }
                        }
                    }
                    //2.Sử dụng thuật toán tìm kiếm nhị phân để tìm kiếm
                    //--2.1. Nhập giá trị tìm kiếm
                    System.out.println("Nhập vào giá trị cần tìm:");
                    int valueSearch = Integer.parseInt(scanner.nextLine());
                    //--2.2. Thực hiện tìm kiếm
                    int left = 0;
                    int right = numbers.length - 1;
                    boolean found = false;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (numbers[mid] > valueSearch) {
                            right = mid - 1;
                        } else if (numbers[mid] < valueSearch) {
                            left = mid + 1;
                        } else {
                            System.out.printf("Tìm thấy phần tử có chỉ số %d có giá trị là %d\n", mid, valueSearch);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy phần tử có giá trị " + valueSearch);
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (true);
    }
}
