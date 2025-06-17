package net.azurewebsites.fakerestapi.utils;

public class GenericApiValidations {
    final Test test;

    public GenericApiValidations(Test test) {
        this.test = test;
    }

    public void validateStatusCode(int StatusCode) {
        test.context().getResponse().then().statusCode(StatusCode);
    }
}
