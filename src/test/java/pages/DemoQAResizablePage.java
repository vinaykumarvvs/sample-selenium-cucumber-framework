package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import events.ResizeEventHandler;

public class DemoQAResizablePage extends BasePage {

    private WebDriver driver;
    private ResizeEventHandler resizeEventHandler;
    private int resizeCounter = 1;

    @FindBy(xpath = "//h1[@class='text-center' and text()='Resizable']")
    private WebElement resizableTitle;

    @FindBy(css = "[id='resizable'] [class*='react-resizable-handle']")
    private WebElement resizableIconInTextEditor;

    @FindBy(xpath = "//div[@id='resizable' and @style]")
    private WebElement editorAfterResize;

    public DemoQAResizablePage(WebDriver driver) {
        this.driver = driver;
        resizeEventHandler = new ResizeEventHandler();
    }

    public void verifyTheResizableScreen() {
        waitForElementToBeVisible(resizableTitle, driver);
        Assert.assertTrue(resizableTitle.getText().contains("Resizable"));
    }

    public void resizeTheTextEditor(int xOffSet, int yOffSet) {
        waitForElementToBeVisible(resizableIconInTextEditor, driver);
        sleepFor(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        sleepFor(3000);
        new Actions(driver).clickAndHold(resizableIconInTextEditor).moveByOffset(xOffSet, yOffSet).release().perform();
        sleepFor(3000);

        String elementXPath = "[id='resizable'][style='width: " + (200 + xOffSet) + "px; height: " + (200 + yOffSet) + "px;']";
        WebElement elementAfterResize = driver.findElement(By.cssSelector(elementXPath));
        Assert.assertTrue("Editor did not resize", elementAfterResize.isDisplayed());

        String width = elementAfterResize.getSize().toString().split(",")[0].replaceAll("\\(", "");
        String height = elementAfterResize.getSize().toString().split(",")[1].replaceAll("\\)", "").substring(1);
        resizeEventHandler.editorHasBeenResized(resizeCounter++, width, height);
    }

}
