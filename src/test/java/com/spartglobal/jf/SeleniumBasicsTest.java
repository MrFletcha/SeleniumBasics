package com.spartglobal.jf;

import com.spartglobal.jf.pom.HomePage;
import com.spartglobal.jf.pom.PageFactory;
import com.spartglobal.jf.pom.pages.New;
import com.spartglobal.jf.pom.pages.Past;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumBasicsTest {
    private static WebDriver webDriver;
    private static HomePage homePage;
    @BeforeEach
    @DisplayName("Setup")
    void setUp()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver();
        webDriver.get("http://news.ycombinator.com/");
        homePage = new HomePage(webDriver);
    }

    @AfterAll
    @DisplayName("Bring it all down")
    static void tearDown()
    {
        webDriver.quit();
    }

    @ParameterizedTest
    @DisplayName("Web Driver Test")
    @ValueSource(strings = "new")
    void webDriverTest(String string) {
        New nPage = (New) PageFactory.goToPage(string, webDriver);
        Assertions.assertEquals("https://news.ycombinator.com/newest", nPage.getNew());
    }

    @Test
    @DisplayName("Rank Check")
    void rankCheck() {
        Assertions.assertEquals("30.", homePage.lastPageRank());
        Assertions.assertEquals("1.",homePage.pageRankTop());
        webDriver.findElement(By.className("morelink")).click();
        Assertions.assertEquals("31.",homePage.pageRankTop());
        Assertions.assertEquals(30, homePage.pageRankTotal());
    }

    @Test
    @DisplayName("Web Driver Test 1")
    void webDriverTest1() {
        Past past = (Past)homePage.goToPage("past");
        Assertions.assertEquals("https://news.ycombinator.com/front", past.getPast());
    }

    @Test
    @DisplayName("Testing the search box")
    void testingTheSearchBox() {
        webDriver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        Assertions.assertEquals("https://hn.algolia.com/?q=Java", webDriver.getCurrentUrl());
        webDriver.navigate().back();
        Assertions.assertEquals("https://news.ycombinator.com/", webDriver.getCurrentUrl());
    }

    @ParameterizedTest
    @DisplayName("Date check on all pages")
    @ValueSource(strings = {"month", "day", "year", "default"})
    void dateCheckOnPage(String string) {
        Past past = (Past)homePage.goToPage("past");
        Assertions.assertTrue(past.isCorrectDate(string));
    }

    @ParameterizedTest
    @DisplayName("Correct date value at top of Page")
    @ValueSource(strings = {"month", "day", "year"})
    void correctDateValueAtTopOfPage(String string) {
        Past past = (Past)homePage.goToPage("past");
        Assertions.assertTrue(past.isCorrectStoriesDate(string));
    }

    @Test
    @DisplayName("Tab Check")
    void TabCheck() {
        String originalTab = webDriver.getWindowHandle();
        System.out.println(originalTab);
        webDriver.findElement(By.linkText("new")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        Set<String> allWindows = webDriver.getWindowHandles();
    }

    @Test
    @DisplayName("bbc")
    void bbc() {
        webDriver.get("https://www.bbc.co.uk/weather");
        webDriver.findElement(By.id("ls-c-search__input-label")).sendKeys("Lon");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement firstOption = webDriver.findElement(By.className("ls-c-locations-list-item"));
        Assertions.assertEquals("London, Greater London", firstOption.getText());
    }
}
