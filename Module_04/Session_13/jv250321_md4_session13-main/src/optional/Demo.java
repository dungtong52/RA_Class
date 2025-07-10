package optional;

import stream.Student;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Student student = null;//null
        if (student != null) {
            System.out.println(student.getStudentName());
        }

        //Khởi tạo đối tượng optional empty
        Optional<Student> optStudentEmpty = Optional.empty();
        //Khởi tạo đối tượng optional null
        Optional<Student> optStudentNull = Optional.ofNullable(null);
        //Khởi tạo đối tượng optional từ đối tượng có sẵn
        Student student1 = new Student("SV001", "Nguyễn Văn A", 20);
        Optional<Student> optStudent = Optional.of(student1);

        System.out.println("Optinal Empty: " + optStudentEmpty.isPresent());
        System.out.println("Optinal Null: " + optStudentNull.isPresent());
        System.out.println("Optional Student: " + optStudent.isPresent());

        if (optStudent.isPresent()) {
            System.out.println("Tên sinh viên là: " + optStudent.get().getStudentName());
        }

        optStudent.ifPresent(st -> System.out.println("Tuổi sinh viên: " + st.getAge()));
        optStudentEmpty.ifPresentOrElse(student2 -> {
            //Thực hiện chức năng khi có giá trị
            System.out.println("Có giá trị");
        }, () -> {
            //Thực hiện chức năng khi không có giá trị
            System.out.println("Không có giá trị");
        });
    }
}
