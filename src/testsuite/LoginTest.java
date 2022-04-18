package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "https://courses.ultimateqa.com/";

    // click on login link
    @Before
    public void setbrowser() {
        openbrowser(baseurl);
    }

    @After
    public void close() {
        closebrowser();
    }

    @Test
    public void navigateToLoginPageSuccessfully() {
        // click on sign in
        WebElement signin = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signin.click();
        // varify the text
        String expectedmsg = "Welcome Back!";
        WebElement actualmsg = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        actualmsg.getText();
        String actualmessage1 = actualmsg.getText();
        //Accsert with expected and actual result
        Assert.assertEquals("Welcome Back", expectedmsg, actualmessage1);


    }

    @Test
    public void verifyTheErrorMessage() {
        // click on sign in link
        WebElement signin = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signin.click();
        //Enter invalid username
        WebElement invalidusewrname = driver.findElement(By.id("user[email]"));
        invalidusewrname.sendKeys("abc@gmail.com");
        // Enter invalid password

        WebElement invalidpassword = driver.findElement(By.id("user[password]"));
        invalidpassword.sendKeys("abc12");
        // click on login button
        WebElement loginbutton = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        loginbutton.click();
        // verify error message
        String expectedmessage = "Invalid email or password.";
        WebElement actualmessage = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        actualmessage.getText();
        String actualmessage1 = actualmessage.getText();
        //Assert the actual and expected result
        Assert.assertEquals("Invalid pasword or email address ", expectedmessage, actualmessage1);

    }


}
