package net.azurewebsites.fakerestapi.stepdefs;

import io.cucumber.java.en.Then;
import net.azurewebsites.fakerestapi.common.api.GenericApiValidations;
import net.azurewebsites.fakerestapi.utils.Test;

public class CommonApiStepDefs {
    final Test test;

    public CommonApiStepDefs(Test test) {
        this.test = test;
    }

    @Then("verify that the response status code is {int}")
    public void validateStatusCode(int statusCode) {
        new GenericApiValidations(test).validateStatusCode(statusCode);
    }
}
