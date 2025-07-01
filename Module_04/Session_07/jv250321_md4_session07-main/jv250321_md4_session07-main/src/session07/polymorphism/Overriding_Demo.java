package session07.polymorphism;

public class Overriding_Demo extends Person {
    /*
     * Ghi đè:
     * 1. Điều kiện cần: có quan hệ kế thừa
     * 2. Điều kiện đủ:
     *   - Có kiểu dữ liệu trả về, tên phương thức, tham số giống nhau
     *   - Phương thức ghi đè có bổ từ truy cập có phạm vi lớn hơn hoặc bằng phương thức bị ghi đè
     * */
    @Override
    public int add(int firstNumber, int secondNumber) {
        return (firstNumber + secondNumber) * 2;
    }
}
