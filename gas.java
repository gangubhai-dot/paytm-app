import java.util.Scanner;

class GasBill {
    private String accountNumber;
    private double amount;

    public GasBill(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}

class PaymentGateway {
    public boolean processPayment(String accountNumber, double amount) {
        // Simulate payment processing logic
        // In a real application, you would integrate with a payment gateway here
        return Math.random() < 0.95; // 95% success rate for simulation
    }
}

public class GasBillPaymentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentGateway paymentGateway = new PaymentGateway();

        System.out.print("Enter your gas account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter the gas bill amount: ");
        double billAmount = scanner.nextDouble();

        GasBill bill = new GasBill(accountNumber, billAmount);

        // Attempt to process the payment
        boolean paymentSuccess = paymentGateway.processPayment(bill.getAccountNumber(), bill.getAmount());

        if (paymentSuccess) {
            System.out.println("Payment successful! Thank you for your payment.");
        } else {
            System.out.println("Payment failed. Please try again later.");
        }
    }
}

