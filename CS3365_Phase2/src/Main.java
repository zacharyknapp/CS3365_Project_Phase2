import java.sql.*;

public class Main {
    static final String DB_URL = "jdbc:mysql://localhost:3306/cs3365";
    static final String USER = "root";
    static final String PASS = "password";
    static final String QUERY = "SELECT id, firstname FROM Users";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("First Name: " + rs.getString("firstname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}