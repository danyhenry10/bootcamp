package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class Home extends Base{
    public Home(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.LINK_TEXT, using = "Phones")
    private WebElement phonesCategory;

    @FindBy(how = How.LINK_TEXT, using = "Laptops")
    private WebElement laptopsCategory;

    @FindBy(how = How.LINK_TEXT, using = "Monitors")
    private WebElement monitorsCategory;

    @FindBy(how = How.LINK_TEXT, using = "Samsung galaxy s6")
    private WebElement samsungGalaxyS6;

    @FindBy(how = How.LINK_TEXT, using = "Samsung galaxy s7")
    private WebElement samsungGalaxyS7;

    @FindBy(how = How.LINK_TEXT, using = "Nexus 6")
    private WebElement nexus6;

    public WebElement getPhonesCategory() {
        return phonesCategory;
    }
    public WebElement getLaptopsCategory() {
        return laptopsCategory;
    }
    public WebElement getMonitorsCategory() {
        return monitorsCategory;
    }

    public WebElement getSamsungGalaxyS6() {
        return samsungGalaxyS6;
    }

    public WebElement getSamsungGalaxyS7() {
        return samsungGalaxyS7;
    }

    public WebElement getNexus6() {
        return nexus6;
    }
}
