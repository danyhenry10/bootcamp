package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header extends Base{
    public Header(WebDriver webDriver) {

        super(webDriver);
    }
    @FindBy(how = How.ID, using = "cartur")
    private WebElement cartLink;

    public WebElement getCartLink() {
        return cartLink;
    }
}
