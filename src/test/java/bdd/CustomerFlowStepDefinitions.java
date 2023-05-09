package bdd;

import appmanager.ApplicationManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class CustomerFlowStepDefinitions {

    ApplicationManager app;

    @Before
    public void init() throws IOException {
    app = new ApplicationManager(System.getProperty("browser", "chrome"));
    app.init();
    }

    @After
    public void stop() {
        app.stop();
    }

    @Given("^main page is open$")
    public void openClientDashboard() throws InterruptedException {
        app.goTo().mainPage();
        app.goTo().chooseCountry("United States");
    }

    @When("^I fill search input with (.*) and click search btn$")
    public void searchItemByNavSearchInput(String item) throws InterruptedException {
        app.nav().searchItem(item);
        app.session().waitForLoadingItems();
    }

    @Then("^list of found items will be displayed$")
    public void displayListOfItems() throws InterruptedException {
        app.session().waitForLoadingItems();
        System.out.println(app.searchResult().getItems());
    }
}
