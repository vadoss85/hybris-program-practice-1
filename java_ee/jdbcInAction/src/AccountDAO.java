import java.sql.*;

public class AccountDAO {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "admin", "_PASSword1_");
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("select * from account")) {
            System.out.println(connection);
//            Statement statement = connection.createStatement();
//            int result = statement.executeUpdate("insert into account values(1, 'asddasd', 'zxczxc', 10000)");
//            System.out.println(result + " rows inserted");
//            int result = statement.executeUpdate("update account set bal=5000 where accno=1");
//            System.out.println(result + " rows updated");
//            int result = statement.executeUpdate("delete from account where accno=1");
//            System.out.println(result + " rows deleted");
//            ResultSet result = statement.executeQuery("select * from account");

            while (result.next()) {
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getInt(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
