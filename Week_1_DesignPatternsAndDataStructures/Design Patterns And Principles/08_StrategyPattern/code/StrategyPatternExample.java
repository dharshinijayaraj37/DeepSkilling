import java.util.Scanner;

// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy: Credit Card
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card (" + cardHolder + ")");
    }
}

// Concrete Strategy: PayPal
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal (" + email + ")");
    }
}

// Context Class
class PaymentContext {
    private PaymentStrategy strategy;

    // Allows changing strategy at runtime
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payAmount(double amount) {
        if (strategy == null) {
            System.out.println("Please select a payment method first.");
        } else {
            strategy.pay(amount);
        }
    }
}

// Test Class
public class StrategyPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        System.out.println("Enter payment amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.println("Select Payment Method (1 = Credit Card, 2 = PayPal):");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter Card Holder Name:");
                String holder = scanner.nextLine();
                System.out.println("Enter Card Number:");
                String cardNumber = scanner.nextLine();
                context.setPaymentStrategy(new CreditCardPayment(cardNumber, holder));
                break;
            case 2:
                System.out.println("Enter PayPal Email:");
                String email = scanner.nextLine();
                context.setPaymentStrategy(new PayPalPayment(email));
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        context.payAmount(amount);
        scanner.close();
    }
}
