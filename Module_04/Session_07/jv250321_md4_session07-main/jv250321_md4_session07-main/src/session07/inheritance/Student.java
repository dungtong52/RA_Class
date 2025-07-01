package session07.inheritance;

import java.util.Scanner;

public class Student extends Person {
    /*
     * Kế thừa toàn bộ đặc điểm và hành vi của lớp Person
     * - Các thuộc tính: name, age, sex, address
     * - Constructors: 3
     * - Methods: getter/setter, add, hello, inputData
     * */
    //Đặc điểm riêng
    private float avgMarks;
    private String rank;

    //Constructor riêng của nó
    public Student() {
    }

    public Student(String name, int age, boolean sex, String address, float avgMarks, String rank) {
        super(name, age, sex, address);//Constructor của Person
        this.avgMarks = avgMarks;
        this.rank = rank;
    }
    //Method riêng của nó

    public float getAvgMarks() {
        return avgMarks;
    }

    public void setAvgMarks(float avgMarks) {
        this.avgMarks = avgMarks;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void inputDataStudent(Scanner scanner) {
        super.inputData(scanner);
        System.out.println("Nhập vào điểm trung bình:");
        this.avgMarks = scanner.nextFloat();
        System.out.println("Nhập vào xếp loai: ");
        this.rank = scanner.next();
    }

    public void displayDataStudent() {
        System.out.printf("Tên: %s - Tuổi: %d - Giới tính: %s - Địa chỉ: %s\n",
                super.getName(), super.getAge(), super.isSex() ? "Nam" : "Nữ", super.getAddress());
        System.out.printf("Điểm trung bình: %.1f - Xếp hạng: %s\n", this.avgMarks, this.rank);
    }
}
