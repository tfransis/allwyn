package net.azurewebsites.fakerestapi.utils.factories;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.azurewebsites.fakerestapi.authors.dto.AuthorDto;
import net.azurewebsites.fakerestapi.books.dto.BookDto;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class ContextFactory {
    Response response;
    BookDto book;
    List<BookDto> books;
    AuthorDto author;
    List<AuthorDto> authors;
}
