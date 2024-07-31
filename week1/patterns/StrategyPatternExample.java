
public class StrategyPatternExample {

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("John Doe", "1234-5678-9012-3456", "123", "12/25"));
        context.pay(100.0);

        context.setPaymentStrategy(new PayPalPayment("john.doe@example.com", "password123"));
        context.pay(200.0);
    }
}

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
        System.out.println("Card Details - Name: " + name + ", Card Number: " + cardNumber + ", CVV: " + cvv + ", Expiry Date: " + expiryDate);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
        System.out.println("PayPal Account - Email: " + email);
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("Payment strategy not set.");
        }
    }
}
