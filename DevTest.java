import java.util.Scanner;

public class DevTest {

    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        System.out.println(SafeInput.getRegExString(pipe, "SSN: ", "^\\d{3}-\\d{2}-\\d{4}$"));
    }
}
