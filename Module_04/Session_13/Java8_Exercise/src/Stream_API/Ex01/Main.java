package Stream_API.Ex01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
	public static void main (String[] args) {
		List <Integer> list = Arrays.asList(5, 11, 20, 3, 15, 7);

		Predicate<Integer> greaterThan10 = n -> n > 10;
		long countNumber = list.stream()
				.filter(greaterThan10)
				.count();

		System.out.println("Số phần tử lớn hơn 10 là: " + countNumber);
	}
}
