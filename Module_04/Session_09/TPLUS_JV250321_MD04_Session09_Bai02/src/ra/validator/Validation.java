package ra.validator;

import java.util.Scanner;

public class Validation {
    public static boolean isEmpty(String inputData) {
        if (inputData != null && !inputData.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
