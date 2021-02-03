package com.spartglobal.jf.pom.pages;

import com.spartglobal.jf.pom.factory.ChangeAble;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Past implements ChangeAble {

    WebDriver webDriver;
    private static LocalDate targetDay;
    private static String date_format = "MMM d, yyyy";

    public Past(WebDriver driver)
    {
        this.webDriver = driver;
    }

    public String getPast()
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

    //There are two links named exactly the same, which is "day", so this method only finds the first one.
    public boolean isCorrectDate(String option)
    {
        targetDay = selectedPageDate(option);
        String headerText = webDriver.findElement(By.className("pagetop")).getText();
        return headerText.contains(targetDay.toString());
    }

    public boolean isCorrectStoriesDate(String option)
    {
        targetDay = selectedPageDate(option);
        String headerText = webDriver
                .findElement(By.cssSelector("#hnmain > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)"))
                .getText();
        LocalDate targetDay = LocalDate.now().minusDays(1);
        return headerText.contains((targetDay.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"))));
    }

    public LocalDate selectedPageDate(String option)
    {
        LocalDate targetDay = LocalDate.now().minusDays(1);
        webDriver.findElement(By.linkText("past")).click();
        switch(option)
        {
            case "month":
                webDriver.findElement(By.linkText("month")).click();
                targetDay = targetDay.minusMonths(1);
                break;
            case "year":
                webDriver.findElement(By.linkText("year")).click();
                targetDay = targetDay.minusMonths(12);
                break;
            case "day":
                webDriver.findElement(By.linkText("day")).click();
                targetDay = targetDay.minusDays(1);
                break;
        }
        return targetDay;
    }
}
