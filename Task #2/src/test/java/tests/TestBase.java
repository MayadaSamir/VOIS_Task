package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase
{
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void StartDriver(@Optional("chrome") String BrowserName)
    {
        if(BrowserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        else if(BrowserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().setSize(new Dimension(1024,768));
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com/index.php");
    }

    @AfterSuite
    public void StopDriver()
    {
        driver.quit();
    }
}
