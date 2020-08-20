package step_defs;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ConfigReader;
import utilities.Driver;



public class CareersSteps {


    @Given("^user is on home page of Blue Cross Blue Shield$")
    public void user_is_on_home_page_of_Blue_Cross_Blue_Shield() throws Throwable {
        Driver.getDriver().navigate().to(ConfigReader.getProperty("baseUrl"));
    }

    @Given("^verify there is Careers option on the page$")
    public void verify_there_is_Careers_option_on_the_page() throws Throwable {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='Careers']")).isDisplayed());
    }

    @When("^user clicks on Careers link$")
    public void user_clicks_on_Careers_link() throws Throwable {

        Driver.getDriver().findElement(By.linkText("Careers")).click();

    }

    @Then("^user should see \"([^\"]*)\" message$")
    public void user_should_see_message(String expectedMessage) throws Throwable {
        Thread.sleep(3000);
        WebElement message = Driver.getDriver().findElement(By.xpath("//h2[text()='Your Journey Starts Here']"));
        Assert.assertEquals(expectedMessage, message.getText());
    }

    @Then("^user should be in careers page$")
    public void user_should_be_in_careers_page() throws Throwable {
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().getCurrentUrl();
    }

    @Then("^user clicks on Choose State option$")
    public void user_clicks_on_Choose_State_option() throws Throwable {
        Driver.getDriver().findElement(By.xpath("//span[text()='Choose State']")).click();
    }

    @Then("^user should see a drop down menu with list of states$")
    public void user_should_see_a_drop_down_menu_with_list_of_states() throws Throwable {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[text()='Choose State']")).isDisplayed());


        Thread.sleep(3000);
        //WebElement dropDownChooseState = driver.findElement(By.xpath("//select[@class='form-select']"));
        // Assert.assertTrue(dropDownChooseState.isDisplayed());
    }

    @When("^user picks \"([^\"]*)\" and clicks on Go button$")
    public void user_picks_and_clicks_on_Go_button(String expectedIllinois) throws Throwable {

        Driver.getDriver().findElement(By.xpath("//span[text()='Choose State']")).click();
        WebElement dropDownOption = Driver.getDriver().findElement(By.xpath("//select[@class='form-select']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveByOffset(0, 100).perform();
        WebElement illinois = Driver.getDriver().findElement(By.xpath("//li[text()='Illinois']"));
        illinois.click();


        Driver.getDriver().findElement(By.xpath("//span[text()='Go']")).click();
Thread.sleep(2000);
    }

    @Then("^user should get \"([^\"]*)\"$")
    public void userShouldGet(String expectedMessage) throws Throwable {
        Assert.assertTrue(Driver.getDriver().findElement(By.id("plan-finder-state-careers-results")).isDisplayed());
    }

    @And("^user should see \"([^\"]*)\" link$")
    public void userShouldSeeLink(String expectedLinkText) throws Throwable {
        WebElement bcbsLink = Driver.getDriver().findElement(By.xpath("//a[text()='Blue Cross and Blue Shield of Illinois']"));

        Assert.assertTrue(bcbsLink.isDisplayed());
    }
}
