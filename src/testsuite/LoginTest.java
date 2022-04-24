package testsuite;

import browserfactory.Basetest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends Basetest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        //username element
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys("standard_user");

        //Password element
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("secret_sauce");

        //Login element
        WebElement LoginField = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginField.click();

        //actual result
        WebElement actualresult = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualmsg = actualresult.getText();
        System.out.println(actualmsg);

        //expectedresult
        String expectedmsg = "PRODUCTS";

        //match actual and expected result
        Assert.assertEquals(actualmsg, expectedmsg);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //username element
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys("standard_user");

        //Password element
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("secret_sauce");

        //Login element
        WebElement LoginField = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginField.click();

        // actualmsg
        List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
        int Size = productNo.size();
        System.out.println(Size);

        //expectedmsg
        int expecedmsg = 6;

        //match actual and expectemsg
        Assert.assertEquals("procuct number not match", expecedmsg, Size);

    }

    @After
    //Here After method for close the browser
    public void teardown() {
        closebrowser();

    }
}