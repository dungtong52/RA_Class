package practice.entity;

import practice.presentation.StudentManagement;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student implements IStudent {
    private String studentId;
    private String studentName;
    private int age;
    private String major;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.major = major;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void inputData(Scanner scanner) {
        //Mã sinh viên gồm 5 ký tự: bắt buộc nhập, 2 ký tự đầu là SV, 3 ký tự là số, không trùng lặp
        this.studentId = inputStudentId(scanner);
        //Tên sinh viên có từ 10 - 50 ký tự, bắt buộc nhập
        this.studentName = inputStudentName(scanner);
        //Tuổi: bắt buộc phải nhập, phải là số nguyên, có giá trị lớn hơn hoặc bằng 18
        this.age = inputAge(scanner);
        //Chuyên ngành: bắt buộc phải nhập
        this.major = inputMajor(scanner);
    }

    public boolean isEmpty(String data) {
        if (data != null && !data.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public String inputStudentId(Scanner scanner) {
        String studentIdRegex = "SV\\d{3}";
        System.out.println("Nhập vào mã sinh viên:");
        do {
            String studentId = scanner.nextLine();
            if (isEmpty(studentId)) {
                System.err.println("Vui lòng nhập mã sinh viên");
            } else {
                if (Pattern.matches(studentIdRegex, studentId)) {
                    boolean isExist = false;
                    for (int i = 0; i < StudentManagement.currentIndex; i++) {
                        if (StudentManagement.students[i].studentId.equals(studentId)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) {
                        return studentId;
                    }
                    System.err.println("Mã sinh viên đã tồn tại, vui lòng nhập lại");
                } else {
                    System.err.println("Mã sinh viên gồm 5 ký tự: bắt đầu là SV, 3 ký tự cuối là sô, vui lòng nhập lại");
                }
            }
        } while (true);
    }

    public String inputStudentName(Scanner scanner) {
        String studentNameRegex = "\\w{10,50}";
        System.out.println("Nhập vào tên sinh viên:");
        do {
            String studentName = scanner.nextLine();
            if (isEmpty(studentName)) {
                System.err.println("Vui lòng nhập tên sinh viên");
            } else {
                if (Pattern.matches(studentNameRegex, studentName)) {
                    return studentName;
                }
                System.err.println("Tên sinh viên phải gồm 10-50 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    public int inputAge(Scanner scanner) {
        System.out.println("Nhập vào tuổi sinh viên:");
        do {
            if (scanner.hasNextInt()) {
                int age = Integer.parseInt(scanner.nextLine());
                if (age >= 18) {
                    return age;
                }
                System.err.println("Tuổi sinh viên phải có giá trị lớn hơn hoặc bằng 18, vui lòng nhập lại");
            } else {
                System.err.println("Tuổi sinh viên phải là một số nguyên, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputMajor(Scanner scanner) {
        System.out.println("Nhập vào chuyên ngành sinh viên:");
        do {
            String major = scanner.nextLine();
            if (!isEmpty(major)) {
                return major;
            }
            System.err.println("Vui lòng nhập vào chuyên ngành:");
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d - Chuyên ngành: %s\n",
                this.studentId, this.studentName, this.age, this.major);
    }
}
