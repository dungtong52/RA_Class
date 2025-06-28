package Practice_05;

import java.util.Scanner;

public class BTTH01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberArr = new int[100];
        int currentIndex = 0;
        do {
            System.out.println("\n*********************MENU********************");
            System.out.println("1. Nhập giá trị n phần tử của mảng (n nhập từ bàn phím)");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong mảng (k nhập từ bàn phím)");
            System.out.println("5. Sử dụng thuật toán sắp xếp hoán đổi sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, các phần tử còn lại ở giữa mảng theo thứ tự tăng dần");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Hãy nhập số phần tử của mảng: ");
                    if (scanner.hasNextInt()) {
                        int n = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < n; i++) {
                            System.out.printf("Nhập vào phần tử thứ [%d] của mảng: ", i + 1);
                            numberArr[currentIndex] = Integer.parseInt(scanner.nextLine());
                            currentIndex++;

                        }
                        System.out.println("Mảng được thêm thành công!");
                    } else {
                        System.err.println("Hãy nhập vào 1 số nguyên dương <= 100");
                    }
                    break;

                case 2:
                    // In giá trị các phần tử trong mảng
                    if (currentIndex == 0) {
                        System.out.println("Mảng chưa có phần tử nào");
                        break;
                    }
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%10d", numberArr[i]);
                    }
                    System.out.println();
                    break;

                case 3:
                    // Tính trung bình các phần tử dương (>0) trong mảng
                    if (currentIndex == 0) {
                        System.out.println("Mảng chưa có phần tử nào");
                        break;
                    }
                    int countPositiveInteger = 0;
                    int sumPositiveInteger = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numberArr[i] > 0) {
                            sumPositiveInteger += numberArr[i];
                            countPositiveInteger++;
                        }
                    }
                    System.out.println("Trung bình các phần tử dương trong mảng: " + (sumPositiveInteger / countPositiveInteger));
                    break;

                case 4:
                    // In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong mảng (k nhập từ bàn phím)
                    if (currentIndex == 0) {
                        System.out.println("Mảng chưa có phần tử nào");
                        break;
                    }
                    System.out.print("Hãy nhập số k cần tìm:");
                    if (scanner.hasNextInt()) {
                        int k = Integer.parseInt(scanner.nextLine());
                        System.out.printf("Các chỉ số phần tử có giá trị bằng %d là: \n", k);
                        for (int i = 0; i < currentIndex; i++) {
                            if (numberArr[i] == k) {
                                System.out.printf("%5d", i);
                            }
                        }
                    } else {
                        System.err.println("Hãy nhập vào 1 số nguyên");
                    }
                    break;

                case 5:
                    // Sử dụng thuật toán sắp xếp hoán đổi sắp xếp mảng giảm dần
                    for(int i = 0; i < currentIndex; i++){
                        for(int j = i + 1; j < currentIndex; j++){
                            if(numberArr[i] < numberArr[j]){
                                int temp = numberArr[i];
                                numberArr[i] = numberArr[j];
                                numberArr[j] = temp;
                            }
                        }
                    }
                    System.out.println("Mảng đã sắp xếp thành công!");
                    break;

                case 6:
                    // Tính số lượng các phần tử là số nguyên tố trong mảng
                    int countPrime = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        boolean isPrime = true;
                        if (numberArr[i] >= 2) {
                            for (int j = 2; j <= Math.sqrt(numberArr[i]); j++) {
                                if (numberArr[i] % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                        } else {
                            isPrime = false;
                        }
                        if (!false) {
                            countPrime++;
                        }
                    }
                    System.out.printf("Có %d số nguyên tố", countPrime);
                    break;

                case 7:
                    // Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần,
                    // các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần,
                    // các phần tử còn lại ở giữa mảng theo thứ tự tăng dần
                    int countOdd = 0;
                    int countEven = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numberArr[i] % 6 == 0) {
                            countEven++;
                        }
                        if (numberArr[i] % 2 != 0 && numberArr[i] % 3 == 0) {
                            countOdd++;
                        }
                    }
                    int[] oddNumbers = new int[countOdd];
                    int[] evenNumbers = new int[countEven];
                    int[] otherNumbers = new int[currentIndex - countEven - countOdd];
                    // Lưu ra các bảng mới
                    int currentEven = 0;
                    int currentOdd = 0;
                    int currentOther = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numberArr[i] % 6 == 0) {
                            evenNumbers[currentEven] = numberArr[i];
                            currentEven++;
                        } else if (numberArr[i] % 2 != 0 && numberArr[i] % 3 == 0) {
                            oddNumbers[currentOdd] = numberArr[i];
                            currentOdd++;
                        } else {
                            otherNumbers[currentOther] = numberArr[i];
                            currentOther++;
                        }
                    }
                    // Sắp xếp các mảng mới theo yêu cầu
                    // Sắp xếp mảng Even tăng dần
                    for (int i = 0; i < evenNumbers.length - 1; i++) {
                        for (int j = i + 1; j < evenNumbers.length; j++) {
                            if (evenNumbers[i] > evenNumbers[j]) {
                                int temp = evenNumbers[i];
                                evenNumbers[i] = evenNumbers[j];
                                evenNumbers[j] = temp;
                            }
                        }
                    }
                    // Sắp xếp mảng Odd giảm dần
                    for (int i = 0; i < oddNumbers.length - 1; i++) {
                        for (int j = i + 1; j < oddNumbers.length; j++) {
                            if (oddNumbers[i] < oddNumbers[j]) {
                                int temp = oddNumbers[i];
                                oddNumbers[i] = oddNumbers[j];
                                oddNumbers[j] = temp;
                            }
                        }
                    }
                    // Sắp xếp mảng Other tăng dần
                    for (int i = 0; i < otherNumbers.length - 1; i++) {
                        for (int j = i + 1; j < otherNumbers.length; j++) {
                            if (otherNumbers[i] > otherNumbers[j]) {
                                int temp = otherNumbers[i];
                                otherNumbers[i] = otherNumbers[j];
                                otherNumbers[j] = temp;
                            }
                        }
                    }
                    // Ghi đè 3 mảng vào mảng cũ
                    currentIndex = 0;
                    for (int i = 0; i < evenNumbers.length; i++) {
                        numberArr[currentIndex] = evenNumbers[i];
                        currentIndex++;
                    }
                    for (int element : otherNumbers) {
                        numberArr[currentIndex] = element;
                        currentIndex++;
                    }
                    for (int element : oddNumbers) {
                        numberArr[currentIndex] = element;
                        currentIndex++;
                    }
                    System.out.println("Đã sắp xếp xong theo yêu cầu");
                    break;

                case 8:
                    // Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí
                    // Sắp xếp mảng giảm dần dùng selection Sort
                    for (int i = 0; i < currentIndex; i++) {
                        int indexMax = i;
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (numberArr[indexMax] < numberArr[j]) {
                                indexMax = j;
                            }
                        }
                        if (indexMax != i) {
                            int temp = numberArr[i];
                            numberArr[i] = numberArr[indexMax];
                            numberArr[indexMax] = temp;
                        }
                    }
                    // Nhập giá trị m
                    System.out.println("Nhập vào gi trị m cần chèn: ");
                    int m = Integer.parseInt(scanner.nextLine());
                    // Chèn m vào mảng
                    int insertIndex = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (m >= numberArr[i]) {
                            insertIndex = i;
                            break;
                        }
                    }
                    for (int i = currentIndex; i > insertIndex; i--) {
                        numberArr[i] = numberArr[i - 1];
                    }
                    numberArr[insertIndex] = m;
                    System.out.println("Đã chèn thành công!");
                    break;

                case 9:
                    System.exit(0);
                default:
                    System.err.println("Hãy nhập số từ 1-9!");
            }
        } while (true);
    }
}
