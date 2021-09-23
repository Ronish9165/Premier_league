package library;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.*;

public class DbConnectionTest {

    //Test1: pass
    @org.junit.Test
    public void insert() {
        String fulname = "Test";
        String lastname = "Test";
        String username = "ronish07";
        String pass = "123";
        String cpass = "12345";
        String gender = "Male";
        DbConnection db = new DbConnection();
        String query = "insert into usr_tbl(fullname,lastname,username,pass,cpass,gender) " +
                "values('" + fulname + "','" + lastname + "','" + username + "','" + pass + "','" + cpass + "','" + gender + "')";
        int row = db.insert(query);
        assertEquals(1, row);
    }


    //Test2: Pass
    @org.junit.Test
    public void select() throws SQLException {
        String result;
        String pass = "Ronish07";
        DbConnection db = new DbConnection();
        String query = "Select pass from usr_tbl where pass='Ronish07'";
        ResultSet rs = db.select(query);
        while (rs.next()) {
            result = rs.getString("pass");
            assertEquals(pass, result);
        }
    }


    //Test3: Fail
    @org.junit.Test
    public void update() {
        DbConnection db = new DbConnection();
        String query = "Update usr_tbl SET fullname = 'ronish' where username = 'ronish07'";
        int row = db.Update(query);
        assertEquals(1, row);
    }

    //Test4: Fail
    @org.junit.Test
    public void test_delete() {
        DbConnection db = new DbConnection();
        String query = "Delete from usr_tbl where fullname = 'a'";
        int row = db.delete(query);
        assertEquals(1, row);
    }

    //Test5: Fail
    @org.junit.Test
    public void test_login() throws SQLException {
        String username;
        String pass;
        String username1 = "ronish07";
        String password = "123456";
        DbConnection db = new DbConnection();
        String query = "Select username,pass from usr_tbl where username='ronish07' and pass = '123'";
        ResultSet rs = db.select(query);
        while (rs.next()) {
            username = rs.getString("username");
            pass = rs.getString("pass");
            assertEquals(username1, username);
            assertEquals(password, pass);
        }
    }
}