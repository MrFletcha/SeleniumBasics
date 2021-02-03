package com.spartglobal.jf.cucumber.stepdefs;

import com.spartglobal.jf.pom.factory.PageFactory;
import com.spartglobal.jf.pom.pages.Past;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class pastStepDef {


    private static WebDriver webDriver;
    private static Past past;
    private int total;

    @Before
    public void setUp()
    {
         webDriver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }

    @Given("I have a WebDriver")
    public void iHaveAWebDriver() {
        webDriver.get("http://news.ycombinator.com/");
    }

    @When("I open the {string} page")
    public void iOpenThePage(String arg0) {
        webDriver.findElement(By.linkText(arg0)).click();
    }

    @Then("The date displayed in the header will be equal to yesterdays date")
    public void theDateDisplayedInTheHeaderWillBeEqualToYesterdaysDate() {
        Assertions.assertEquals("https://news.ycombinator.com/front", webDriver.getCurrentUrl());
    }

    @Given("I am on {string} page")
    public void iAmOnPage(String arg0) {
        webDriver.get(arg0);
    }

    @When("I click on the linked list text {string}")
    public void iClickOnTheLinkedListText(String arg0) {
        webDriver.findElement(By.linkText(arg0)).click();

    }

    @Then("The date should be {string}")
    public void theDateShouldBe(String arg0) {
        String targetDate = webDriver.findElement(By.className("pagetop")).getText();
        Assertions.assertTrue(targetDate.contains(arg0));
    }

    @When("I count the number of ratings on the page")
    public void iCountTheNumberOfRatingsOnThePage() {
        past = (Past) PageFactory.goToPage("past", webDriver);
        assert past != null;
        total = past.pageRankTotal();
    }

    @Then("The count should always be {int}")
    public void theCountShouldAlwaysBe(int arg0) {
        Assertions.assertEquals(arg0, total);
    }
}
