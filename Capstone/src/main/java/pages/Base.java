package pages;

import org.openqa.selenium.WebDriver;

public class Base {
    WebDriver _webDriver;

    public Base (WebDriver webDriver) {
        this._webDriver = webDriver;
    }
}
