package pages;

import events.DragAndDropEventHandler;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import events.SeleniumEventHandler;

public class DemoQADroppablePage extends BasePage {

    private final String droppableBoxId = "droppable";
    private WebDriver driver;
    private EventFiringWebDriver eventFiringWebDriver;
    private SeleniumEventHandler seleniumEventHandler;
    private DragAndDropEventHandler dragAndDropEventHandler;

    @FindBy(xpath = "//div[@class='main-header' and text()='Droppable']")
    private WebElement droppableTitle;

    @FindBy(id = "draggable")
    private WebElement draggable;

    @FindBy(id = droppableBoxId)
    private WebElement droppable;

    public DemoQADroppablePage(WebDriver driver) {
        this.driver = driver;
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        seleniumEventHandler = new SeleniumEventHandler();
        dragAndDropEventHandler = new DragAndDropEventHandler();
    }

    public void verifyTheDroppableScreen() {
        waitForElementToBeVisible(droppableTitle, driver);
        Assert.assertTrue(String.format("Text did not match. Expected is: %s, Actual is: %s", "Droppable", droppableTitle.getText()),
                droppableTitle.getText().contains("Droppable"));
    }

    public void dragTheChildBoxAndDropItOnTopOfParentBox() {
        waitForElementToBeVisible(draggable, driver);
        sleepFor(1000);
        new Actions(driver).clickAndHold(draggable).moveToElement(droppable).release().perform();
        sleepFor(1000);
        Assert.assertEquals("Dropped!", droppable.getText());
        dragAndDropEventHandler.draggedChildBoxOnTopOfParentBox();
    }

    public void dragTheChildBoxOutFromTopOfParentBox() {
        waitForElementToBeVisible(draggable, driver);
        new Actions(driver).clickAndHold(draggable).moveByOffset(-150, 10).release().perform();
        dragAndDropEventHandler.draggedBackChildBoxFromTopOfParentBox();

        eventFiringWebDriver.register(seleniumEventHandler);
        Assert.assertEquals(eventFiringWebDriver.findElement(By.id(droppableBoxId)).getText(), "Dropped!");
        eventFiringWebDriver.unregister(seleniumEventHandler);
    }

    public void verifyTheTextOnDroppableBoxHasChangedToDropHere() {
        waitForElementToBeVisible(droppable, driver);
        Assert.assertEquals("Drop here", droppable.getText());
    }
}
