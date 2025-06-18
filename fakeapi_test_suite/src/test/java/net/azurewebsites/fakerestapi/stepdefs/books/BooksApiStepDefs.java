package net.azurewebsites.fakerestapi.stepdefs.books;

import io.cucumber.java.en.Then;
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
                .setPublishDate("2023-10-01T00:00:00");

        test.context().setBook(book);
        test.api().books().addBook(book);
    }

    @When("a new book with missing mandatory fields is added")
    public void addInvalidBook() {
        BookDto book = new BookDto();

        book.setId(null)
                .setTitle("Sample Book")
                .setDescription("This is a sample book description.")
                .setExcerpt("This is an excerpt from the sample book.")
                .setPageCount(null)
                .setPublishDate(null);

        test.context().setBook(book);
        test.api().books().addBook(book);
    }

    @When("the book is updated")
    public void updateBook() {
        test.context().getBook()
                .setTitle("Updated Sample Book")
                .setDescription("This is an updated sample book description.")
                .setExcerpt("This is an updated excerpt from the sample book.")
                .setPageCount(400)
                .setPublishDate("2024-10-01T00:00:00");

        test.api().books().updateBook(test.context().getBook());
    }

    @When("a non-existing book with id {int} is updated")
    public void updateNonExistingBook(int id) {
        BookDto book = new BookDto();

        book.setId(id)
                .setTitle("Sample Book")
                .setDescription("This is a sample book description.")
                .setExcerpt("This is an excerpt from the sample book.")
                .setPageCount(300)
                .setPublishDate("2023-10-01T00:00:00");

        test.api().books().updateBook(book);
    }

    @When("the book is retrieved")
    public void getBook() {
        BookDto book = test.api().books().getBook((long)test.context().getBook().getId());
        test.context().setBook(book);
    }

    @When("a book with id {long} is retrieved")
    public void getBook(long id) {
        BookDto book = test.api().books().getBook(id);
        test.context().setBook(book);
    }

    @When("the book is deleted")
    public void deleteBook() {
        test.api().books().deleteBook((long)test.context().getBook().getId());
    }

    @When("a book with id {long} is deleted")
    public void deleteBook(long id) {
        test.api().books().deleteBook(id);
    }

    @When("all books are retrieved")
    public void getBooks() {
        test.context().setBooks(test.api().books().getBooks());
    }

    @Then("verify that the book details match the expected values")
    public void validateBook() {
        test.api().books().validate().validateBook(test.context().getBook());
    }

    @Then("verify that the books in the library are {long}")
    public void validateBook(long count) {
        test.api().books().validate().validateBooksCount(count);
    }
}
