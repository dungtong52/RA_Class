package lambada_functional_interfaces.Ex06;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "is", "fun", "stream", "api");

        // Predicate: Lọc từ có độ dài > 3
        Predicate<String> lengthGreaterThan3 = s -> s.length() > 3;

        // Function: Chuyển sang viết hoa
        Function<String, String> toUpperCase = String::toUpperCase;

        // Consumer: In ra từ
        Consumer<String> printWord = System.out::println;

        // Pipeline xử lý
        words.stream()
                .filter(lengthGreaterThan3)     // lọc
                .map(toUpperCase)               // chuyển đổi
                .forEach(printWord);            // hành động
    }
}
