package testconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/user_db";
        String username = "root";
        String password = "";

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Process the result set
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
                System.out.println("-----------------------------");
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error while connecting to the database!");
            e.printStackTrace();
        }
    }
}
