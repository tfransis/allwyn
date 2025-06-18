package net.azurewebsites.fakerestapi.authors.validations;

import net.azurewebsites.fakerestapi.authors.dto.AuthorDto;
import net.azurewebsites.fakerestapi.utils.Test;
import org.testng.Assert;

public class AuthorsApiValidations {
    final Test test;

    public AuthorsApiValidations(Test test) {
        this.test = test;
    }

    public void validateAuthor(AuthorDto expectedAuthor) {
        AuthorDto actualAuthor = test.context().getResponse().body().as(AuthorDto.class);
        Assert.assertEquals(actualAuthor, expectedAuthor);
    }

    public void validateAuthorsCount(long expectedAuthorsCount) {
        Assert.assertEquals(test.context().getAuthors().size(), expectedAuthorsCount);
    }

    public void validateAuthorsBook(int bookId) {
        Assert.assertTrue(test.context().getAuthors().stream().allMatch(author -> author.getIdBook() == bookId));
    }
}
