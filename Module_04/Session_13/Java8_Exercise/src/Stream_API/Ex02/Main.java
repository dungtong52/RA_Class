package Stream_API.Ex02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -2, 8, 10, -5);

        OptionalDouble average = numbers.stream()
                .filter(number -> number > 0)
                .mapToInt(Integer::intValue)
                .average();
        if (average.isPresent()) {
            System.out.println("Trung bình cộng các số dương: " + average.getAsDouble());
        } else {
            System.out.println("Không có số dương trong danh sách.");
        }
    }
}
