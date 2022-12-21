
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.CartSteps;
import steps.HomeSteps;
import steps.ProductSteps;
import steps.HeaderSteps;

import tests.CustomAssertions;
import java.time.Duration;

import java.io.File;


public class RunTest {
    public WebDriver driver = getDriver();
    HomeSteps homeSteps = new HomeSteps(driver);
    ProductSteps productSteps = new ProductSteps(driver);
    HeaderSteps headerSteps = new HeaderSteps(driver);
    CartSteps cartSteps = new CartSteps(driver);
    CustomAssertions customAssertions = new CustomAssertions();
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(50))
            .pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
    String baseURL="https://www.demoblaze.com";

    private WebDriver getDriver() {
        setupDriver("chrome");
        return driver;
    }

    private void setupDriver(String browserName) {
        switch(browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
                driver = new ChromeDriver();
                System.out.println("Opening " + browserName );
                break;
            default:
                System.out.println(browserName +" web driver was not found");
        }
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){

        driver.manage().window().maximize();
        driver.get(baseURL);
        System.out.println("Getting " + baseURL );
    }
    @Test (description = "Testing SR-12111, where the system must show categories Phones, Laptops and Monitors",
            groups = "SmokeSuite", priority = 0)
    public void TestCategories(){
        customAssertions.isLabelEqual("Laptops" , homeSteps.getTextLaptopsCategory()) ;
        customAssertions.isLabelEqual("Phones" ,  homeSteps.getTextPhoneCategory());
        customAssertions.isLabelEqual("Monitors" , homeSteps.getTextMonitorsCategory());
    }

    @Test (description = "Testing SR-12120, where the system must show info related with products",
            groups = "SanitySuite", priority = 1)
    public void TestProductInfo() throws InterruptedException {
        homeSteps.clickOnSamsungS6();
        customAssertions.isNotEmpty(productSteps.getNameOfProduct("Samsung galaxy s6"));
        customAssertions.isNotEmpty(productSteps.getPriceOfProduct());
        customAssertions.isNotEmpty(productSteps.getDescriptionOfProduct());
        customAssertions.isNotEmpty(productSteps.getTextAddToCartButton());
        customAssertions.isImageDisplayed( productSteps.getImageOfProduct());
    }

    @Test (description = "Testing SR-12121, where the system must show a modal after clicking add to cart button",
            groups = "SanitySuite", priority = 2)
    public void TestProductAddedModal() throws InterruptedException {
        homeSteps.clickOnSamsungS7();
        productSteps.clickOnAddToCartButton();
        customAssertions.isLabelEqual("Product added" , productSteps.addedProductModal());
    }

    @Test (description = "Testing SR-12130,where the system must show List of items,Total of items prices and Place order button",
            groups = "RegressionSuite", priority = 3)
    public void TestCartItems() throws InterruptedException {
        homeSteps.clickOnNexus6();
        productSteps.clickOnAddToCartButton();
        productSteps.addedProductModal();
        headerSteps.clickOnCartLink();
        customAssertions.isLabelEqual("Place Order" ,cartSteps.getPlaceOrderText());
        customAssertions.isNotEmpty(cartSteps.getTotalLabelText());
        customAssertions.isNotEmpty(cartSteps.getListOfItemsText());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        driver.quit();
        System.out.println("Closing browser" );

    }
}
