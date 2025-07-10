package default_static_method;

import java.util.Scanner;

public interface IShop {
    void inputData(Scanner scanner);

    default int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    static int multi(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
