package pages.base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public abstract class BasePage {

    protected WebDriver driver;
    protected String baseURL = "https://mail.ru/";
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public abstract BasePage isPageOpened();

    protected void waitForElement(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException ex) {
            log.error("Cannot find element using locator {}", locator);
            log.error(ex.getLocalizedMessage());
        }
    }
}
