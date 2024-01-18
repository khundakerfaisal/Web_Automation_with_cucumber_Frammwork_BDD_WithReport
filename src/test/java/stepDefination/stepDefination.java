package stepDefination;

import Setup.setup;
import Utils.utils;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import pages.landingPage;

public class stepDefination extends setup {
    landingPage landingPage = new landingPage(driver);

    @Given("User visited the Github page enter the website url")
    public void user_visited_the_github_page_enter_the_website_url() throws InterruptedException {
        driver.get("https://github.com/");
        Thread.sleep(2000);
    }

    @When("User search With {string}")
    public void userSearchWith(String searchName) throws InterruptedException {
        landingPage.doSearchByName(searchName);
    }

    @Then("User can find with {string}")
    public void userCanFindWith(String searchExpectName) throws InterruptedException {
        String searchActual = landingPage.searchResult.get(0).getText();
        System.out.println(searchActual);
        Assert.assertTrue(searchActual.contains(searchExpectName));
        Thread.sleep(1000);

    }

    @Then("User click on the About page")
    public void user_click_on_the_about_page() throws InterruptedException {
        landingPage.landingPageGit.get(0).click();
        utils.doScroll(driver, 1200);
        Thread.sleep(4000);
        landingPage.about.click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("about"));
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
