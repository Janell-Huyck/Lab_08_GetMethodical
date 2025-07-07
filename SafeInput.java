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

}
