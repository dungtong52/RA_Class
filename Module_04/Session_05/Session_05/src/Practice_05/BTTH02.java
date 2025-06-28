package Practice_05;

import java.util.Scanner;

public class BTTH02 {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Hãy nhập vào kích thước của mảng.\nSố hàng: ");
		int rows = Integer.parseInt(scanner.nextLine());
		System.out.print("Số cột: ");
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
					System.out.println("Các phần tử nằm trên đường biên: ");
					for (int i = 0; i < rows; i++) {
						for (int j = 0; j < cols; j++) {
							if (i == rows - 1 || i == 0 || j == cols - 1 || j == 0) {
								totalNumberInBorder += numberArr[i][j];
								System.out.printf("%5d", numberArr[i][j]);
							} else {
								System.out.printf("%5s", "");
							}
						}
						System.out.println();
					}
					System.out.println("Tổng các phần tử trên đường biên: " + totalNumberInBorder);

					// In các phần tử nằm trên đường chéo chính
					int totalMainDiagonal = 0;
					int length = (int) Math.min(rows, cols);
					System.out.println("Các phần tử nằm trên đường chéo chính: ");
					for (int i = 0; i < length; i++) {
						for (int j = 0; j < length; j++) {
							if (i == j) {
								totalMainDiagonal += numberArr[i][j];
								System.out.printf("%5d", numberArr[i][j]);
							} else {
								System.out.printf("%5s", "");
							}
						}
						System.out.println();
					}
					System.out.println("Tổng các phần tử trên đường chéo chính: " + totalMainDiagonal);

					// In các phần tử nằm trên đường chéo phụ
					int totalSecondaryDiagonal = 0;
					System.out.println("Các phần tử nằm trên đường chéo phụ: ");
					if (rows == cols) {
						for (int i = 0; i < rows; i++) {
							for (int j = 0; j < cols; j++) {
								if (i + j == cols - 1) {
									totalSecondaryDiagonal += numberArr[i][j];
									System.out.printf("%5d", numberArr[i][j]);
								} else {
									System.out.printf("%5s", "");
								}
							}
							System.out.println();
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
								if (numberArr[indexMax][i] > numberArr[k][i]) {
									indexMax = k;
								}
							}
							if (indexMax != j) {
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
					System.out.print("Các phần tử số nguyên tố trong mảng: ");
					for (int i = 0; i < rows; i++) {
						for (int j = 0; j < cols; j++) {
							int number = numberArr[i][j];
							boolean isPrime = true;
							if (number >= 2) {
								for (int k = 2; k <= Math.sqrt(number); k++) {
									if (number % k == 0) {
										isPrime = false;
										break;
									}
								}
							} else {
								isPrime = false;
							}
							if (isPrime) {
								System.out.printf("%5d", number);
							}
						}
					}

					break;
				case 7:
					// Sử dụng thuật toán hoán đổi sắp xếp các phần tử trên đường chéo chính của mảng giảm dần
					int lengthMainDiagonal = (int) Math.min(rows, cols);
					for (int i = 0; i < lengthMainDiagonal - 1; i++) {
						for (int j = i + 1; j < lengthMainDiagonal; j++) {
							if (numberArr[i][i] < numberArr[j][j]) {
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
					System.out.println("Nhập vào các phần tử của mảng");
					int[] insertArr = new int[cols];
					for (int i = 0; i < insertArr.length; i++) {
						System.out.printf("Nhập vào phần tử %d: ", i + 1);
						insertArr[i] = Integer.parseInt(scanner.nextLine());
					}
					System.out.print("Nhập chỉ số dòng muốn chèn vào mảng 2 chiều: ");
					int insertIndex = Integer.parseInt(scanner.nextLine());
					if (insertIndex < 0 || insertIndex > rows) {
						System.err.printf("Chỉ số chèn vào không hợp lệ. Phải >= 0 và <= %d", rows);
						break;
					}

					// Tạo mảng 2 chiều mới và copy dữ liệu
					int[][] newNumberArr = new int[rows + 1][cols];
					// Copy các dòng trước dòng cần chèn
					for (int i = 0; i < insertIndex; i++) {
						for (int j = 0; j < cols; j++) {
							newNumberArr[i][j] = numberArr[i][j];
						}
					}
					// Copy các dòng cần chèn
					for (int i = 0; i < cols; i++) {
						newNumberArr[insertIndex][i] = insertArr[i];
					}
					// Copy các dòng sau dòng cần chèn
					for (int i = rows; i > insertIndex; i--) {
						for (int j = 0; j < cols; j++) {
							newNumberArr[i][j] = numberArr[i - 1][j];
						}
					}

					// Gán lại vào mảng cũ
					numberArr = newNumberArr;
					rows++;
					break;

				case 9:
					System.exit(0);
				default:
					System.err.println("Vui lòng nhập vào số 1-9");
			}
		} while (true);
	}
}
