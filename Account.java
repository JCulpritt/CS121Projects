public class Account {
    private double balance;
    private int accountNumber;
    private static int numberOfAccounts = 1000;

    public Account(double balance) {
        this.balance = balance;
        this.accountNumber = numberOfAccounts++;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() { return balance; }
    public String Deposit(double amount) {
        String string = "Amount added: $" + amount + "\nNew Balance: $" + (amount + balance);
        balance = balance + amount;
        return string;
    }

    public String Withdraw(double amount) {
        if(amount > balance) {
            return "--Insufficent Funds--\nBalance: $" + balance;
        }
        else {
            balance = balance - amount;
            return "Withdrawn Amount: $" + amount + "\nNew Balance: $" + balance;
        }
    }

    @Override
    public String toString() {

        return String.format("Account Number: %d\nBalance: $%.2f\n", accountNumber, balance);
    }


}
