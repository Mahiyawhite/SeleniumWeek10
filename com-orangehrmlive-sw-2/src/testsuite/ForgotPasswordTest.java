package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }
    @Test
    public void forgotPassword(){
        WebElement forgotPassword = driver.findElement(By.xpath("//div[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]"));
        forgotPassword.click();

        String actualResult = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")).getText();
        String expectedResult = "Reset Password";
        Assert.assertEquals("Reset Password",expectedResult,actualResult);

    }
    @After
    public void closeBrowser(){
        //  driver.quit();
    }

}
