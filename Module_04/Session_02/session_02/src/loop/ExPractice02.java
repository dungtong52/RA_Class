package loop;

import java.util.Scanner;

public class ExPractice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //C3: khai báo tổng số học viên, tổng điểm, max, min
        int cntStudents = 0;
        float totalMarks = 0;
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        /*
         * - Menu phải được lặp đi lặp lại đến khi chọn thoát (chưa biết trước số vòng lặp) --> while hoặc do...while
         * - Menu phải hiển thị ít nhất 1 ần: do...while
         * */
        do {
            System.out.println("************MENU NHẬP ĐIỂM******************");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            /*
             * Điều kiện xét trên từng giá trị --> switch...case
             * */
            switch (choice) {
                case 1:
                    //Nhập điểm
                    do {
                        System.out.println("Nhập điểm học viên:");
                        float mark = Float.parseFloat(scanner.nextLine());
                        if (mark == -1) {
                            break;
                        } else if (mark < 0 || mark > 10) {
                            System.err.println("Điểm trong khoảng 0-10, vui lòng nhập lại");
                        } else {
                            //Điểm hợp lệ
                            //1. Xếp loại
                            String rank = "Xếp loại: ";
                            if (mark < 5) {
                                rank += "Yếu";
                            } else if (mark < 7) {
                                rank += "Trung bình";
                            } else if (mark < 8) {
                                rank += "Khá";
                            } else if (mark < 9) {
                                rank += "Giỏi";
                            } else {
                                rank += "Xuất sắc";
                            }
                            System.out.println(rank);
                            //Tính toán tổng sinh viên, tổng điểm, max, min
                            cntStudents++;
                            totalMarks += mark;
                            if (max < mark) {
                                max = mark;
                            }
                            if (min > mark) {
                                min = mark;
                            }
                        }
                    } while (true);
                    break;
                case 2:
                    if (cntStudents == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.printf("Số học viên: %d - Điểm trung bình: %.1f - Điểm lớn nhất: %.1f - Điểm nhỏ nhất: %.1f\n",
                                cntStudents, totalMarks / cntStudents, max, min);
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-3");
            }
        } while (true);
    }
}
