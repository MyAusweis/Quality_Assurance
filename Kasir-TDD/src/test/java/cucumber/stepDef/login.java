package cucumber.stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


//Using TDD
public class login {
    WebDriver driver;
    String baseurl = "https://kasirdemo.belajarqa.com/";

    String actual_username = "tdd-selenium";
    String warning_empty_password = "\"password\" is not allowed to be empty";
    String warning_empty_username = "\"email\" is not allowed to be empty";
    String warning_kredensial= "Kredensial yang Anda berikan salah";

    String warning_invalid_username = "\"email\" must be valid";

    @Given("Halaman login kasir aja")
    public void halaman_login_kasir_aja()
    {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        driver.get(baseurl);
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");
    }

    @And("Click login button")
    public void click_login_button()
    {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("I input (.*) as email$")
    public void user_input_tdd_selenium_as_email(String email)
    {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("I input (.*) as password$")
    public void user_input_tdd_selenium_as_password(String password)
    {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("I verify (.*) login result$")
    public void user_verify_success_login_result(String status)
    {
        if (status.equals("success"))
        {
            driver.findElement (By.xpath ("//*[contains(text(),'dashboard')]"));
            String username = driver.findElement (By.xpath ("//*[contains(string(),'hai')]/preceding-sibling::dt")).getText();
            Assert.assertEquals(username,actual_username);

        }

        if (status.equals("fail"))
        {
            String errorLogin =  driver.findElement(By.xpath("//*[@role='alert']")).getText();
            Assert.assertEquals(errorLogin,warning_kredensial);
        }

        if (status.equals("empty_password"))
        {
            String errorLogin =  driver.findElement(By.xpath("//*[@role='alert']")).getText();
            Assert.assertEquals(errorLogin,warning_empty_password);
        }

        if (status.equals("empty_username"))
        {
            String errorLogin =  driver.findElement(By.xpath("//*[@role='alert']")).getText();
            Assert.assertEquals(errorLogin,warning_empty_username);
        }

        if (status.equals("invalid_username"))
        {
            String errorLogin =  driver.findElement(By.xpath("//*[@role='alert']")).getText();
            Assert.assertEquals(errorLogin,warning_invalid_username);
        }

        driver.close();

    }

    }


