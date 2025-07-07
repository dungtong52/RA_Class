package collection;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionFramework {
    public static void main(String[] args) {
        Student student1 = new Student("SV001", "Nguyễn Văn A", 20);
        Student student2 = new Student("SV002", "Nguyễn Văn C", 18);
        Student student3 = new Student("SV003", "Nguyễn Văn D", 22);
        Student student4 = new Student("SV004", "Nguyễn Văn B", 25);
        List<Student> listStudents = new ArrayList<>();
        List<Student> list = new ArrayList<>();
        //************** COLLECTION INTERFACE **********************
        //boolean add(Object o): thêm phần tử vào cuối danh sách
        boolean result = listStudents.add(student1);
        listStudents.add(student2);
        listStudents.add(student3);
        list.add(student4);
        list.add(student1);
        System.out.println("Kết quả của add student1 vào danh sách: " + result);

        //boolean addAll(Collection c): Thêm 1 collection c vào cuối danh sách
        listStudents.addAll(list);

        //boolean remove(Object o): xóa phần tử o trong danh sách
        listStudents.remove(student4);
        listStudents.remove(student1);

        //int size(): lấy số phần tử của danh sách
        System.out.println("Số phần tử của danh sách: " + listStudents.size());

        //void clear(): xóa hết các phần tử trong danh sách
//        listStudents.clear();
        //Iterator interator(): chuyển từ Collection --> Interator
        Iterator<Student> iterator = listStudents.iterator();
        System.out.println("DANH SÁCH SINH VIEN DUYỆT VỚI ITERATOR:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //boolean isEmpty(): Kiểm tra danh sách có empty hay khng
        System.out.println("Kiểm tra listStudents có empty không: " + listStudents.isEmpty());

        //int hashCode(): Trả về mã băm của Collection
        System.out.println("Mã băm: " + listStudents.hashCode());

        //************** LIST INTERFACE **********************
        //void add(int index, Object o): Chèn phần tử o vào vị trí index trong danh sách
        listStudents.add(1, student4);
        //Object get(int index): Lấy phần tử tại chỉ số index
        System.out.println("Phần tử ở chỉ số 1 trong listStudents là: " + listStudents.get(1));
        //Object set(int index, Object o): đè đối tượng o vào chỉ số index
        listStudents.set(1, student1);
        //Object remove(int index): Xóa phần tử ở chỉ số index
        listStudents.remove(1);
        System.out.println("THÔNG TIN DANH SÁCH SINH VIÊN:");
        for (Student student : listStudents) {
            System.out.println(student);
        }
    }
}
