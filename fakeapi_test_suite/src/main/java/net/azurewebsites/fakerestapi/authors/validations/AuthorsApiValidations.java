package net.azurewebsites.fakerestapi.authors.validations;

import net.azurewebsites.fakerestapi.utils.GenericApiValidations;
import net.azurewebsites.fakerestapi.utils.Test;

public class AuthorsApiValidations extends GenericApiValidations {
    final Test test;

    public AuthorsApiValidations(Test test) {
        super(test);
        this.test = test;
    }
}
