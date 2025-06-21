import java.util.Scanner;

public class RecursiveForecasting {

    // Step 2 & 3: Recursive method to forecast value
    public static double forecastValue(double initial, double rate, int year) {
        if (year == 0) return initial;  // base case
        return forecastValue(initial, rate, year - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input initial data
        System.out.print("Enter initial amount (e.g. 10000): ");
        double initial = sc.nextDouble();

        System.out.print("Enter annual growth rate (in %, e.g. 10 for 10%): ");
        double rate = sc.nextDouble() / 100;

        System.out.print("Enter number of years to predict: ");
        int years = sc.nextInt();

        // Forecast each year
        System.out.println("\n📈 Forecasted Values:");
        for (int i = 0; i <= years; i++) {
            double value = forecastValue(initial, rate, i);
            System.out.printf("Year %d: $%.2f\n", i, value);
        }

        sc.close();
    }
}
