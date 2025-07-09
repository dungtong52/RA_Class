package Stream_API.Ex03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("java", "stream", "lambda");

        Function<String, String> strUpperCase = String::toUpperCase;
        String result = str.stream()
                .map(strUpperCase)
                .collect(Collectors.joining(" - "));
        System.out.println(result);
    }
}
