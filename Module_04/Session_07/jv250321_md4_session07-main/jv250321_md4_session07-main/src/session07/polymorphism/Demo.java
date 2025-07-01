package session07.polymorphism;

public class Demo {
    public static void main(String[] args) {
        OverLoading_Demo old = new OverLoading_Demo();
        old.add(5, 10);
        old.add(5, 10, 15);
        Overriding_Demo ord = new Overriding_Demo();
        System.out.println("Tổng 2 số 5 và 10: " + ord.add(5, 10));
    }
}
