package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Manager {

    public static WebDriver driver;

    public static WebDriver getInstance() {
//        System.getProperty(Constant.WEB_DRIVER_CHROME);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("window-size=1200x600");

        DesiredCapabilities capabilities = null;
        String browserVersion = "";
        if (Config.osName.startsWith("Window")) {
            System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver");
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("start-fullscreen");
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability("version", browserVersion);
        chromeOptions.merge(capabilities);
        try {
            driver = new ChromeDriver(chromeOptions);
        } catch (WebDriverException e) {
            driver = new ChromeDriver(chromeOptions);
        }

        return driver = new ChromeDriver(chromeOptions);
    }
}
