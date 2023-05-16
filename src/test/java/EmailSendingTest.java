import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EmailSendingTest extends BaseTest {

    public static final String EMAIL_ADDRESS = "borokko1980@gmail.com",
            SUBJECT = "Test",
            EMAIL_TEXT = "Quality Laboratory",
            MESSAGE_ABOUT_SENDING = "Письмо отправлено";

    @Test(description = "Successful sending email test")
    public void checkEmailSending() {
        mainPage.open()
                .isPageOpened()
                .signInService(user, password)
                .isPageOpened()
                .writeMailService(EMAIL_ADDRESS, SUBJECT, EMAIL_TEXT);
        assertEquals(mailBoxPage.getMessageAboutSending(),
                MESSAGE_ABOUT_SENDING,
                "Message is not correct");
    }
}
