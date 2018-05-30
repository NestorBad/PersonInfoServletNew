package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    public static Connection getDbConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/personinfo";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
             e.printStackTrace();
        } catch (ClassNotFoundException e) {
             e.printStackTrace();
        }

        return connection;
    }
}
