package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.PageStore;
import utils.ScenarioContext;

public class StartingSteps extends BaseSteps {

    public static ScenarioContext scenarioContext;

    @Before
    public void beforeScenario() {
        pageStore = new PageStore();
        scenarioContext = new ScenarioContext();
        pageStore.getDriver().manage().window().maximize();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) pageStore.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        pageStore.getDriver().quit();
    }

}
