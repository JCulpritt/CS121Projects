public class SavingsAccount extends Account {
    private static double interestRate;
    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {

        return String.format("Account Number: %d\nBalance: $%.2f\nInterest Rate: %.2f%%\n", this.getAccountNumber(), this.getBalance(), interestRate * 100);
    }
}
