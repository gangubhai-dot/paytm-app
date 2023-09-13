import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<String, Double> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public synchronized void deposit(String accountNumber, double amount) {
        if (amount > 0) {
            double balance = accounts.getOrDefault(accountNumber, 0.0);
            accounts.put(accountNumber, balance + amount);
            System.out.println("Deposited " + amount + " into account " + accountNumber);
        }
    }

    public synchronized boolean withdraw(String accountNumber, double amount) {
        if (amount > 0) {
            double balance = accounts.getOrDefault(accountNumber, 0.0);
            if (balance >= amount) {
                accounts.put(accountNumber, balance - amount);
                System.out.println("Withdrawn " + amount + " from account " + accountNumber);
                return true;
            } else {
                System.out.println("Insufficient balance in account " + accountNumber);
            }
        }
        return false;
    }

    public synchronized double checkBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, 0.0);
    }
}

public class MoneyTransferApp {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Initialize accounts with some initial balance
        bank.deposit("Account1", 1000);
        bank.deposit("Account2", 1500);

        // Simulate money transfer
        if (bank.withdraw("Account1", 500)) {
            bank.deposit("Account2", 500);
        }

        // Check balances
        System.out.println("Account1 balance: " + bank.checkBalance("Account1"));
        System.out.println("Account2 balance: " + bank.checkBalance("Account2"));
    }
}

