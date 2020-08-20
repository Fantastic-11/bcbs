package step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.concurrent.TimeUnit;
public class IndividualAndFamily_Steps {
    WebDriver driver = Driver.getDriver();
    @Given("^the user is on Blue Cross Blue Shield website$")
    public void the_user_is_on_Blue_Cross_Blue_Shield_website() throws Throwable {
        Driver.getDriver().navigate().to(ConfigReader.getProperty("baseUrl"));
    }
    @When("^user hovers over on Individuals & families$")
    public void user_hovers_over_on_Individuals_families() throws Throwable {
        Actions actions = new Actions(driver);
        WebElement individualsAndFamilies = driver.findElement(By.linkText("Individuals & Families"));
        actions.moveToElement(individualsAndFamilies).perform();
    }
    @Then("^user click on Help with Finding Insurance option$")
    public void user_click_on_Help_with_Finding_Insurance_option() throws Throwable {
        WebElement helpWithInsurance = driver.findElement(By.linkText("Help with Finding Insurance"));
        helpWithInsurance.click();
    }
    @Then("^verifies \"([^\"]*)\" message is displayed$")
    public void verifies_message_is_displayed(String expectedMessage) throws Throwable {
        WebElement msg = driver.findElement(By.xpath("//span[text()='Individuals & Families']"));
        Assert.assertEquals(expectedMessage, msg.getText());
        driver.close();
    }
    @Given("^the user is on \"([^\"]*)\" page$")
    public void the_user_is_on_page(String expectedURL) throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.navigate().to("https://www.bcbs.com/individuals-families");
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }
    @When("^user clicks on \"([^\"]*)\" link$")
    public void user_clicks_on_link(String arg1) throws Throwable {
        WebElement bottonPage = driver.findElement(By.xpath("//p[contains(text(), 'All Rights Reserved.')]"));
        WebElement visitBlue325 = driver.findElement(By.xpath("(//a[text()='Visit Blue365'])[3]"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.moveToElement(bottonPage).perform();
        visitBlue325.click();
        driver.close();
    }
    @Then("^user verifies Welcome Blue Cross Blue Shield members message is displayed$")
    public void user_verifies_Welcome_Blue_Cross_Blue_Shield_members_message_is_displayed() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.navigate().to("https://www.blue365deals.com/");
        WebElement msg = driver.findElement(By.xpath("//h1[text()='Welcome Blue Cross Blue Shield members']"));
        Assert.assertTrue(msg.isDisplayed());
    }
}