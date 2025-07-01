package session07.abstraction;

public abstract class Person {
    //Phương thức thực thi - Phương thức có thân
    public void hello() {
        System.out.println("Hello");
    }
    //Phương thức trừu tượng - Phương thức không có thân
    //Các lớp thực thi kế thừa lớp Person bắt buộc phải triển khai các phương thức trừu tượng của Person
    public abstract int add(int firstNumber, int secondNumber);
    public abstract void display();
}
