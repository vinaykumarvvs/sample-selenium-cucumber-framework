package pages;

import org.openqa.selenium.WebDriver;

public class GenericPage {

    private WebDriver driver;

    public GenericPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }
}
