package library;

import java.sql.*;

public class DbConnection {
    Connection con;
    ResultSet rows;
    Statement st;
    int val;

    public DbConnection() {
        // register the driver class
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //create the connection object
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/batchb?characterEncoding=utf8", "root", "password");
            if (con != null) {
                System.out.println("Database is connected successfully");
            }
            //creating statement object
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int insert(String query) {
        //execute query
        try {
            val = st.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return val;

    }

    public ResultSet select(String query) {
        try {
            rows = st.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    public static void main(String[] args) {
        new DbConnection();
    }
}