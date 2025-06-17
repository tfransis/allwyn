package net.azurewebsites.fakerestapi.books.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import net.azurewebsites.fakerestapi.books.dto.BookDto;
import net.azurewebsites.fakerestapi.books.validations.BooksApiValidations;
import net.azurewebsites.fakerestapi.utils.GenericApi;
import net.azurewebsites.fakerestapi.utils.Test;

import java.util.Arrays;
import java.util.List;

public class BooksApi {
    private static final String PATH_BOOKS = "/api/v1/Books";

    final Test test;
    final String url;

    public BooksApi(Test test) {
        this.test = test;
        url = test.envDataConfig().getApplicationUrl() + PATH_BOOKS;
    }

    public BooksApiValidations validate() {
        return new BooksApiValidations(test);
    }

    @SneakyThrows
    public void addBook(BookDto book) {
        String body = new ObjectMapper().writeValueAsString(book);
        test.context().setResponse(GenericApi.post(url, body));
    }

    @SneakyThrows
    public void updateBook(BookDto book) {
        String updateUrl = url + "/" + book.getId();
        String body = new ObjectMapper().writeValueAsString(book);
        test.context().setResponse(GenericApi.post(updateUrl, body));
    }

    @SneakyThrows
    public BookDto getBook(Integer bookId) {
        String getUrl = url + "/" + bookId;
        test.context().setResponse(GenericApi.get(getUrl));
        test.context().getResponse().then().statusCode(200);
        return test.context().getResponse().body().as(BookDto.class);
    }

    @SneakyThrows
    public List<BookDto> getBooks() {
        test.context().setResponse(GenericApi.get(url));
        test.context().getResponse().then().statusCode(200);
        return Arrays.asList(test.context().getResponse().body().as(BookDto[].class));
    }

    @SneakyThrows
    public void deleteBook(Integer bookId) {
        String deleteUrl = url + "/" + bookId;
        test.context().setResponse(GenericApi.delete(deleteUrl));
    }
}
