package net.azurewebsites.fakerestapi.authors.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.azurewebsites.fakerestapi.authors.dto.AuthorDto;
import net.azurewebsites.fakerestapi.authors.validations.AuthorsApiValidations;
import net.azurewebsites.fakerestapi.utils.GenericApi;
import net.azurewebsites.fakerestapi.utils.Test;

import java.util.Arrays;
import java.util.List;

public class AuthorsApi {
    private static final String PATH_AUTHORS = "/api/v1/Authors";

    final Test test;
    final String url;

    public AuthorsApi(Test test) {
        this.test = test;
        url = test.envDataConfig().getApplicationUrl() + PATH_AUTHORS;
    }

    public AuthorsApiValidations validate() {
        return new AuthorsApiValidations(test);
    }

    @SneakyThrows
    public void addAuthor(AuthorDto author) {
        String body = new ObjectMapper().writeValueAsString(author);
        test.context().setResponse(GenericApi.post(url, body));
    }

    @SneakyThrows
    public void updateAuthor(AuthorDto author) {
        String updateUrl = url + "/" + author.getId();
        String body = new ObjectMapper().writeValueAsString(author);
        test.context().setResponse(GenericApi.post(updateUrl, body));
    }

    @SneakyThrows
    public AuthorDto getAuthor(Long authorId) {
        String getUrl = url + "/" + authorId;
        test.context().setResponse(GenericApi.get(getUrl));
        return test.context().getResponse().body().as(AuthorDto.class);
    }

    @SneakyThrows
    public AuthorDto getAuthorByBookId(Long bookId) {
        String getUrl = url + "/authors/books/}" + bookId;
        test.context().setResponse(GenericApi.get(getUrl));
        return test.context().getResponse().body().as(AuthorDto.class);
    }

    @SneakyThrows
    public List<AuthorDto> getAuthors() {
        test.context().setResponse(GenericApi.get(url));
        return Arrays.asList(test.context().getResponse().body().as(AuthorDto[].class));
    }

    @SneakyThrows
    public void deleteAuthor(Long authorId) {
        String deleteUrl = url + "/" + authorId;
        test.context().setResponse(GenericApi.delete(deleteUrl));
    }
}
