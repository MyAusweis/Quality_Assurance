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

public class login {
    WebDriver driver;
    String baseurl = "https://kasirdemo.belajarqa.com/";

    @Given("Halaman login kasir aja")
    public void halaman_login_kasir_aja()
    {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        driver.get(baseurl);
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");
    }

    @When("empty username")
    public void empty_username() {
        driver.findElement(By.id("email")).sendKeys("");
    }

    @When("Input username")
    public void input_username() {
        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");
    }

    @When("Input invalid username")
    public void input_invalid_username() {
        driver.findElement(By.id("email")).sendKeys("testing@gmail.com");
    }

    @And("Input Password")
    public void input_password() {
        driver.findElement(By.id("password")).sendKeys("tdd-selenium");
    }

    @And("Input invalid Password")
    public void input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("12345678");
    }

    @And("Click login button")
    public void click_login_button()
    {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user is on dashboard page")
    public void user_is_on_dashboard_page()
    {
        driver.findElement (By.xpath ("//*[contains(text(),'dashboard')]"));
        String username = driver.findElement (By.xpath ("//*[contains(string(),'hai')]/preceding-sibling::dt")).getText();
        System.out.println(username);

        Assert.assertEquals(username,"tdd-selenium");
        driver.close();
    }

    @Then("user get error message")
    public void user_get_error_message()
    {
        String errorLogin =  driver.findElement(By.xpath("//*[@role='alert']")).getText();
        Assert.assertEquals(errorLogin,"Kredensial yang Anda berikan salah");
        System.out.println(errorLogin);
        driver.close();
    }

    }


