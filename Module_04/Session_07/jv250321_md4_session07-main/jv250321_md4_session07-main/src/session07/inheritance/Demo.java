package session07.inheritance;

public class Demo {
    public static void main(String[] args) {
        Person[] arrPerson = new Student[10];
        arrPerson[0] = new Teacher();
        arrPerson[1] = new Student();
        arrPerson[2] = new ClassA();
        Person student = new Student();
    }
}
