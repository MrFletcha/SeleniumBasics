package com.spartglobal.jf.pom;

import com.spartglobal.jf.pom.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage implements ChangeAble{

    private WebDriver webDriver;

    public HomePage(WebDriver driver)
    {
        webDriver = driver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public ChangeAble goToPage(String page)
    {
        switch(page)
        {
            case "new":
                webDriver.findElement(By.linkText("new")).click();
                return new New(webDriver);
            case "comments":
                webDriver.findElement(By.linkText("comments")).click();
                return new Comments(webDriver);
            case "ask":
                webDriver.findElement(By.linkText("ask")).click();
                return new Ask(webDriver);
            case "past":
                webDriver.findElement(By.linkText("past")).click();
                return new Past(webDriver);
            case "show":
                webDriver.findElement(By.linkText("show")).click();
                return new Show(webDriver);
            case "jobs":
                webDriver.findElement(By.linkText("jobs")).click();
                return new Jobs(webDriver);
            case "submit":
                webDriver.findElement(By.linkText("submit")).click();
                return new Submit(webDriver);
        }
        return null;
    }

    @Override
    public String lastPageRank()
    {
        return webDriver.findElements(By.className("rank")).get(29).getText();
    }

    @Override
    public int pageRankTotal()
    {
        return webDriver.findElements(By.className("rank")).size();
    }

    @Override
    public String pageRankTop()
    {
        return webDriver.findElement(By.className("rank")).getText();
    }
}
