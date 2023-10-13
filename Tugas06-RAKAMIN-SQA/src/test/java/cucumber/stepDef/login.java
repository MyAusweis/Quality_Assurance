package cucumber.stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


//Using TDD
public class login {
    WebDriver driver;

    String baseurl = "http://www.saucedemo.com";

    String actual_username = "standard_user";

    String display_awal = "user-name";

    String after_success_login = "shopping_cart_container";

    String warning_kredensial= "Epic sadface: Username and password do not match any user in this service";
    String warning_empty_password = "Epic sadface: Password is required";
    String warning_empty_username = "Epic sadface: Username is required";

    String warning_user_locked = "Epic sadface: Sorry, this user has been locked out.";

    String Unable_Error_user = "User must not be granted for access";


    @Given("Halaman login sourcedemo")
    public void halaman_login_sourcedemo()
    {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        String loginPageAssert = driver.findElement(By.id("user-name")).getAttribute("id");
        Assert.assertEquals(loginPageAssert,display_awal);
    }

    @And("Click login button")
    public void click_login_button()
    {
        driver.findElement(By.id("login-button")).click();
    }

    @When("I input (.*) as username$")
    public void user_input_tdd_selenium_as_username(String username)
    {
        driver.findElement(By.id("user-name")).sendKeys(username);
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
            String elementID = driver.findElement(By.id(after_success_login)).getAttribute("id");

            //System.out.println(elementID);
            Assert.assertEquals(elementID,after_success_login);

        }

        if (status.equals("fail"))
        {
            String errorLogin =  driver.findElement(By.className("error-message-container")).getText();
            Assert.assertEquals(errorLogin,warning_kredensial);
        }


        if (status.equals("empty_password"))
        {
            String errorLogin =  driver.findElement(By.className("error-message-container")).getText();
            Assert.assertEquals(errorLogin,warning_empty_password);
        }

        if (status.equals("empty_username"))
        {
            String errorLogin =  driver.findElement(By.className("error-message-container")).getText();
            Assert.assertEquals(errorLogin,warning_empty_username);
        }

        if (status.equals("username_locked"))
        {
            String errorLogin =  driver.findElement(By.className("error-message-container")).getText();
            Assert.assertEquals(errorLogin,warning_user_locked);
        }

        if (status.equals("unable_error_user")) {
            String elementID = driver.findElement(By.id(after_success_login)).getAttribute("id");

            Assert.assertNotEquals(elementID,display_awal);
        }

      driver.close();

    }

    }


