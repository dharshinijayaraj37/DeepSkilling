
interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal");
    }
}

class CreditCardGateway {
    public void makeTransaction(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}


class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway = new PayPalGateway();

    public void processPayment(double amount) {
        gateway.sendPayment(amount);
    }
}
class CreditCardAdapter implements PaymentProcessor {
    private CreditCardGateway gateway = new CreditCardGateway();

    public void processPayment(double amount) {
        gateway.makeTransaction(amount);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter();
        PaymentProcessor creditCard = new CreditCardAdapter();

        paypal.processPayment(500.00);
        creditCard.processPayment(1200.00);
    }
}
