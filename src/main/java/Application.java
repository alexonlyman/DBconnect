import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "223322";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1, 1);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String first_name = "name " + resultSet.getString("first_name");
                String last_name = "surname " + resultSet.getString("last_name");
                String age = "age " + resultSet.getInt(6);
                String city = "city " + resultSet.getString("city_id");
                System.out.println(first_name);
                System.out.println(last_name);
                System.out.println(age);
                System.out.println(city);
            }

        }

    }

}
