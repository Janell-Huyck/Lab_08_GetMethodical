import java.util.Scanner;

public class FavNumbers {
    /**
     * Prompt the user to enter their favorite integer and then their favorite double. Use the unconstrained getInt and getDouble methods for this.
     */
    public static void main(String[] args) {
        int favInt;
        double favDub;
        Scanner pipe = new Scanner(System.in);

        // Get favorite integer
        favInt = SafeInput.getInt(pipe, "What is your favorite integer");

        // Get favorite double
        favDub = SafeInput.getDouble(pipe, "What is your favorite double");

        System.out.println("Your favorite integer is: " + favInt);
        System.out.println("Your favorite double is: " + favDub);
        pipe.close();
    }
}
