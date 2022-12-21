package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.Product;

import java.time.Duration;

public class ProductSteps extends BaseSteps{
    Product product = PageFactory.initElements(webDriver, Product.class);
    Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
            .withTimeout(Duration.ofSeconds(50))
            .pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
    public ProductSteps(WebDriver webDriver){
        super(webDriver);
    }
    public String getNameOfProduct(String introducedName) throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElement(product.getNameOfProduct(),introducedName));
        System.out.println("Name of product is: " + product.getNameOfProduct().getText());
        return product.getNameOfProduct().getText();
    }
    public String getPriceOfProduct() throws InterruptedException {
        System.out.println( "Price of product is: " +product.getPriceOfProduct().getText());
        return product.getPriceOfProduct().getText();
    }

    public String getDescriptionOfProduct() throws InterruptedException {
        System.out.println("Description of product is: " + product.getDescriptionOfProduct().getText());
        return product.getDescriptionOfProduct().getText();
    }
    public boolean getImageOfProduct() throws InterruptedException {
        System.out.println("Image of product is displayed: " + product.getImageOfProduct().isDisplayed());
        return product.getImageOfProduct().isDisplayed();
    }
    public String getTextAddToCartButton() throws InterruptedException {
        System.out.println( product.getAddToCartButton().getText() +  " is available");
        return product.getAddToCartButton().getText();
    }

    public void clickOnAddToCartButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable (product.getAddToCartButton()));
        product.getAddToCartButton().click();
    }
    public String addedProductModal() throws InterruptedException {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String modalText = alert.getText();
        System.out.println("Modal " + modalText );
        alert.accept();
        return modalText;
    }
}
