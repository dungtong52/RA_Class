package lambada_functional_interfaces.Ex05;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Supplier <Integer> randomSupplier = () -> random.nextInt(100) + 1;

        Stream.generate(randomSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}

//random.nextInt(100) + 1 tạo số ngẫu nhiên từ 1 đến 100 (vì nextInt(100) sinh ra số từ 0 đến 99).
//Supplier<Integer> là một functional interface đại diện cho hàm không đầu vào nhưng có đầu ra.
//Stream.generate(supplier) sẽ tạo ra luồng vô hạn các giá trị do supplier cung cấp.
//.limit(5) lấy 5 phần tử đầu tiên từ luồng.
