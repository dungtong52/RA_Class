package validation;

public class Validation {
    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidLength(String input, int maxLength) {
        return isNotEmpty(input) && input.length() <= maxLength;
    }

    public static boolean isIntegerInRange(String input, int min, int max) {
        if (!isNotEmpty(input)) return false;
        try {
            int number = Integer.parseInt(input);
            return number >= min && number <= max;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isPositiveInteger(String input) {
        if (!isNotEmpty(input)) return false;
        try {
            int number = Integer.parseInt(input);
            return number > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isPositiveFloat(String input) {
        if (!isNotEmpty(input)) return false;
        try {
            float number = Float.parseFloat(input);
            return number > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
