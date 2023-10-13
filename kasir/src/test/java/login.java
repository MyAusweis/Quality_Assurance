import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class login {
    @Test
    public void openbrowser()
    {
        WebDriver driver;
        String baseurl = "https://kasirdemo.belajarqa.com/";
        WebDriverManager.chromedriver().setup();

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);
        String title = driver.getTitle();
        Assert.assertEquals(title,"kasirAja");

        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");
        driver.findElement(By.id("password")).sendKeys("tdd-selenium");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        System.out.println(title);
        driver.findElement (By.xpath ("//*[contains(text(),'kasirAja')]"));

        driver.quit();


    }
}