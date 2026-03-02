package framework.base;

import framework.drivers.DriverFactory;
import framework.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger logger = LogManager.getLogger(getClass());

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicit.wait.seconds")));
        logger.info("Navigating to app base URL");
        driver.get(System.getProperty("baseUrl", ConfigReader.get("base.url")));
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        logger.info("Closing browser instance");
        DriverFactory.quitDriver();
    }
}
