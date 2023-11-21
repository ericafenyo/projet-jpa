package fr.diginamic.util;

/**
 * Utility class with helper method for validating numbers.
 */
public class Numbers {

    /**
     * Check if the given value is an integer string
     *
     * @param value the input to be validated
     * @return true if the value is an integer string. false otherwise.
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    /**
     * Check if the given value is a number string.
     *
     * @param value the input to be validated
     * @return true if the value is a number string. false otherwise.
     */
    public static boolean isNumeric(String value) {
        try {
            Double.valueOf(value);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    /**
     * Check if the given value is within a range
     *
     * @param value the input to be validated
     * @param min   the minimum bounds
     * @param max   the maximum bounds
     * @return true if the value is within the bounds
     */
    public static boolean withinRange(int value, int min, int max) {
        return (value >= min && value <= max);
    }

    /**
     * Check if the length of the given value is not more that the max bounds.
     *
     * @param value the input to be validated
     * @param max   the maximum bounds
     * @return true if the value is not greater than the max bounds
     */
    public static boolean isMax(String value, int max) {
        return value.length() <= max;
    }
}
