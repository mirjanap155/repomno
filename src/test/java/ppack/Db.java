package ppack;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    @Test
    public void testName() {
    }

    public static void main(String[] args) throws SQLException {
        //Connect to Db
        Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432","mirjanapetrovic","");
        if(!connection.isClosed()){
            System.out.println("We have successfully connected to database");

        }
    }
}
