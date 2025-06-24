package loop;

import java.util.Scanner;

public class ExPractice03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countEmployee = 0;
        float totalSalary = 0;
        float bonusPercent = 0;
        float totalBonus = 0;
        float maxSalary = Float.MIN_VALUE;
        float minSalary = Float.MAX_VALUE;

        // In Menu
        do {
            System.out.println("***************MENU NHẬP LƯƠNG***************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Nhập lương nhân viên: ");
                        float salary = Float.parseFloat(sc.nextLine());
                        if (salary == -1) {
                            break;
                        } else if (salary < 0 || salary > 500000000) {
                            System.out.println("Vui lòng nhập lương từ 0-500");
                        } else {
                            String rank = "Thu nhập ";
                            if (salary < 5) {
                                rank += "thấp";
                                bonusPercent = 0.05F;
                            } else if (salary < 15) {
                                rank += "trung bình";
                                bonusPercent = 0.1F;
                            } else if (salary < 50) {
                                rank += "khá";
                                bonusPercent = 0.15F;
                            } else if (salary < 100) {
                                rank += "cao";
                                bonusPercent = 0.2F;
                            } else {
                                rank += "cao";
                                bonusPercent = 0.25F;
                            }
                        }

                        // Tính totalSalary, countEmployee, maxSalary, minSalary
                        totalSalary += salary;
                        totalBonus += salary * bonusPercent;
                        countEmployee++;
                        if (maxSalary < salary) maxSalary = salary;
                        if (minSalary > salary) minSalary = salary;
                    } while (true);
                    break;
                case 2:
                    if (countEmployee == 0)
                        System.out.println("Chưa có dữ liệu");
                    else {
                        System.out.println("Số nhân viên đã nhập: " + countEmployee);
                        System.out.printf("Tổng tiền lương: %,.0f VND\n", totalSalary);
                        System.out.printf("Lương trung bình: %,.0f VND\n", totalSalary / countEmployee);
                        System.out.printf("Lương cao nhất: %,.0f VND\n", maxSalary);
                        System.out.printf("Lương thấp nhất: %,.0f VND\n", minSalary);
                    }
                    break;
                case 3:
                    System.out.println("Tổng số tiền thưởng cho nhân viên: " + totalBonus);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-4");
            }
        } while (true);
    }
}
