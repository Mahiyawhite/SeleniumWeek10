package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }

    @Test
    public void register(){
        driver.findElement(By.className("ico-register")).click();

        driver.findElement(By.id("gender-male")).click();

        driver.findElement(By.id("FirstName")).sendKeys("Diya");

        driver.findElement(By.id("LastName")).sendKeys("Oza");

        driver.findElement(By.name("DateOfBirthDay")).sendKeys("2");

        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("February");

        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1990");

        driver.findElement(By.id("Email")).sendKeys("diya.oza@gmail.com");

        driver.findElement(By.name("Password")).sendKeys("Diya123");

        driver.findElement(By.id("ConfirmPassword")).sendKeys("Diya123");

        driver.findElement(By.id("register-button")).click();

        String actualRegText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        String expectedRegText = "Your registration completed";
        Assert.assertEquals("Your registration completed",expectedRegText,actualRegText);
    }
    @After
    public void tearDown(){
        //    closeBrowser();
    }
}
