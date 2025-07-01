package session07.inheritance;

import java.util.Scanner;

public class Person {
    //1. Fields/Attributes/Properties - Thuộc tính thể hiện đặc điểm của đối tượng
    private String name;
    private int age;
    private boolean sex;
    private String address;

    //2. Constructors
    //Default: không khởi tạo bất cứ thông tin gì của đối tượng
    public Person() {
    }

    //Constructor 2 tham số khởi tạo tên và tuổi của đối tương
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Constructor đẩy đủ tham số giúp khởi tạo đầy đủ thông tin của đối tượng
    public Person(String name, int age, boolean sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    //3. Methods
    //3.1. Getter/Setter Methods - lấy và gán giá trị cho các thuộc tính
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //3.2. Method behavior - Phương thức thể hiện hành vi của dối tượng
    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public void hello() {
        System.out.println("Hello Teacher");
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào tên người:");
        this.name = scanner.nextLine();
        System.out.println("Nhập vào tuổi:");
        do {
            this.age = Integer.parseInt(scanner.nextLine());
            if (this.age < 0) {
                System.err.println("Tuổi phải lớn hơn 0");
            } else {
                break;
            }
        } while (true);

        System.out.println("Nhập vào giới tính:");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhập vào địa chỉ:");
        this.address = scanner.nextLine();
    }
}
