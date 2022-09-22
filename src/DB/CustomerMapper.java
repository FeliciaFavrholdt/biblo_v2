package DB;

import DB.ConnectionConfiguration;
import Entity.Customer;
import MyUtil.UserInput;

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
                //System.out.println(customer.toString());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ConnectionConfiguration.closeConnection(con);
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
            ConnectionConfiguration.closeConnection(con);
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
            ConnectionConfiguration.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "A customer with the id " + "\"" + customerID + "\"" + " was not found";
    }

    public static String updateCustomer(Customer c) throws SQLException {
        String sql = "update Customers set CustomerName = ?, PostalCode = ?, Address = ? where CustomerID = ?";

        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            try {
                ps.setInt(4, UserInput.getInt("Which customer ID should be updated?"));
                ps.setString(1, c.setCustomerName(UserInput.getString("Update Name")));
                ps.setInt(2, c.setPostalCode(UserInput.getInt("Update postal code")));
                ps.setString(3, c.setAddress(UserInput.getString("Update Address")));
                int result = ps.executeUpdate();

                if (result > 0) {
                    System.out.println("The customer data has now been updated");
                }
                ConnectionConfiguration.closeConnection(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "A book with this ID does not exist.";
    }
}

