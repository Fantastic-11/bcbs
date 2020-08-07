package step_defs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CareersOptionSteps {
    WebDriver driver;

//    @Before
//    public void setUp() {
//
//    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Given("^user is on home page of Blue Cross Blue Shield$")
    public void user_is_on_home_page_of_Blue_Cross_Blue_Shield() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.bcbs.com");

    }
    @And("^verify there is Careers option on the page$")
    public void verifyThereIsCareersOptionOnThePage() {
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Careers']")).isDisplayed());
    }
    @When("^user clicks on Careers link$")
    public void userClicksOnCareersLink() {
        driver.findElement(By.xpath("//a[text()='Careers']")).click();
    }



    @Then("^user should see \"([^\"]*)\" message$")
    public void user_should_see_message(String expectedMessage) throws Throwable {
        Assert.assertEquals(expectedMessage, driver.findElement(By.xpath("//h2[text()='Your Journey Starts Here']")).getText());
    }



}
