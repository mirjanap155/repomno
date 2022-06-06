package database;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class Dbbb {

    public static void main(String[] args) throws SQLException {
        //Connect to Db
        Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","mirjanapetrovic","");
        /*if(!connection.isClosed()){
            System.out.println("We have successfully connected to database");

        }*/
        //Get the data from table
        Statement statement=connection.createStatement();
        //ResultSet resultSet = statement.executeQuery("SELECT * FROM COMPANY where id=3;");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM logincredentials;");

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");

        while (resultSet.next()){
            /*System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getInt("age"));
            System.out.println(resultSet.getString("address"));
            System.out.println(resultSet.getInt("salary"));*/

            driver.findElement(By.id("input-email")).sendKeys(resultSet.getString("username"));
            driver.findElement(By.id("input-password")).sendKeys(resultSet.getString("password"));
        }
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    }
}