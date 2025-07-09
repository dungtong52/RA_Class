package lambada_functional_interfaces.Ex04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Consumer<String> nameConsumer = name -> System.out.println(name + " - processed");

        names.forEach(nameConsumer);
    }
}
