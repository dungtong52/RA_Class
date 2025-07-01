package session07.polymorphism;

public class OverLoading_Demo {
    /*
     * 1. Điều kiện cần: các phương thức nạp chồng phải cùng tên và trong cùng 1 lớp
     * 2. Điều kiện đủ:
     *   - Kiểu dữ liệu các tham số của các phương thức khác nhau
     *   - Số lượng tham số các phương thức khác nhau
     *   - Vị trí tham số các phương thức khác nhau
     * */
    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public float add(float firstNumber, float secondNumber) {
        return firstNumber + secondNumber;
    }

    public int add(int firstNumber, int secondNumber, int thirdNumber) {
        return firstNumber + secondNumber + thirdNumber;
    }

    public void printInfomation(int a, String b) {
        System.out.printf("Information: %d - %s\n", a, b);
    }

    public void printInfomation(String a, int b) {
        System.out.println("A = " + a);
        System.out.println("B = " + b);
    }
}
