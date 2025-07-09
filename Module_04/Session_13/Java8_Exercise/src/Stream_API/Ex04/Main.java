package Stream_API.Ex04;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 12, 18, 20, 22);

        Optional<Integer> result = numbers.stream()
                .filter(n -> n % 5 == 0)
                .findFirst();
        String output = result.map(String::valueOf)
                .orElse("Không tìm thấy");
        System.out.println(output);
    }
}
