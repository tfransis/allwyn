package net.azurewebsites.fakerestapi.utils.factories;

import net.azurewebsites.fakerestapi.authors.api.AuthorsApi;
import net.azurewebsites.fakerestapi.books.api.BooksApi;
import net.azurewebsites.fakerestapi.common.api.GenericApi;
import net.azurewebsites.fakerestapi.utils.Test;

import java.util.Objects;

public class WebServiceFactory {
    final Test test;
    BooksApi books;
    AuthorsApi authors;

    public WebServiceFactory(Test test) {
        this.test = test;
    }

    public BooksApi books() {
        return Objects.requireNonNullElseGet(books, () -> books = new BooksApi(test));
    }

    public AuthorsApi authors() {
        return Objects.requireNonNullElseGet(authors, () -> authors = new AuthorsApi(test));
    }
}
