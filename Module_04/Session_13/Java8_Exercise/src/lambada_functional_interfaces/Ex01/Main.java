package lambada_functional_interfaces.Ex01;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main (String[] args) {
		List <String> names = Arrays.asList("John", "Alexander", "Bob", "Christine");

		// Sắp xếp theo độ dài chuỗi tăng dần
		names.sort((s1, s2) -> s1.length() - s2.length());

		// In kết quả
		System.out.println("Danh sách sau khi sắp xếp theo độ dài:");
		names.forEach(System.out::println);
	}
}
