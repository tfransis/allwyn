package net.azurewebsites.fakerestapi.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json", "junit:target/cucumber-junit-report.xml"},
        features = {"classpath:features"},
        glue = {"net.azurewebsites.fakerestapi.stepdefs"},
        monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
