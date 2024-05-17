package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }
    @Test
    public void login(){
        driver.findElement(By.className("ico-login")).click();

        String actualWelcomeText = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText();
        String expectingWelcomeText = "Welcome, Please Sign In!";
        Assert.assertEquals("Validating welcome text",expectingWelcomeText,actualWelcomeText);

        /*for valid credentials*/
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.className("email")).sendKeys("madhuri_oza@yahoo.com");
        driver.findElement(By.id("Password")).sendKeys("Madhuri123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();

        /*for invalid credentials*/
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("kity_oza@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Kity@oza1");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String actualerrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        String expectederrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        Assert.assertEquals(expectederrorMessage,actualerrorMessage);
    }

    @After
    public void tearDown(){
    //    closeBrowser();
    }
}
