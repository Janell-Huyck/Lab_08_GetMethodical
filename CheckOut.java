import java.util.Scanner;

public class CheckOut {
    public static void main(String[] args) {
        //At the 10$ store nothing is more than $10.00. Prompt the user for the price of their item (.50 cents to $10.00 dollars) using the getRangedDouble method and continue to input items as long as they indicate that they have more using your getYNConfirm method.
        //Display the total cost of the item(s) to 2 decimal places with printf.
        boolean continueCheckout = true;
        double totalCost = 0;
        double nextItem;
        Scanner pipe = new Scanner(System.in);

        while (continueCheckout) {
            nextItem = SafeInput.getRangedDouble(pipe, "How much is the next item? ", 0.5, 10);
            totalCost = totalCost + nextItem;
            continueCheckout = SafeInput.getYNConfirm(pipe, "Continue checking out?");
        }

        System.out.printf("Your total cost is: %.2f%n", totalCost);
        pipe.close();

    }
}
