package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DemoQAHomePage;

import static steps.BaseSteps.pageStore;

public class DemoQAHomePageSteps {

    @Then("user should be landed on DemoQA home screen")
    public void userShouldBeLandedOnDemoQAHomeScreen() {
        pageStore.get(DemoQAHomePage.class).verifyTheDemoQAHomeScreen();
    }

    @And("user clicks on Resizable link present under interactions section")
    public void userClicksOnResizableLinkPresentUnderInteractionsSection() {
        pageStore.get(DemoQAHomePage.class).openInteractionsBlockAndExpand();
        pageStore.get(DemoQAHomePage.class).clickOnResizableLink();
    }

    @And("user clicks on Droppable link present under interactions section")
    public void userClicksOnDroppableLinkPresentUnderInteractionsSection() {
        pageStore.get(DemoQAHomePage.class).openInteractionsBlockAndExpand();
        pageStore.get(DemoQAHomePage.class).clickOnDroppableLink();
    }
}
