package steps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.Header;

import java.time.Duration;

public class HeaderSteps extends BaseSteps{
    Header header = PageFactory.initElements(webDriver, Header.class);
    Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
            .withTimeout(Duration.ofSeconds(50))
            .pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);

    public HeaderSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnCartLink() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable (header.getCartLink()));
        header.getCartLink().click();
    }
}
