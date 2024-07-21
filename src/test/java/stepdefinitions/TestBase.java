package stepdefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests{
    public static WebDriver driver;
    static final String app_URL = "https://www.demoblaze.com";
    static final String host_URL = "http://localhost:4444/wd/hub";

    @BeforeSuite
    public void setup() throws MalformedURLException {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().clearDriverCache().setup();
//            driver = new ChromeDriver();
            ChromeOptions options=new ChromeOptions();
            driver= new RemoteWebDriver(new URL(host_URL), options);
        } else if (browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver();
            driver=new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
    }
        driver.manage().window().maximize();
       driver.get(app_URL);
    }

    @AfterSuite
    public void teardown(){
        if(driver != null)
            driver.quit();
    }
}
