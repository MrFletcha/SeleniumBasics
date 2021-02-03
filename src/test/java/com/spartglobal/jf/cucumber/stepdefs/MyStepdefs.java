package com.spartglobal.jf.cucumber.stepdefs;

import com.spartglobal.jf.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MyStepdefs {
    Calculator calculator;
    private int total;
    @Given("I have a calculator")
    public void iHaveACalculator() {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        total = calculator.add(arg0,arg1);
    }

    @When("I add Integer.max and Integer.max")
    public void iAddIntegerMaxAndIntegerMax() {
        total = calculator.add(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Then("I will get {int}")
    public void iWillGet(int arg0) {
        Assertions.assertEquals(total, arg0);
    }
}
