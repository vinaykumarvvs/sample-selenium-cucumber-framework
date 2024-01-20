package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAHomePage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "[src='/images/Toolsqa.jpg']")
    private WebElement toolsQAImage;

    @FindBy(xpath = "//*[text()='Interactions']")
    private WebElement interactionsBlockBtn;

    @FindBy(xpath = "//*[text()='Resizable']")
    private WebElement resizableOption;

    @FindBy(xpath = "//*[text()='Droppable']")
    private WebElement droppableLink;

    public DemoQAHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyTheDemoQAHomeScreen() {
        waitForElementToBeVisible(toolsQAImage, driver);
    }

    public void openInteractionsBlockAndExpand() {
        clickOn(interactionsBlockBtn, driver);
        clickOn(interactionsBlockBtn, driver);
    }

    public void clickOnResizableLink() {
        scrollToElement(By.xpath("//*[text()='Resizable']"), driver);
        clickOn(resizableOption, driver);
    }

    public void clickOnDroppableLink() {
        scrollToElement(By.xpath("//*[text()='Droppable']"), driver);
        clickOn(droppableLink, driver);
    }
}
