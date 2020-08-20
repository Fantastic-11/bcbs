package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class FirefoxWebDriver {
    public static WebDriver loadFirefoxDriver(boolean headless){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(headless);

        WebDriver driver= new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);//firefox is little bit slower than chrome
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);//this line is optional
        driver.manage().window().maximize();
        return driver;
    }
}
