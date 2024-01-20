package steps;

import io.cucumber.java.en.Given;
import pages.GenericPage;

public class GenericSteps extends BaseSteps {

    @Given("user navigates to {string}")
    public void userNavigatesToUrl(String url) {
        pageStore.get(GenericPage.class).navigateTo(url);
    }

}
