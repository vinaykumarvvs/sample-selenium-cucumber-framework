package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DemoQAResizablePage;

public class DemoQAResizablePageSteps extends BaseSteps{

    @Then("user should be navigated to Resizable screen")
    public void userShouldBeNavigatedToResizableScreen() {
        pageStore.get(DemoQAResizablePage.class).verifyTheResizableScreen();
    }

    @And("user resize's the editor with x-offset as {int} and y-offset as {int}")
    public void userResizeSTheEditorWithXOffsetAsAndYOffsetAs(int xOffSet, int yOffSet) {
        pageStore.get(DemoQAResizablePage.class).resizeTheTextEditor(xOffSet, yOffSet);
    }
}
