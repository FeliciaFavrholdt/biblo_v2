package DB;

import Entity.Customer;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomerMapper {

    protected static Customer addCustomer(Customer customer) throws SQLException {

        String sql = "INSERT INTO Customers (CustomerName, PostalCode, Address) VALUES (?, ?, ?)";

        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            try {
                ps.setString(1, customer.getCustomerName());
                ps.setInt(2, customer.getPostalCode());
                ps.setString(3, customer.getAddress());
                ps.executeUpdate();

                ResultSet resultSet = ps.getGeneratedKeys();
                resultSet.next();

                int customerId = resultSet.getInt(1);
                customer.setCustomerID(customerId);
                System.out.println(customerId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return customer;
        }
    }

    protected static List<Customer> fetchCustomers() {

        List<Customer> customerList = new LinkedList<>();
        String sql = "select * from Customers";

        try (Connection con = ConnectionConfiguration.getConnection();

             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int customerID = resultSet.getInt("CustomerID");
                String customerName = resultSet.getString("CustomerName");
                int postalCode = resultSet.getInt("PostalCode");
                String address = resultSet.getString("Address");

                Customer customer = new Customer(customerID, customerName, postalCode, address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    protected static String deleteCustomer(int customerID) {
        String sql = "delete from Customers where CustomerID = ?";

        try (Connection con = ConnectionConfiguration.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, customerID);
            int res = ps.executeUpdate();
            if (res > 0) {
                return "Customer with ID " + "\"" + customerID + "\"" + " has now been deleted";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "A customer with the id " + "\"" + customerID + "\"" + " was not found";
    }
}
