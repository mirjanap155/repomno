package objectreprository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    WebDriver driver;
    public MyAccountPage(WebDriver driver){
        this.driver=driver;

    }
   public By accountBreadCrumb=By.xpath("//ul[@class='breadcrumb']//li//a[contains(text(),'Account')]");
     public WebElement accountBreadCrumb() {
        return driver.findElement(accountBreadCrumb);
    }
}
