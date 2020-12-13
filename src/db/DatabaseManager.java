package db;

import java.sql.*;

public class DatabaseManager {

//    String url = "localhost:3306";
    String url = "jdbc:oracle:thin:@localhost:1521";
    String database = "parkingadminsystem";
    String id = "ADMIN";
    String pq = "alpha190315";
    String sql = "select * from t_car";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private static DatabaseManager connector = null;

    public static DatabaseManager getInstance() {
        if (connector == null) {
            connector = new DatabaseManager();
        }
        return connector;
    }

    public Connection open() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(url, id, pq);
        return connection;
    }

    public void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
