package step_defs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    @Before
    public void setUp(){

    }
    @After
    public void tearDown(Scenario scenario){
        try{
            if(scenario.isFailed()){

                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot,"image/png");
            }
        }catch (Exception e){
            System.out.println("Exception happened while running tearDown: "+e.getMessage());
        }
        Driver.closeDriver();

    }

}
