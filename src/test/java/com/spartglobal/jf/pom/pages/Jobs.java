package com.spartglobal.jf.pom.pages;

import com.spartglobal.jf.pom.factory.ChangeAble;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Jobs implements ChangeAble {

    WebDriver webDriver;

    public Jobs(WebDriver driver)
    {
        this.webDriver = driver;
    }

    public String getJobs()
    {
        return webDriver.getCurrentUrl();
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
