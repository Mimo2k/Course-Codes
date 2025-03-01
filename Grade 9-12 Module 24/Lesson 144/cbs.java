import java.util.ArrayList;
import java.util.List;
class Bank {
    private String bankName;
    private List<Account> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully for " + account.getAccountHolderName());
    }

    public Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }
    
    public void bankDetails() {
        System.out.println("Welcome to " + bankName + "!");
        System.out.println("Total Accounts: " + accounts.size());
    }
}

class Account {
    private static int accountCounter = 1001;
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountHolderName, double initialDeposit) {
        this.accountNumber = accountCounter++;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void transfer(Account targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            targetAccount.balance += amount;
            System.out.println("Transferred: $" + amount + " to " + targetAccount.getAccountHolderName());
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void accountSummary() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }
}

public class cbs {
    public static void main(String[] args) {
        Bank myBank = new Bank("Global Trust Bank");

        Account account1 = new Account("Alice", 1000);
        Account account2 = new Account("Bob", 500);

        myBank.addAccount(account1);
        myBank.addAccount(account2);

        myBank.bankDetails();
        
        // Perform transactions
        account1.deposit(500);
        account1.withdraw(200);
        
        account2.deposit(300);
        account1.transfer(account2, 100);
        
        // Display account summaries
        account1.accountSummary();
        account2.accountSummary();
    }
}
