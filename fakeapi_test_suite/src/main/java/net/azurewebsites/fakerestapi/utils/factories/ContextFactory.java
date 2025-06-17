package net.azurewebsites.fakerestapi.utils.factories;

import io.restassured.response.Response;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.UtilityClass;
import net.azurewebsites.fakerestapi.books.dto.BookDto;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class ContextFactory {
    Response response;
    BookDto book;
    List<BookDto> books;
}
