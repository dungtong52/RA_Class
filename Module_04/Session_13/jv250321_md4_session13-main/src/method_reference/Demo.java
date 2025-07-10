package method_reference;


import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> listStudentNames = Arrays.asList("Nguyễn Văn A", "Nguyễn Văn B");
        //In thông tin các sinh viên sử dụng vòng lặp foreach
        System.out.println("Các tên sinh viên in theo foreach:");
        for (String name : listStudentNames) {
            System.out.println(name);
        }
        //In thông tin các sinh viên sử dụng vòng lặp foreach của Collection và biểu thức lambda
        System.out.println("Các tên sinh viên in theo foreach và biểu thức lambda:");
        listStudentNames.forEach(name -> System.out.println(name));
        //In thông tin các sinh viên sử dụng foreach + lambda + method Reference
        listStudentNames.forEach(System.out::println);

    }
}
