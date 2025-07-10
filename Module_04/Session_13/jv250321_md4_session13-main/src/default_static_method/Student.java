package default_static_method;

import java.util.Scanner;

public class Student implements IShop {
    @Override
    public void inputData(Scanner scanner) {

    }

    @Override
    public int add(int firstNumber, int secondNumber) {
        return 2 * (firstNumber + secondNumber);
    }
}
