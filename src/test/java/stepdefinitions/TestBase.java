package stepdefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests{
    public static WebDriver driver;
    static final String app_URL = "https://www.demoblaze.com";
    static final String host_URL = "http://localhost:4444/wd/hub";

    @Parameters({"browser"})
    @BeforeTest
    public void setup(@Optional("chrome")String browser) throws MalformedURLException, InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options=new ChromeOptions();
            driver= new RemoteWebDriver(new URL(host_URL), options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            driver= new RemoteWebDriver(new URL(host_URL), options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver= new RemoteWebDriver(new URL(host_URL), options);
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
       driver.get(app_URL);
       Thread.sleep(5000);
    }

    @AfterSuite
    public void teardown(){
        if(driver != null)
            driver.quit();
    }
}
