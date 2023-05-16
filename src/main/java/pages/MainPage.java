package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

@Log4j2
public class MainPage extends BasePage {

    private static final By LOGIN_BUTTON = By.xpath("//button[@data-testid = 'enter-mail-primary']"),
            LOGIN_POPUP_TITLE = By.xpath("//h3[text()= 'Sign in to the account']"),
            LOGIN_FIELD = By.xpath("//input[@name = 'username']"),
            ENTER_PASSWORD_BUTTON = By.xpath("//span[text() = 'Enter password']"),
            PASSWORD_FIELD = By.xpath("//input[@name = 'password']"),
            SIGN_IN_BUTTON = By.xpath("//span[text() = 'Sign in']"),
            I_FRAME = By.xpath("//iframe[@class = 'ag-popup__frame__layout__iframe']");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage isPageOpened() {
        log.info("Main page is opened");
        waitForElement(LOGIN_BUTTON);
        return this;
    }

    public MainPage open() {
        log.info("Opening main page");
        driver.get(baseURL);
        return this;
    }

    public MailBoxPage signInService(String user, String password) {
        log.info("Sign in by '{}' using password '{}'", user, password);
        driver.findElement(LOGIN_BUTTON).click();
        driver.switchTo().frame(driver.findElement(I_FRAME));
        waitForElement(LOGIN_POPUP_TITLE);
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(ENTER_PASSWORD_BUTTON).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new MailBoxPage(driver);
    }
}
