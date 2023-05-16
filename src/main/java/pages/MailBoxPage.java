package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

@Log4j2
public class MailBoxPage extends BasePage {

    private static final By AVATAR_IMG = By.xpath("//img[@class= 'ph-avatar-img svelte-dfhuqc']"),
            WRITE_MAIL_BUTTON = By.xpath("//span[@class= 'compose-button__txt']"),
            EMAIL_ADDRESS_FIELD = By.xpath("//div[@data-type= 'to']//input"),
            SUBJECT_FIELD = By.xpath("//input[@name = 'Subject']"),
            EMAIL_BODY = By.xpath("//div[@role = 'textbox']//div"),
            SEND_BUTTON = By.xpath("//span[text() = 'Отправить']"),
            MESSAGE_ABOUT_SENDING = By.xpath("//a[@class = 'layer__link']");

    public MailBoxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MailBoxPage isPageOpened() {
        log.info("Mail box page is opened");
        waitForElement(AVATAR_IMG);
        return this;
    }

    public void writeMailService(String emailAddress, String subject, String text) {
        log.info("Send email to address '{}' with subject '{}' and text '{}'", emailAddress, subject, text);
        driver.findElement(WRITE_MAIL_BUTTON).click();
        waitForElement(WRITE_MAIL_BUTTON);
        driver.findElement(EMAIL_ADDRESS_FIELD).sendKeys(emailAddress);
        driver.findElement(SUBJECT_FIELD).sendKeys(subject);
        driver.findElement(EMAIL_BODY).sendKeys(text);
        driver.findElement(SEND_BUTTON).click();
    }

    public String getMessageAboutSending() {
        return driver.findElement(MESSAGE_ABOUT_SENDING).getText();
    }
}
