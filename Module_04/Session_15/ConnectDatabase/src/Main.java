import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/practice-ss15?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối");
            e.printStackTrace();
        }
    }
}
