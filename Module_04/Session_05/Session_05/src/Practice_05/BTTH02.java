package Practice_05;

import java.util.Scanner;

public class BTTH02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập vào kích thước của mảng.\nSố hàng: ");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.println("Số cột: ");
        int cols = Integer.parseInt(scanner.nextLine());
        int[][] numberArr = new int[rows][cols];
        do {
            System.out.println("\n********************* MENU ********************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng");
            System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của mảng");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sử dụng thuật toán hoán đổi sắp xếp các phần tử trên đường chéo chính của mảng giảm dần");
            System.out.println("8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, thực hiện chèn vào mảng 2 chiều");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    // Nhập giá trị các phần tử của mảng
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.printf("Nhập giá trị phần tử hàng [%d], cột [%d]: ", i + 1, j + 1);
                            numberArr[i][j] = Integer.parseInt(scanner.nextLine());
                        }
                    }
                    System.out.println("Đã nhập mảng thành công");
                    break;

                case 2:
                    // In giá trị các phần tử trong mảng theo ma trận
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.printf("%5d", numberArr[i][j]);
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    // Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng
                    int countDivisibleBy2And3 = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            if (numberArr[i][j] % 6 == 0) {
                                countDivisibleBy2And3++;
                            }
                        }
                    }
                    System.out.println("Số lượng các phần tử chia hết cho 2 và 3 trong mảng là: " + countDivisibleBy2And3);
                    break;

                case 4:
                    // In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ
                    // In các phần tử nằm trên đường biên
                    int totalNumberInBorder = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            if (i == rows - 1 || i == 0 || j == cols - 1 || j == 0) {
                                totalNumberInBorder += numberArr[i][j];
                                System.out.printf("Các phần tử nằm trên đường biên: %5d", numberArr[i][j]);
                            }
                            System.out.println();
                        }
                    }
                    System.out.println("Tổng các phần tử trên đường biên: " + totalNumberInBorder);

                    // In các phần tử nằm trên đường chéo chính
                    int totalMainDiagonal = 0;
                    int length = (int)Math.min(rows, cols);
                    for (int i = 0; i < length; i++) {
                        for (int j = 0; j < length; j++) {
                            if (i == j) {
                                totalMainDiagonal += numberArr[i][j];
                                System.out.printf("Các phần tử nằm trên đường chéo chính: %5d", numberArr[i][j]);
                            }
                            System.out.println();
                        }
                    }
                    System.out.println("Tổng các phần tử trên đường chéo chính: " + totalMainDiagonal);

                    // In các phần tử nằm trên đường chéo phụ
                    int totalSecondaryDiagonal = 0;
                    if (rows == cols) {
                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < cols; j++) {
                                if (i == cols - j) {
                                    totalSecondaryDiagonal += numberArr[i][j];
                                    System.out.printf("Các phần tử nằm trên đường chéo phụ: %5d", numberArr[i][j]);
                                }
                                System.out.println();
                            }
                        }
                        System.out.println("Tổng các phần tử trên đường chéo phụ: " + totalSecondaryDiagonal);
                    } else {
                        System.out.println("Mảng không có đường chéo phụ");
                    }
                    break;

                case 5:
                    // Sử dụng thuật toán sắp xếp lựa chọn, sắp xếp các phần tử tăng dần theo cột của mảng
                    for (int i = 0; i < cols; i++) {
                        for (int j = 0; j < rows; j++) {
                            int indexMax = j;
                            for (int k = j + 1; k < rows; k++) {
                                if (numberArr[indexMax][i] < numberArr[k][i]) {
                                    indexMax = k;
                                }
                            }
                            if (indexMax != 0) {
                                int temp = numberArr[j][i];
                                numberArr[j][i] = numberArr[indexMax][i];
                                numberArr[indexMax][i] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp các phần tử tăng dần đã xong");
                    break;

                case 6:
                    // In ra các phần tử là số nguyên tố trong mảng
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            if (numberArr[i][j] >= 2) {
                                for (int k = 2; k < Math.sqrt(numberArr[i][j]); k++) {
                                    if (numberArr[i][j] % k == 0) {
                                        System.out.printf("Các phần tử số nguyên tố trong mảng: %5d", numberArr[i][j]);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    // Sử dụng thuật toán hoán đổi sắp xếp các phần tử trên đường chéo chính của mảng giảm dần
                    int lengthMainDiagonal = (int)Math.min(rows, cols);
                    for (int i = 0; i < lengthMainDiagonal - 1; i++) {
                        for (int j = i + 1; j < lengthMainDiagonal; j++) {
                            if(numberArr[i][i] > numberArr[j][j]){
                                int temp = numberArr[i][i];
                                numberArr[i][i] = numberArr[j][j];
                                numberArr[j][j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp xong đường chéo chính");
                    break;

                case 8:
                    // Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, thực hiện chèn vào mảng 2 chiều
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập vào số 1-9");
            }
        } while (true);
    }
}
