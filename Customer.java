import java.util.ArrayList;

public class Customer {
    private String first;
    private String last;
    private int pin;
    private ArrayList<Account> customerAccounts = new ArrayList<Account>();

    public Customer(String first, String last, int pin) {
        this.first = first;
        this.last = last;
        this.pin = pin;
    }

    public void addAccount(Account account) {
        customerAccounts.add(account);
    }

    public void removeAccount(Account account) {
        customerAccounts.remove(account);
    }

    public Account getAccount(int number) {
        Account accountFound = null;
        for (Account account : customerAccounts) {
            if(number == account.getAccountNumber()) {
                accountFound = account;
            }
        }
        return accountFound;
    }

    public StringBuilder getAllAccount() {
        StringBuilder accountStringBuilder = new StringBuilder();
        for (Account account : customerAccounts) {
            accountStringBuilder.append(account.toString() + "\n");
        }
        return accountStringBuilder;
    }

    public int getPin() {
        return pin;
    }

    @Override
    public String toString() {
        return String.format("First: %s\nLast: %s\nPIN: %d", first, last, pin);
    }


}
