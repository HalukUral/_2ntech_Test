package com._2ntech.news.stepdefinetions;

import com._2ntech.news.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    public void setupScenario(){
        System.out.println("== Setting up browser using cucumber @Before");
    }
    //  @Before (value = "@login",order=1)
    public void setupScenarioForLogins(){
        System.out.println("== this will only apply to scenarios with @login tag");
    }


    @After
    public void tearDownScenario(Scenario scenario){
        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        Driver.closeDriver();
    }
}
