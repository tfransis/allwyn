package net.azurewebsites.fakerestapi.stepdefs.books;

import io.cucumber.java.en.When;
import net.azurewebsites.fakerestapi.books.dto.BookDto;
import net.azurewebsites.fakerestapi.utils.Test;

public class BooksApiStepDefs {
    final Test test;

    public BooksApiStepDefs(Test test) {
        this.test = test;
    }

    @When("a new book is added")
    public void addBook() {
        BookDto book = new BookDto();

        book.setId((int) ((Math.random() * (500000 - 3000)) + 3000))
                .setTitle("Sample Book")
                .setDescription("This is a sample book description.")
                .setExcerpt("This is an excerpt from the sample book.")
                .setPageCount(300)
                .setPublishDate("2023-10-01");

        test.context().setBook(book);
        test.api().books().addBook(book);
    }

    @When("a book is updated")
    public void updateBook() {
        test.context().getBook()
                .setTitle("Updated Sample Book")
                .setDescription("This is an updated sample book description.")
                .setExcerpt("This is an updated excerpt from the sample book.")
                .setPageCount(400)
                .setPublishDate("2024-10-01");

        test.api().books().updateBook(test.context().getBook());
    }

    @When("a book with id {int} is retrieved")
    public void getBook(int id) {
        BookDto book = test.api().books().getBook(id);
        test.context().setBook(book);
    }

    @When("verify that the response status code is {int}")
    public void verifyStatusCode(int id) {
        BookDto book = test.api().books().getBook(id);
        test.context().setBook(book);
    }
}
