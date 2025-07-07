import java.util.Scanner;

public class SafeInput {


    // --------------------------------------------------------------------------------
    // Prevent instantiation
    // --------------------------------------------------------------------------------
    private SafeInput() {
        // By throwing here, even reflection-based instantiation fails fast.
        throw new AssertionError("SafeInput is a utility class and cannot be instantiated");
    }

    // --------------------------------------------------------------------------------
    // Public static helper methods
    // --------------------------------------------------------------------------------

    /**
     * Copyright © 2019-present, University of Cincinnati, Ohio. All rights reserved.
     * Prompts the user until they type a non-empty line
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to length zero. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.isEmpty());

        return retString;

    }

    /**
     * Prompts the user until they type a valid integer.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt text to show the user
     * @return       a valid integer read from the user
     */
    public static int getInt(Scanner pipe, String prompt) {
        String userInput;
        while (true) {
            System.out.print("\n" + prompt + ": ");
            userInput = pipe.nextLine().trim();

            try {
                return Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                // If it's all digits (with optional leading -), then parseInt failed due to range:
                if (userInput.matches("-?\\d+")) {
                    System.out.println(userInput
                            + " is outside the supported range of ["
                            + Integer.MIN_VALUE + " … " + Integer.MAX_VALUE + "].");
                } else {
                    // Otherwise, it really isn’t an integer literal:
                    System.out.println(userInput + " is not a valid integer.");
                }
            }
        }
    }

    /**
     * Prompts until the user types a syntactically valid double
     * that also isn’t infinite.
     *
     * @param pipe   a Scanner on System.in
     * @param prompt the text to show the user
     * @return       the parsed double
     */
    public static double getDouble(Scanner pipe, String prompt) {
        String userInput;

        while (true) {
            System.out.print("\n" + prompt + ": ");
            userInput = pipe.nextLine().trim();

            try {
                double result = Double.parseDouble(userInput);
                if (Double.isInfinite(result)) {
                    System.out.println(userInput
                            + " is outside the supported range of a Java double.");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not a valid double.");
            }
        }
    }

    /**
     * Prompts the user until they enter an integer within the inclusive range [low–high].
     * Appends the range to the supplied prompt and uses SafeInput.getInt() to validate input.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the base message to display; the range “[low–high]” will be appended
     * @param low    the minimum acceptable integer value (inclusive)
     * @param high   the maximum acceptable integer value (inclusive)
     * @return       a valid integer between low and high, inclusive
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {

        // Guard against impossible requests
        if (low > high) {
            throw new IllegalArgumentException(
                    "getRangedInt: invalid bounds — low (" + low + ") must be <= high (" + high + ")");
        }

        int userRangedInt;
        String rangedPrompt = prompt + " [" + low + " to " + high + "]";

        do {
            userRangedInt = SafeInput.getInt(pipe, rangedPrompt);
            if (userRangedInt < low) {
                System.out.println(
                        userRangedInt + " is below the minimum allowed value of " + low + ". Please try again.");
            }
            else if (userRangedInt > high) {
                System.out.println(
                        userRangedInt + " is above the maximum allowed value of " + high + ". Please try again.");
            }
        } while (userRangedInt < low || userRangedInt > high);

        return userRangedInt;
    }
}
