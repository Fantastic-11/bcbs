package step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ShopForInsuranceSteps {

    WebDriver driver;
    WebElement shopForInsuranceButton;

    @Given("^the user is on the home page$")
    public void the_user_is_on_the_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.navigate().to("https://www.bcbs.com/");
    }

    @Given("^the Shop for Insurance button is displayed$")
    public void the_shop_for_insurance_button_is_displayed(String arg1) {
        shopForInsuranceButton = driver.findElement(By.cssSelector("button[aria-label='Open the Shop for Insurance form']"));
        Assert.assertTrue(shopForInsuranceButton.isDisplayed());
    }

    @When("^the user clicks the Shop for Insurance button$")
    public void the_user_clicks_the_shop_for_insurance_button(String arg1) {
        shopForInsuranceButton.click();
    }

    @Then("^the message \"([^\"]*)\" is displayed$")
    public void the_message_is_displayed(String expectedMessage) {
        WebElement message = driver.findElement(By.xpath("//*[starts-with(text(),'Find the health insurance option')]"));
        String actualMessage = message.getText();
        Assert.assertEquals("Wrong message is displayed.", expectedMessage, actualMessage);
        driver.close();
        driver.quit();
    }
}
