package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Product extends Base{
    public Product(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(how = How.CLASS_NAME, using = "name")
    private WebElement nameOfProduct;
    @FindBy(how = How.CLASS_NAME, using = "price-container")
    private WebElement priceOfProduct;
    @FindBy(how = How.ID, using = "more-information")
    private WebElement descriptionOfProduct;
    @FindBy(how = How. ID, using = "imgp")
    private WebElement imageOfProduct;
    @FindBy(how = How. LINK_TEXT, using = "Add to cart")
    private WebElement addToCartButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'OK')]")
    private WebElement oKModalButton;
    public WebElement getNameOfProduct() {
        return nameOfProduct;
    }
    public WebElement getPriceOfProduct() {
        return priceOfProduct;
    }
    public WebElement getDescriptionOfProduct() {
        return descriptionOfProduct;
    }
    public WebElement getImageOfProduct() {
        return imageOfProduct;
    }
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

}
