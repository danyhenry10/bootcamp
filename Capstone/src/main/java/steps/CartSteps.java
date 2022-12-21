package steps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.Cart;

import java.time.Duration;

public class CartSteps extends BaseSteps{
    Cart cart = PageFactory.initElements(webDriver, Cart.class);
    Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
            .withTimeout(Duration.ofSeconds(50))
            .pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);

    public CartSteps(WebDriver webDriver) {
        super(webDriver);
    }
    public String getPlaceOrderText() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable( cart.getPlaceOrderButton()));
        System.out.println("Button name is: " + cart.getPlaceOrderButton().getText());
        return cart.getPlaceOrderButton().getText();
    }

    public String getTotalLabelText() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(cart.getTotalLabel() ));
        System.out.println("Total is: " + cart.getTotalLabel().getText());
        return cart.getTotalLabel().getText();
    }

    public String getListOfItemsText() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(cart.getListOfItems() ));
        System.out.println("List of Items is: " + cart.getListOfItems().getText());
        return cart.getListOfItems().getText();
    }
}
