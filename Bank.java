import java.util.ArrayList;
import java.util.ArrayList;

public class Bank {
    ArrayList<Customer> customerArrayList = new ArrayList<Customer>();

    public void addCustomer(Customer customer) {
        customerArrayList.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customerArrayList.remove(customer);
    }

    public Customer getCustomer(int pin) {
        Customer customerFound = null;
        for (Customer customer : customerArrayList) {
            if (pin == customer.getPin()) {
                customerFound = customer;
            }
        }
        return customerFound;
    }

    public StringBuilder getAllCustomer() {
        StringBuilder CustomerStringBuilder = new StringBuilder();
        for (Customer customer : customerArrayList) {
            CustomerStringBuilder.append(customer.toString());
        }
        return CustomerStringBuilder;
    }


}
