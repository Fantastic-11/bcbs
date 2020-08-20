package utilities;

import org.openqa.selenium.WebDriver;

public class Driver {
    private Driver() {//will not allow to create a driver object directly
    }

    private static WebDriver driver;

    //1st method --> for creating a driver depending on the browser specified in config.properties

    public static WebDriver getDriver() {
        if (driver == null) {

            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                case "firefox":
                    driver= FirefoxWebDriver.loadFirefoxDriver(Boolean.parseBoolean(ConfigReader.getProperty("headless")));
                    break;
//                case "safari":
//                    driver = new SafariDriver();
//                    break;
                case "chrome":
                default:

                    driver = ChromeWebDriver.loadChromeDriver(Boolean.parseBoolean(ConfigReader.getProperty("headless")));
                    break;
            }

        }
        return driver;
    }


    //2nd method --> will close the driver if it is running
    public static void closeDriver() {
        if (driver == null) return;
        try {
            driver.close();
            driver.quit();
            driver = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
