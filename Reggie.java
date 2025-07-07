import java.util.Scanner;

public class Reggie {
    public static void main(String[] args) {
        //Use your getRegExString method several times.
        Scanner pipe = new Scanner(System.in);
        String ssn;
        String mNumber;
        String menuChoice;

        // Get a SSN from the user using this pattern: ^\\d{3}-\\d{2}-\\d{4}$
        ssn = SafeInput.getRegExString(pipe, "Please enter a **FAKE** SSN (###-##-####). Do not enter an actual SSN.", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println("You entered " + ssn + " for an SSN.");

        // Get a UC Student M number using this pattern ^(M|m)\\d{5}$
        mNumber = SafeInput.getRegExString(pipe, "Please enter a student M-number (M#####)", "^(M|m)\\d{5}$");
        System.out.println("You entered " + mNumber + " for an M-number.");

        // Get a menu choice using this pattern ^[OoSsVvQq]$
        //these letters are mnemonics for the menu choices Open Save View Quit
        menuChoice = SafeInput.getRegExString(pipe, "Enter menu choice (O/S/V/Q)", "^[OoSsVvQq]$");
        System.out.println("You entered " + menuChoice + " for a menu choice.");

        pipe.close();
    }
}
