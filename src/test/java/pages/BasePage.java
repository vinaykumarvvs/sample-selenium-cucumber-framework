package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class BasePage {

    private int waitTime = 30;

    void waitForElementToBeVisible(WebElement element, WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementToBeClickable(WebElement element, WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    void clickOn(WebElement element, WebDriver webDriver) {
        waitForElementToBeVisible(element, webDriver);
        waitForElementToBeClickable(element, webDriver);
        element.click();
    }

    void clickOn(By by, WebDriver webDriver) {
        await().atMost(30, TimeUnit.SECONDS).until(() -> webDriver.findElements(by).size() == 1);
        webDriver.findElement(by).click();
    }

    void enterText(WebElement element, String text, WebDriver webDriver) {
        waitForElementToBeVisible(element, webDriver);
        element.clear();
        element.sendKeys(text);
    }

    void jsClick(WebElement element, WebDriver webDriver) {
        waitForElementToBeVisible(element, webDriver);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
    }

    void scrollToElement(By by, WebDriver driver) {
        int currentYLocation = driver.findElement(by).getLocation().y;
        int previousYLocation;
        do {
            previousYLocation = currentYLocation;
            String script = "window.scrollTo(0," + currentYLocation + ")";
            ((JavascriptExecutor) driver).executeScript(script);
            currentYLocation = driver.findElement(by).getLocation().y;

        } while (previousYLocation != currentYLocation);
    }

    void sleepFor(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    long findDiffBetweenTwoDatesInMinutes(String time1, String time2, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(time1);
            date2 = simpleDateFormat.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date1 != null && date2 != null)
            return ((date1.getTime() - date2.getTime()) / 1000) / 60;
        return 0;
    }

}
