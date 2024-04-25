import java.util.Scanner;

public class Menu {
    private Bank bank = new Bank();
    private Scanner scanner = new Scanner(System.in);
    public void displayMenu() {
        while (true) {
            String selection;
            System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
            System.out.print("Please make a selection:\n" +
                    "1) Access Account\n" +
                    "2) Open a New Account\n" +
                    "3) Close All Accounts\n" +
                    "4) Exit\n" +
                    ">> ");
            selection = scanner.nextLine();   // Get information from user
            // If-else-if  statements to
            if (selection.equals("1")) {
                accessAccount();
            } else if (selection.equals("2")) {
                openAccount();
            } else if (selection.equals("3")) {
                closeAll();
            } else if (selection.equals("4")) {
                System.out.println("Exiting...");
                break;
            }
            else {
                System.out.println("Invalid entry");
            }
        }
    }

    private void accessAccount() {
        System.out.println("Enter your PIN:");
        int pin = Integer.parseInt(scanner.nextLine());
        Customer user = bank.getCustomer(pin);
        if (user == null) {
            System.out.println("PIN is not valid\n");
            return;
        }
        else {
            System.out.print(user.getAllAccount() + "Enter Account Number:\n");
            int number = Integer.parseInt(scanner.nextLine());
            Account account = user.getAccount(number);
            if (account == null) {
                System.out.println("Account number invalid\n");
                return;
            }
            else {
                System.out.println("\nPlease Make  Selection:\n" +
                        "1: Make a deposit\n" +
                        "2: Make a withdrawl\n" +
                        "3: See account balance\n" +
                        "4: Close account\n" +
                        "5: Exit\n");
                String selection = scanner.nextLine();   // Get information from user
                // If-else-if  statements to
                if (selection.equals("1")) {
                    System.out.println("Enter the amount you would like to deposit:");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.Deposit(amount);
                } else if (selection.equals("2")) {
                    System.out.println("Enter the amount you would like to withdraw:");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.Withdraw(amount);
                } else if (selection.equals("3")) {
                    System.out.println(account.toString());
                } else if (selection.equals("4")) {
                    user.removeAccount(account);
                    System.out.println("Account Removed\n");
                } else if (selection.equals("5")) {
                    System.out.println("Exiting...");
                    return;
                }
                else {
                    System.out.println("Invalid entry");
                }
            }
        }
    }

    private void openAccount() {
        System.out.print("Are you a new customer?\n" +
                "1. Yes\n" +
                "2. No\n" +
                ">");
        int ans = Integer.parseInt(scanner.nextLine());
        Customer customer = null;
        if (ans == 1) {
            customer = createNewCustomer();
        }
        else if(ans == 2) {
            System.out.println("Enter PIN:");
            int pin = Integer.parseInt(scanner.nextLine());
            customer = bank.getCustomer(pin);
            if (customer == null) {
                System.out.println("Invalid PIN");
                return;
            }
        }
        else {
            System.out.println("Invalid Input");
            return;
        }
        System.out.println("What kind of account would you like?\n1. Savings\n2. Standard");
        int response = Integer.parseInt(scanner.nextLine());
        if (response == 1) {
            System.out.println("How much would you like to deposit for new saving account?");
            double amount = Double.parseDouble(scanner.nextLine());
            System.out.print("What interest rate suites you? (Enter in decimal form)\n>");
            double rate = Double.parseDouble(scanner.nextLine());
            SavingsAccount account = new SavingsAccount(amount, rate);
            customer.addAccount(account);
            System.out.printf("New Account Opened: %d\n", account.getAccountNumber());
        }
        else if (response == 2) {
            System.out.println("How much would you like to deposit for new account?");
            double amount = Double.parseDouble(scanner.nextLine());
            Account account = new Account(amount);
            customer.addAccount(account);
            System.out.printf("New Account Opened: %d\n", account.getAccountNumber());
        }
        else {
            System.out.println("Invalid Response: Standard Account Chosen\n\n");
            System.out.println("How much would you like to deposit for new account?");
            double amount = Double.parseDouble(scanner.nextLine());
            Account account = new Account(amount);
            customer.addAccount(account);
            System.out.printf("New Account Opened: %d\n", account.getAccountNumber());
        }
    }

    private Customer createNewCustomer() {
        System.out.println("Enter First Name:");
        String first = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String last = scanner.nextLine();
        System.out.println("Enter PIN:");
        int pin = Integer.parseInt(scanner.nextLine());
        Customer customer = new Customer(first, last, pin);
        bank.addCustomer(customer);
        return customer;
    }

    private void closeAll() {
        System.out.println("Enter PIN:");
        int pin = Integer.parseInt(scanner.nextLine());
        Customer customer = bank.getCustomer(pin);
        if (customer == null) {
            System.out.println("Invalid PIN\n");
            return;
        }
        bank.removeCustomer(customer);
        System.out.println("Customer has been removed from the bank.");
    }

}
