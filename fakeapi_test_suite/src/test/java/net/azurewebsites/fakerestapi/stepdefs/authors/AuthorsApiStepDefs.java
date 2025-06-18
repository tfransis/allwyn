package net.azurewebsites.fakerestapi.stepdefs.authors;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.azurewebsites.fakerestapi.authors.dto.AuthorDto;
import net.azurewebsites.fakerestapi.books.dto.BookDto;
import net.azurewebsites.fakerestapi.utils.Test;

public class AuthorsApiStepDefs {
    final Test test;

    public AuthorsApiStepDefs(Test test) {
        this.test = test;
    }

    @When("a new Author is added")
    public void addAuthor() {
        AuthorDto author = new AuthorDto();

        author.setId((int) ((Math.random() * (500000 - 3000)) + 3000))
                .setIdBook(1)
                .setFirstName("John")
                .setLastName("Doe");

        test.context().setAuthor(author);
        test.api().authors().addAuthor(author);
    }

    @When("a new author with missing mandatory fields is added")
    public void addInvalidAuthor() {
        AuthorDto author = new AuthorDto();

        author.setId(null)
                .setIdBook(null)
                .setFirstName("John")
                .setLastName("Doe");

        test.context().setAuthor(author);
        test.api().authors().addAuthor(author);
    }

    @When("the author is updated")
    public void updateAuthor() {
        test.context().getAuthor()
                .setIdBook(2)
                .setFirstName("New First Name")
                .setLastName("New Last Name");

        test.api().authors().updateAuthor(test.context().getAuthor());
    }

    @When("a non-existing author with id {int} is updated")
    public void updateNonExistingAuthor(int id) {
        AuthorDto author = new AuthorDto();

        author.setId(id)
                .setIdBook(1)
                .setFirstName("John")
                .setLastName("Doe");

        test.api().authors().updateAuthor(author);
    }

    @When("the author is retrieved")
    public void getAuthor() {
        BookDto book = test.api().books().getBook((long) test.context().getBook().getId());
        test.context().setBook(book);
    }

    @When("an author with id {long} is retrieved")
    public void getBook(long id) {
        BookDto book = test.api().books().getBook(id);
        test.context().setBook(book);
    }

    @When("the author is deleted")
    public void deleteBook() {
        test.api().books().deleteBook((long) test.context().getBook().getId());
    }

    @When("an author with id {long} is deleted")
    public void deleteBook(long id) {
        test.api().books().deleteBook(id);
    }

    @When("all authors are retrieved")
    public void getBooks() {
        test.context().setBooks(test.api().books().getBooks());
    }

    @Then("verify that the author details match the expected values")
    public void validateBook() {
        test.api().books().validate().validateBook(test.context().getBook());
    }

    @Then("verify that the authors in the library are {long}")
    public void validateBook(long count) {
        test.api().books().validate().validateBooksCount(count);
    }
}
