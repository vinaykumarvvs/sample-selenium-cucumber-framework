package events;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class SeleniumEventHandler extends AbstractWebDriverEventListener {

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        String jScript = "var changeText = document.getElementById(\"droppable\");" +
                "changeText.innerHTML = \"Drop here\";";

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(jScript);
    }
}
