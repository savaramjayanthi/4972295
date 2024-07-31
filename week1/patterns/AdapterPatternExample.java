
public class AdapterPatternExample {

    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());

        paypalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);
    }
}


interface PaymentProcessor {
    void processPayment(double amount);
}


class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

class StripeGateway {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypalGateway;

    public PayPalAdapter(PayPalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    public void processPayment(double amount) {
        paypalGateway.makePayment(amount);
    }
}
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

  
    public void processPayment(double amount) {
        stripeGateway.sendPayment(amount);
    }
}
