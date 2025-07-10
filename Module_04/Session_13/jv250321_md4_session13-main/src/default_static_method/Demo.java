package default_static_method;

public class Demo {
    public static void main(String[] args) {
        Person person = new Person();
        Student student = new Student();
        System.out.println("Tổng 2 số 5 và 10 là: " + person.add(5, 10));
        System.out.println("Tổng 2 số 10 và 20 sau khi bị ghi đè:" + student.add(10, 20));

        System.out.println("Tích 2 số 2 và 4 là: " + IShop.multi(2, 4));
    }
}
