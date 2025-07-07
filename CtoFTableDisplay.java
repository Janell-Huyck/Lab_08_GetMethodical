public class CtoFTableDisplay {
    public static void main(String[] args) {
        double fahrenheit;

        System.out.printf("%8s | %10s%n", "Celsius", "Fahrenheit");
        System.out.println("---------+------------");

        for (int celsius = -100; celsius <= 100; celsius++) {
            fahrenheit = CtoF(celsius);
            System.out.printf("%8d │ %12.2f%n", celsius, fahrenheit);
        }
    }

    public static double CtoF(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }

}
