package lambda;

public class Demo {
    public static void main(String[] args) {
        //1. Khởi tạo đối tượng if1 gián tiếp từ IFuntionalInterface để tính tổng 5 và 10
        IFunctionalInterface if1 = new IFunctionalInterface() {
            @Override
            public int add(int firstNumber, int secondNumber) {
                return firstNumber + secondNumber;
            }
        };
        System.out.println("Tổng 2 số 5 và 10 là: " + if1.add(5, 10));
        //2. Khởi tạo đối tượng if2 gián tiếp từ IFuntionalInterface sử dụng biểu thức lambda để tính tổng 10 và 20
        IFunctionalInterface if2 = (a, b) -> {
            return a + b;
        };
        System.out.println("Tổng 2 số 10 và 20 là: " + if2.add(10, 20));
        //3. Khởi tạo đối tượng if3 gián tiếp từ IFuntionalInterface sử dụng biểu thức lambda rút gọn để tính tổng 20 và 30
        IFunctionalInterface if3 = (a, b) -> a + b;
        System.out.println("Tổng 2 số 20 và 30 là: " + if3.add(20, 30));
    }
}
