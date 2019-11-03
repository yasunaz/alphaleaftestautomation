package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utility.UserAction;
import java.util.concurrent.TimeUnit;


public abstract class TestBase {

    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = System.getProperty("browser");
        String env = System.getProperty("environment");
        if (browser == null || browser.equals(""))
            System.out.println("LOG:> User Did Not Select Browser, Choosing Default");
        else
            System.out.println("LOG:> User Select Browser: " + browser);
        startChosenBroser(browser);
        System.out.println("LOG:> User Selected Environemnt: " + env);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    // Depending upon the user's chosen browser at the command line
    // it will start up the corresponding borwser for the user
    private void startChosenBroser(String selected) {
        if (selected == null || selected.equals("") || selected.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (selected.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (selected.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        UserAction.initialize(driver);
    }
}
