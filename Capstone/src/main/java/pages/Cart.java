package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cart extends Base{
    public Cart(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(how = How.ID, using = "tbodyid")
    private WebElement listOfItems;
    @FindBy(how = How.ID, using = "totalp")
    private WebElement totalLabel;
    //@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Place Order')]")
    private WebElement placeOrderButton;

    public WebElement getListOfItems() {
        return listOfItems;
    }
    public WebElement getTotalLabel() {
        return totalLabel;
    }
    public WebElement getPlaceOrderButton() {
        return placeOrderButton;
    }

}
