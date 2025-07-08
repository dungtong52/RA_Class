package lambada_functional_interfaces.Ex02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
	public static void main (String[] args) {
		List <Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		// Use Predicate<Integer>

		Predicate <Integer> isEven = n -> n % 2 == 0;

		// Lọc số chẵn dùng stream + predicate
		List <Integer> evenNumbers = numbers.stream()
				.filter(isEven)
				.collect(Collectors.toList());

		System.out.println("Các số chẵn: " + evenNumbers);
	}
}
