import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginDDT{
    @Test
    public void login_DDT()
        {

        WebDriver driver;
        String baseurl = "https://kasirdemo.belajarqa.com/";

        String csvDir = System.getProperty("user.dir")+"src/test/data/test-data.csv";
        //lalu pk try and error reading csv file
            
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);
        String title = driver.getTitle();
        Assert.assertEquals(title,"kasirAja");

        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");
        driver.findElement(By.id("password")).sendKeys("tdd-selenium");

    }
}
