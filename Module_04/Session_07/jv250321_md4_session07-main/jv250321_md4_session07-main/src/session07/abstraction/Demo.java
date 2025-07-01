package session07.abstraction;

public class Demo {
    public static void main(String[] args) {
        //Khởi tạo đối tượng gián tiếp từ lớp trừu tượng Person
        Person person = new Person() {
            @Override
            public int add(int firstNumber, int secondNumber) {
                return 0;
            }

            @Override
            public void display() {

            }
        };
        Person person2 = new Student();
    }
}
