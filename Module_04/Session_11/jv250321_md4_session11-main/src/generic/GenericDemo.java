package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        Dictionary<String, String> dictionary1 = new Dictionary<>();
        //K: String, V: String
        dictionary1.setKey("Study");
        dictionary1.setValue("Học");
        System.out.printf("Nghĩa của %s là %s\n", dictionary1.getKey(), dictionary1.getValue());
        Dictionary<Integer, String> dictionary2 = new Dictionary<>();
        //K: Integer, V: String
        dictionary2.setKey(1);
        dictionary2.setValue("Một");
        System.out.printf("Phiên âm của %d là %s\n", dictionary2.getKey(), dictionary2.getValue());

        Integer[] arrInt = {1, 3, 5, 7};
        String[] arrString = {"Nguyễn Văn A", "Nguyễn Văn B"};
        //E: Integer
        Dictionary.printElement(arrInt);
        //E: String
        Dictionary.printElement(arrString);

        List<? extends Teacher> listExtends = new ArrayList<>();
        //Chứa được các đối tượng có kiểu dữ liệu kế thừa từ Teacher
        List<Person> listPersons = new ArrayList<>();
        List<Teacher> listTeachers = new ArrayList<>();
        List<Student> listStudents = new ArrayList<>();
        List<Integer> listInteger = new ArrayList<>();
        printElementOfData(listPersons);
        printElementOfData(listTeachers);
        printElementOfData(listStudents);
        printElementOfData(listInteger);
        printElementExtends(listTeachers);
        printElementExtends(listStudents);
//        printElementExtends(listPersons);
//        printElementExtends(listInteger);
        printElementSuper(listTeachers);
        printElementSuper(listPersons);
//        printElementSuper(listStudents);
//        printElementSuper(listInteger);
    }

    //?: Đại diện cho bất cứ kiểu dữ liệu nào
    public static void printElementOfData(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    //? extend Teacher: đại diện cho các kiểu dữ liệu kế thừa từ Teacher
    public static void printElementExtends(List<? extends Teacher> list) {
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

    public static void printElementSuper(List<? super Teacher> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
