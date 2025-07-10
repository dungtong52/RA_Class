package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Student student1 = new Student("SV001", "Nguyễn Văn A", 20);
        Student student2 = new Student("SV002", "Nguyễn Văn C", 18);
        Student student3 = new Student("SV003", "Nguyễn Văn D", 20);
        Student student4 = new Student("SV004", "Nguyễn Văn B", 22);
        Student student5 = new Student("SV005", "Nguyễn Văn E", 20);
        Student student6 = new Student("SV006", "Nguyễn Văn F", 19);
        List<Student> listStudents = new ArrayList<Student>();
        listStudents.add(student1);
        listStudents.add(student2);
        listStudents.add(student3);
        listStudents.add(student4);
        listStudents.add(student5);
        listStudents.add(student6);
        /*
         * Stream:
         * - B1: Chuyển từ Collection, Array --> Stream
         * - B2: Sử dụng các phương thức thao tác trung gian để xử lý dữ liệu (0-N phương thức)
         * - B3: Sử dụng các phương thức thao tác đầu cuối để trả ra dữ liệu (0-N phương thức)
         * */
        //1. In thông tin các sinh viên có tuổi lớn hơn hoặc bằng 20
        System.out.println("Thông tin các sinh viên có tuổi lớn hơn 20:");
        listStudents.stream()//B1
                .filter(student -> student.getAge() >= 20)//B2
                .forEach(System.out::println);//B3
        //2. In thông tin 2 sinh viên đầu tiên có tuổi nhỏ hơn 25
        System.out.println("Thông tin 2 sinh viên đầu tiên có tuổi nhỏ hơn 25:");
        listStudents.stream()
                .filter(student -> student.getAge() < 25).limit(2)
                .forEach(System.out::println);
        //3. In thông tin 2 sinh viên có tuổi nhỏ hơn 25 bỏ qua 1 sinh viên đầu
        System.out.println("Thông tin 2 sinh viên có tuổi nhỏ hơn 25 bỏ qua 1 sinh viên đầu:");
        listStudents.stream()
                .filter(student -> student.getAge() < 25).skip(1).limit(2)
                .forEach(System.out::println);
        //4. In ra tất cả các tuổi của sinh viên với giá trị x2 so với tuổi thật
        System.out.println("Tất cả các tuổi của sinh viên với giá trị x2 so với tuổi thật:");
        listStudents.stream()
                .map(student -> student.getAge() * 2)
                .forEach(System.out::println);
        //5. Sắp xếp các sinh viên theo tuổi tăng dần
        System.out.println("Sinh viên sau khi sắp xếp theo tuổi tăng dần:");
        listStudents.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .forEach(System.out::println);
        //6. Sắp xếp các sinh viên theo tuổi tăng dần, sinh viên bằng tuổi thì sắp xếp theo tên giảm dần
        System.out.println("Sắp xếp các sinh viên theo tuổi tăng dần, sinh viên bằng tuổi thì sắp xếp theo tên giảm dần:");
        listStudents.stream()
                .sorted(Comparator.comparing(Student::getAge).thenComparing(Comparator.comparing(Student::getStudentName).reversed()))
                .forEach(System.out::println);
        //7. Lấy danh sách các sinh viên có tuổi từ 18 đến 20
        List<Student> list18_20 = listStudents.stream()
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 20)
//                .collect(Collectors.toList());
                .toList();
        System.out.println("Các sinh viên từ 18-20:");
        list18_20.forEach(System.out::println);
        //8. Kiểm tra trong danh sách có sinh viên nào có tuổi lớn hơn 21 hay không
        System.out.println("Kiểm tra tuổi sinh viên > 21: " + listStudents.stream()
                .anyMatch(student -> student.getAge() > 21));
        //9. In ra số lượng sinh viên có tuổi lớn hơn 18
        long cntStudent = listStudents.stream()
                .filter(student -> student.getAge() > 18)
                .count();
        System.out.println("Số sinh viên có tuổi lớn hơn 18 là: " + cntStudent);
        //10. In ra thông tin sinh viên có tuổi lớn nhất
        System.out.println("Thông tin sinh viên có tuổi lớn nhất:");
        Student student = listStudents.stream()
                .max(Comparator.comparing(Student::getAge)).get();
        System.out.println(student);
        //In Thông tin các sinh viên
//        listStudents.forEach(System.out::println);
    }
}
