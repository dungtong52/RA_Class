package practice.presentation;

import practice.entity.Student;

import java.util.Scanner;

public class StudentManagement {
    public static Student[] students = new Student[100];
    public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**********QUẢN LÝ SINH VIÊN*****************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm sinh viên theo tên");
            System.out.println("6. Sắp xếp sinh viên theo tên giảm dần");
            System.out.println("7. Sắp xếp sinh viên theo tuổi tăng dần");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayListStudents();
                    break;
                case 2:
                    createStudent(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    searchStudentByName(scanner);
                    break;
                case 6:
                    sortStudentByNameDESC();
                    break;
                case 7:
                    sortStudentByAgeASC();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-8");
            }

        } while (true);
    }

    public static void displayListStudents() {
        for (int i = 0; i < currentIndex; i++) {
            students[i].displayData();
        }
    }

    public static void createStudent(Scanner scanner) {
        System.out.println("Nhập vào số sinh viên cần thêm:");
        int cntStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cntStudents; i++) {
            students[currentIndex] = new Student();
            students[currentIndex].inputData(scanner);
            currentIndex++;
        }
    }

    public static void updateStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần cập nhật:");
        String studentId = scanner.nextLine();
        int indexUpdate = findIndexById(studentId);
        if (indexUpdate == -1) {
            System.err.println("Mã sinh viên không tồn tại!!!!");
        } else {
            //THực hiện cập nhật
            boolean isExit = true;
            Student student = new Student();
            do {
                System.out.println("1. Cập nhật tên sinh viên");
                System.out.println("2. Cập nhật tuổi sinh viên");
                System.out.println("3. Cập nhật chuyên ngành");
                System.out.println("4. Thoát");
                System.out.print("Lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên mới của sinh viên:");
                        String studentName = student.inputStudentName(scanner);
                        students[indexUpdate].setStudentName(studentName);
                        break;
                    case 2:
                        System.out.println("Nhập vào tuổi mới của sinh viên:");
                        students[indexUpdate].setAge(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập vào chuyên ngành mới của sinh viên:");
                        students[indexUpdate].setMajor(scanner.nextLine());
                        break;
                    case 4:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-4");

                }
            } while (isExit);
        }
    }

    public static int findIndexById(String studentId) {
        for (int i = 0; i < currentIndex; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần xóa:");
        String studentId = scanner.nextLine();
        int indexDelete = findIndexById(studentId);
        if (indexDelete == -1) {
            System.err.println("Mã sinh viên không tồn tại");
        } else {
            for (int i = indexDelete; i < currentIndex - 1; i++) {
                students[i] = students[i + 1];
            }
            students[currentIndex - 1] = null;
            currentIndex--;
        }
    }

    public static void searchStudentByName(Scanner scanner) {
        int cntStudents = 0;
        System.out.println("Nhập vào tên sinh viên cần tìm:");
        String studentName = scanner.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (students[i].getStudentName().toLowerCase().contains(studentName.trim().toLowerCase())) {
                students[i].displayData();
                cntStudents++;
            }
        }
        System.out.printf("Có %d sinh viên có tên chứa chuỗi %s\n", cntStudents, studentName);
    }

    public static void sortStudentByNameDESC() {
        //Sắp xếp theo thuật toán hoán đổi
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (students[i].getStudentName().compareTo(students[j].getStudentName()) < 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp xong mảng theo tên giảm dần");
    }

    public static void sortStudentByAgeASC() {
        //Sử dụng thuật toán Selection Sort
        for (int i = 0; i < currentIndex - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < currentIndex; j++) {
                if (students[minIndex].getAge() > students[j].getAge()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = students[i];
                students[i] = students[minIndex];
                students[minIndex] = temp;
            }
        }
        System.out.println("Sắp xếp xong mảng theo tuổi tăng dần");
    }
}
