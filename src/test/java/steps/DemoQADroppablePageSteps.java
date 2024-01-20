package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DemoQADroppablePage;

public class DemoQADroppablePageSteps extends BaseSteps{

    @Then("user should be navigated to Droppable screen")
    public void userShouldBeNavigatedToDroppableScreen() {
        pageStore.get(DemoQADroppablePage.class).verifyTheDroppableScreen();
    }

    @And("user drag's the child box and drop it on top of parent box")
    public void userDragSTheElementAndDropItOnTopOfOtherElement() {
        pageStore.get(DemoQADroppablePage.class).dragTheChildBoxAndDropItOnTopOfParentBox();
    }

    @And("user drag's back the child box from top of parent box")
    public void userDragSTheBoxOutToPreviousPosition() {
        pageStore.get(DemoQADroppablePage.class).dragTheChildBoxOutFromTopOfParentBox();
    }

    @Then("user should see that text has changed from dropped to drop here")
    public void userShouldSeeThatTextHasChangedFromDroppedToDropHere() {
        pageStore.get(DemoQADroppablePage.class).verifyTheTextOnDroppableBoxHasChangedToDropHere();
    }
}
