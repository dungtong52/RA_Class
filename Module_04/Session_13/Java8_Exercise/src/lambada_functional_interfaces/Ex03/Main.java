package lambada_functional_interfaces.Ex03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	public static void main (String[] args) {
		List <String> words = Arrays.asList("Java", "Lambda", "Stream");

		Function <String, Integer> toLength = str -> str.length();

		List <Integer> lengths = words.stream()
				.map(toLength)
				.collect(Collectors.toList());

		System.out.println("Độ dài từng từ: " + lengths);
	}
}
