import java.util.Scanner;

public class BirthDateTime {
    public static void main(String[] args) {
        //Use the getRangedInt method to input the year (1950-2015), month (1-12), Day*, hours (1 – 24), Minutes (1-59) of a person's birth.
        //Note: Use a switch() conditional selector structure to limit the user to the correct number of days for the month they were born in. For instance, if they were born in Feb [1-29], Oct [1-31].
        //HINT: There are only 3 groups here, not 12 different ones!
        int birthYear;
        int birthMonth;
        int birthDate;
        int birthHours;
        int maxDateInMonth;

        Scanner pipe = new Scanner(System.in);

        // Get the birth year
        birthYear = SafeInput.getRangedInt(pipe, "Please enter your birth year", 1950, 2015);

        // Get the birth month
        birthMonth = SafeInput.getRangedInt(pipe, "Please enter your birth month number", 1, 12);

        // Get the birth date
        maxDateInMonth = switch (birthMonth) {
            case 2                 -> 29;                                    // February
            case 4, 6, 9, 11       -> 30;                                    // Apr, Jun, Sep, Nov
            case 1, 3, 5, 7, 8, 10, 12  -> 31;                               // Jan,Mar,May,Jul,Aug,Oct,Dec
            default                -> throw new IllegalArgumentException(
                    "Invalid month: " + birthMonth);                         // Shouldn't happen with checks from SafeInput
        };

        birthDate = SafeInput.getRangedInt(pipe, "What day of that month", 1, maxDateInMonth);

        // Get the birth hour
        birthHours = SafeInput.getRangedInt(pipe, "At what hour", 1, 24);

        // Return all results
        System.out.println("You were born at " + birthHours + " o'clock on the " + birthDate + " day of the " + birthMonth + " month in the year " + birthYear + ".");

        // Close the pipe
        pipe.close();
    }
}
