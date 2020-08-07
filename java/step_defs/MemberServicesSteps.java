package bcbs.src.test.java.step_defs;

import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MemberServicesSteps {

    WebDriver driver;

    @Given("^the user is on the BCBS Homepage$")
    public void the_user_is_on_the_BCBS_Homepage() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.bcbs.com/");
//        driver.navigate().refresh();
        driver.get("https://www.bcbs.com/");
        driver.navigate().refresh();


    }

    @When("^user navigates to \"([^\"]*)\"$")
    public void user_navigates_to(String mbrServices) throws Throwable {
        Actions actions = new Actions(driver);
        WebElement memberServices = driver.findElement(By.xpath("//*[@id=\"block-bcbs-main-menu\"]/ul/li[1]/a"));
        actions.moveToElement(memberServices).perform();

        WebElement blue365 = driver.findElement(By.linkText("Visit Blue365"));
        Assert.assertTrue(blue365.isDisplayed());

    }

    @When("^clicks on \"([^\"]*)\"$")
    public void clicks_on(String arg1) throws Throwable {
        WebElement blue365 = driver.findElement(By.linkText("Visit Blue365"));
        blue365.click();
    }

    @Then("^user should be able to switch to the new window$")
    public void user_should_be_able_to_switch_to_the_new_window() throws Throwable {
        Set<String> allWindowsHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowsHandles){
            if(!windowHandle.equals(driver.getWindowHandle())){
                driver.switchTo().window(windowHandle);
            }
        }
    }

    @Then("^user should see \"([^\"]*)\" message$")
    public void user_should_see_message(String message) throws Throwable {
        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[text()='Welcome Blue Cross Blue Shield members']"));
        Assert.assertTrue("Welcome Blue Cross Blue Shield members should be displayed",welcomeMessage.isDisplayed());

        driver.close();
        driver.quit();
    }


}
