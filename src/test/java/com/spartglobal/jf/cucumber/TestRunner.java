package com.spartglobal.jf.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@totalRatingsOnPage",
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/reports/htmlReport.html", "json:target/reports/jsonReport.json"}
        )
public class TestRunner {
}
