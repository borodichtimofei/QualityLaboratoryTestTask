package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MailBoxPage;
import pages.MainPage;
import utils.PropertyReader;

import java.time.Duration;

public class BaseTest {

    public MainPage mainPage;
    public MailBoxPage mailBoxPage;
    protected String user;
    protected String password;
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));
        mainPage = new MainPage(driver);
        mailBoxPage = new MailBoxPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}
