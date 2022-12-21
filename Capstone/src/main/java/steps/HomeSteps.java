package steps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.Home;

import java.time.Duration;

public class HomeSteps extends BaseSteps{
    Home home = PageFactory.initElements(webDriver, Home.class);
    Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
            .withTimeout(Duration.ofSeconds(50))
            .pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
    public HomeSteps(WebDriver webDriver){
        super(webDriver);
    }
    public String getTextPhoneCategory() {
        return home.getPhonesCategory().getText();
    }
    public String getTextLaptopsCategory() {
        return  home.getLaptopsCategory().getText();
    }
    public String getTextMonitorsCategory() {
        return home.getMonitorsCategory().getText();
    }
    public void clickOnSamsungS6() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable (home.getSamsungGalaxyS6()));
        home.getSamsungGalaxyS6().click();
    }
    public void clickOnSamsungS7() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable (home.getSamsungGalaxyS7()));
        home.getSamsungGalaxyS7().click();
    }

    public void clickOnNexus6() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable (home.getNexus6()));
        home.getNexus6().click();
    }

}
