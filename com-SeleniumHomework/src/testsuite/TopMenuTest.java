package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }
    @Test
    public void NavigateSuccessfully(){
        driver.findElement(By.linkText("Computers")).click();
        String actualComText = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[1]/h1")).getText();
        String expectingComText = "Computers";
        Assert.assertEquals("Validating Computers",expectingComText,actualComText);

        driver.findElement(By.linkText("Electronics")).click();
        String actualElecText = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1")).getText();
        String expectingElecText = "Electronics";
        Assert.assertEquals("validating Electronics",expectingElecText,actualElecText);


        driver.findElement(By.linkText("Apparel")).click();
        String actualApparelText = driver.findElement(By.xpath("//h1[text()='Apparel']")).getText();
        String expectingApparelText = "Apparel";
        Assert.assertEquals("validating Apparel",expectingApparelText,actualApparelText);

        driver.findElement(By.linkText("Digital downloads")).click();
        String actualDigitalText = driver.findElement(By.xpath("//h1[text()='Digital downloads']")).getText();
        String expectingDigitalText = "Digital downloads";
        Assert.assertEquals("Digital downloads",expectingDigitalText,actualDigitalText);

        driver.findElement(By.linkText("Books")).click();
        String actualBooksText = driver.findElement(By.xpath("//h1[text()='Books']")).getText();
        String expectingBooksText = "Books";
        Assert.assertEquals("Books",expectingBooksText,actualBooksText);

        driver.findElement(By.linkText("Jewelry")).click();
        String actualJewelryText = driver.findElement(By.xpath("//h1[text()='Jewelry']")).getText();
        String expectingJewelryText = "Jewelry";
        Assert.assertEquals("Jewelry",expectingJewelryText,actualJewelryText);

        driver.findElement(By.linkText("Gift Cards")).click();
        String actualGiftCardsText = driver.findElement(By.xpath("//h1[text()='Gift Cards']")).getText();
        String expectingGiftCardsText = "Gift Cards";
        Assert.assertEquals("Gift +51Cards",expectingGiftCardsText,actualGiftCardsText);
    }

}
