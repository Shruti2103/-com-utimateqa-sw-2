package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public void openbrowser(String baseurl){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver=new ChromeDriver();
         driver.get(baseurl);
         //maximise the screen
        driver.manage().window().maximize();
        //implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }
     public void closebrowser(){
        driver.quit();
     }




}
