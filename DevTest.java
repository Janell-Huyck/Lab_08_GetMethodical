import java.util.Scanner;

public class DevTest {

    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        System.out.println(SafeInput.getRangedDouble(pipe, "Please enter a double", -11.5, -11.5));
    }
}
