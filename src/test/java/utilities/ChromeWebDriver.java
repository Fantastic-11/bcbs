package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ChromeWebDriver {
    public static WebDriver loadChromeDriver(boolean headless){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");//this is same as window().maximize()
        options.addArguments("--window-size=1920,1080");



//  this code will disable the cookies
        DesiredCapabilities caps = new DesiredCapabilities();

        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> contentSettings = new HashMap<String, Object>();

        contentSettings.put("cookies", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        caps.setCapability(ChromeOptions.CAPABILITY, options);

    //    driver = new ChromeDriver(caps);









        //options.setHeadless(headless);  ---> also we can use this way instead of having a if statement

        if(headless){
            options.setHeadless(true);
            //options.addArguments("--headless");  --> this is second way of doing previous line
            //works same
        }
        WebDriver driver= new ChromeDriver(caps);//ChromeDriver() constructor is overloaded, and we can pass it inside it
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);//also we can add pageLoadTimeOut here (optional)
        return driver;
    }
}
