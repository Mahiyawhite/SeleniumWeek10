package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://the-internet.herokuapp.com/login";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }
    @Test

    public void login(){
    /* User Should Login Successfully With Valid Credentials */

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        String actualSecureAreaText = driver.findElement(By.xpath("//div[@id='content']/div/h2")).getText();
        String expectingSecureText = "Secure Area";
        Assert.assertEquals("Validating Secure Area",expectingSecureText,actualSecureAreaText);

        /* User Should not Login Successfully With InValid Username */

        driver.findElement(By.name("username")).sendKeys("tomsmith1");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        String actualErrorMsg = driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText();
        System.out.println(actualErrorMsg);
        String expectedErrorMsg = "Your username is invalid!\n" + "×";
        Assert.assertEquals("Your username is invalid!",expectedErrorMsg,actualErrorMsg);

        /* User Should not Login Successfully With InValid Password */

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        String actualErrorMsg2 = driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText();
        System.out.println(actualErrorMsg2);
        String expectedErrorMsg2 = "Your password is invalid!\n" + "×";
        Assert.assertEquals("Your password is invalid!",expectedErrorMsg2,actualErrorMsg2);






    }
    @After
    public void closeBrowser(){
       // driver.quit();
    }

}
