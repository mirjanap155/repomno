package ppack;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectreprository.LoginPage;
import objectreprository.MyAccountPage;
import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest   {
    WebDriver driver;
    @Test
    public void login(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.emailField().sendKeys("arun.selenium3@gmail.com");
        loginPage.passwordField().sendKeys("Second@123");
        loginPage.loginButton().click();

        MyAccountPage myAccountPage=new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.accountBreadCrumb().isDisplayed());
        //Thread.sleep(3000);
        //driver.close();
    }
    @After
    public void closure(){
        driver.close();

    }
}
