package by.gsu.seawar.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DB Driver is load");
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/seawar?"
                            + "user=daa&password=123456789");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        }

            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/seawar?"
                            + "user=daa&password=123456789");
       
    }

    public DBConnection() throws SQLException {
        super();
        // Statements allow to issue SQL queries to the database
        statement = connection.createStatement();
        // Result set get the result of the SQL query
        resultSet = statement
                .executeQuery("select * from feedback.comments");
    }

    public static void main(String[] args) throws SQLException {
        Connection db = DBConnection.getConnection();
        
        // Statements allow to issue SQL queries to the database
        statement = db.createStatement();
        // Result set get the result of the SQL query
        resultSet = statement
                .executeQuery("select * from sw_ship_position");
        System.out.println("start");
        while(resultSet.next()){
            System.out.println(resultSet.getString("x"));
            
        }
        System.out.println("end");
        

    }

}
