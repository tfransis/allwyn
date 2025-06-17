package net.azurewebsites.fakerestapi.books.validations;

import net.azurewebsites.fakerestapi.books.dto.BookDto;
import net.azurewebsites.fakerestapi.utils.Test;
import org.testng.Assert;

public class BooksApiValidations {
    final Test test;

    public BooksApiValidations(Test test) {
        this.test = test;
    }

    public void validateStatusCode(int StatusCode) {
        test.context().getResponse().then().statusCode(StatusCode);
    }

    public void validateBook(BookDto expectedBook) {
        BookDto actualBook = test.context().getResponse().body().as(BookDto.class);
        Assert.assertEquals(actualBook, expectedBook);
    }
}
