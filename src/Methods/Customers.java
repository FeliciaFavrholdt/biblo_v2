package Methods;

import DB.Facade;
import Entity.Book;
import Entity.Customer;
import MyUtil.UserInput;
import java.sql.SQLException;
import java.util.List;

public class Customers {

    public void showCustomers(List<Customer> customerList) {
        for (Customer c : customerList) {
            System.out.println(c.toString());
        }
    }

    public void deleteCustomer() {
        Facade.deleteCustomer(UserInput.getInt("Enter customer ID"));
    }

    public void updateCustomer(List<Customer> customersList) throws SQLException {
        for (Customer c : customersList) {
            Facade.updateCustomers(c, c.getCustomerID());
        }
    }

    public void addCustomer() throws SQLException {
        Customer c = new Customer(
                UserInput.getString("Insert Name"),
                UserInput.getInt("Insert Postal Code"),
                UserInput.getString("Insert Address"));
        System.out.println("You have now added the customer \n" + Facade.addCustomer(c).toString());
    }
}
