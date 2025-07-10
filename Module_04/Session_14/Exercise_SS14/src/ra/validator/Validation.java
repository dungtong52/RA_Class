package ra.validator;

public class Validation {
    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isIntegerInRange(String input, int min, int max) {
        if (isEmpty(input)) return false;
        try {
            int number = Integer.parseInt(input);
            return number >= min && number <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isPositiveInteger(String input) {
        if (isEmpty(input)) return false;
        try {
            int number = Integer.parseInt(input);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPositiveFloat(String input) {
        if (isEmpty(input)) return false;
        try {
            float number = Float.parseFloat(input);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
