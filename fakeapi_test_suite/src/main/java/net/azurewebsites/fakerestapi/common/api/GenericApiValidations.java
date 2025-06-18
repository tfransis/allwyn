package net.azurewebsites.fakerestapi.common.api;

import net.azurewebsites.fakerestapi.utils.Test;

public class GenericApiValidations {
    final Test test;

    public GenericApiValidations(Test test) {
        this.test = test;
    }

    public void validateStatusCode(int StatusCode) {
        test.context().getResponse().then().statusCode(StatusCode);
    }
}
