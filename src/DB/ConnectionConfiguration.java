package DB;

import MyUtil.UserInput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfiguration {

    private static String pass = null;

    // Method to create a connection to the SQL workbench
    public static Connection getConnection() {

        if (pass == null) {
            pass = UserInput.getString("Angiv password");
        }

        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/biblo?serverTimezone=CET&useSSL=false";
        String user = "root";
        String password = pass;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to close a connection to the SQL workbench
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}