package com.revature.selenium.steps;

import com.revature.selenium.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private static WebDriver driver;
    WebDriverWait wait;
    @Given("User is on Login Page")
    public void user_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get("http://localhost:7000/webpage/login");
    }
    @When("User enters UserName and Password")
    public void user_enters_user_name_and_password() {
        // Write code here that turns the phrase above into concrete actions
        WebElement userName= driver.findElement(By.id("usernameInput"));
        WebElement password=driver.findElement(By.id("passwordInput"));;
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='loginForm']/input[3]"));
        userName.sendKeys("test123");
        password.sendKeys("test123");
        loginBtn.click();
    }
    @Then("Then User should see the logout button")
    public void then_user_should_see_the_logout_button() {
        // Write code here that turns the phrase above into concrete actions
       // WebElement logoutBtn= driver.findElement(By.xpath("//*[@id='logoutButton']"));
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='logoutButton']"))));
        WebElement greeting=driver.findElement(By.id("greeting"));
        String greetingText=greeting.getText();
        String expectedGreeting="Welcome to the Home Page";
        Assertions.assertEquals(expectedGreeting,greetingText.substring(0,24));
    }
}
