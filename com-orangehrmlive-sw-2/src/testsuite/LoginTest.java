package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }
    @Test
    public void login(){
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();

        String actualDashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
        String expectingDashboard = "Dashboard";
        Assert.assertEquals("‘Dashboard’",expectingDashboard,actualDashboard);
    }
    @After
    public void closeBrowser(){
      //  driver.quit();
    }


}
