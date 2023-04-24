package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/QLSVCNTT";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ArrayList<student> getstudents() {
        ArrayList<student> students = new ArrayList<>();
        String query = "SELECT * FROM SV_CNTT";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                student student = new student(
                        resultSet.getInt("MaSV"),
                        resultSet.getString("TenSV"),
                        resultSet.getDate("NamSinh"),
                        resultSet.getFloat("DienCTDL"),
                        resultSet.getFloat("DiemCSDL"),
                        resultSet.getFloat("DiemMMT")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void deletestudent(int maSV) {
        String query = "DELETE FROM SV_CNTT WHERE MaSV = " + maSV;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
