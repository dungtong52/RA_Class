package session07.abstraction;

import java.util.Scanner;

public interface IShop {
    public static final float PI = 3.14F;
    int MARK_PASS = 5;

    public abstract void hello();

    void inputData(Scanner scanner);

    void displayData();
}
