package com.spartglobal.jf.pom;

import com.spartglobal.jf.pom.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    public static ChangeAble goToPage(String page, WebDriver driver)
    {
        switch(page)
        {
            case "new":
                driver.findElement(By.linkText("new")).click();
                return new New(driver);
            case "comments":
                driver.findElement(By.linkText("comments")).click();
                return new Comments(driver);
            case "ask":
                driver.findElement(By.linkText("ask")).click();
                return new Ask(driver);
            case "past":
                driver.findElement(By.linkText("past")).click();
                return new Past(driver);
            case "show":
                driver.findElement(By.linkText("show")).click();
                return new Show(driver);
            case "jobs":
                driver.findElement(By.linkText("jobs")).click();
                return new Jobs(driver);
            case "submit":
                driver.findElement(By.linkText("submit")).click();
                return new Submit(driver);
        }
        return null;
    }
}
