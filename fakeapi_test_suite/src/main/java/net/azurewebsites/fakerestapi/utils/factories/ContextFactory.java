package net.azurewebsites.fakerestapi.utils.factories;

import io.restassured.response.Response;
import lombok.Data;
import lombok.experimental.Accessors;
import net.azurewebsites.fakerestapi.books.dto.BookDto;

import java.util.List;

@Data
@Accessors(chain = true)
public class ContextFactory {
    Response response;
    BookDto book;
    List<BookDto> books;
}
