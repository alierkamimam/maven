package TestNGExercises.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public Driver() {

    }

    public static WebDriver getDriver() {
        /*
         * We first check if a webdriver object exists,
         * if not, this method will create it.
         *
         */
        if (driverPool.get() == null) {
            /*
             * We specified the type of browser in the configuration.properties file.
             * And then, we load these information into a Properties class object
             * by initiating a FileInputStream class  object.
             * This is where we will get type of browser by using ConfigurationReader.java class object.
             */
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    /*
                     * Below are the list of available and most commonly used arguments for ChromeOptions class
                     * start-maximized: Opens Chrome in maximize mode
                     * incognito: Opens Chrome in incognito mode
                     * headless: Opens Chrome in headless mode
                     * disable-extensions: Disables existing extensions on Chrome browser
                     * disable-popup-blocking: Disables pop-ups displayed on Chrome browser
                     * make-default-browser: Makes Chrome default browser
                     * version: Prints chrome browser version
                     * disable-infobars: Prevents Chrome from displaying the notification ‘Chrome is being controlled by automated software

                     */
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");

            }

        }
        return driverPool.get();

    }
}
