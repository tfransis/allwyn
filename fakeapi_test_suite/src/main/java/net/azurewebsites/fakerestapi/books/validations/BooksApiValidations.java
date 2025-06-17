package net.azurewebsites.fakerestapi.books.validations;

import net.azurewebsites.fakerestapi.books.dto.BookDto;
import net.azurewebsites.fakerestapi.utils.GenericApiValidations;
import net.azurewebsites.fakerestapi.utils.Test;
import org.testng.Assert;

public class BooksApiValidations extends GenericApiValidations {
    final Test test;

    public BooksApiValidations(Test test) {
        super(test);
        this.test = test;
    }

    public void validateBook(BookDto expectedBook) {
        BookDto actualBook = test.context().getResponse().body().as(BookDto.class);
        Assert.assertEquals(actualBook, expectedBook);
    }

    public void validateBooksCount(long expectedBooksCount) {
        Assert.assertEquals(test.context().getBooks().size(), expectedBooksCount);
    }
}
