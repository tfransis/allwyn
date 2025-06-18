package net.azurewebsites.fakerestapi.stepdefs.authors;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.azurewebsites.fakerestapi.authors.dto.AuthorDto;
import net.azurewebsites.fakerestapi.utils.Test;
import net.azurewebsites.fakerestapi.utils.Utilities;

public class AuthorsApiStepDefs {
    final Test test;

    public AuthorsApiStepDefs(Test test) {
        this.test = test;
    }

    @When("a new author is added")
    public void addAuthor() {
        AuthorDto author = new AuthorDto();

        author.setId(Utilities.getRandomNumber(1000, 500000))
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

    @When("an author with id {int} is added")
    public void addAuthor(int id) {
        AuthorDto author = new AuthorDto();

        author.setId(id)
                .setIdBook(1)
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

    @When("the author is updated by removing the mandatory fields")
    public void updateAuthorInvalid() {
        test.context().getAuthor()
                .setIdBook(null)
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
        AuthorDto author = test.api().authors().getAuthor((long) test.context().getAuthor().getId());
        test.context().setAuthor(author);
    }

    @When("an author with id {long} is retrieved")
    public void getAuthor(long id) {
        AuthorDto author = test.api().authors().getAuthor(id);
        test.context().setAuthor(author);    }

    @When("the author is deleted")
    public void deleteAuthor() {
        test.api().authors().deleteAuthor((long) test.context().getAuthor().getId());
    }

    @When("an author with id {long} is deleted")
    public void deleteAuthor(long id) {
        test.api().authors().deleteAuthor(id);
    }

    @When("all authors are retrieved")
    public void getAuthors() {
        test.context().setAuthors(test.api().authors().getAuthors());
    }

    @When("authors with book id {int} are retrieved")
    public void getAuthors(int bookId) {
        test.context().setAuthors(test.api().authors().getAuthorsByBookId(bookId));
    }

    @Then("verify that all authors have book id {int}")
    public void validateAuthorsBook(int bookId) {
        test.api().authors().validate().validateAuthorsBook(bookId);
    }

    @Then("verify that the author details match the expected values")
    public void validateAuthor() {
        test.api().authors().validate().validateAuthor(test.context().getAuthor());
    }

    @Then("verify that the authors in the library are {long}")
    public void validateAuthorsCount(long count) {
        test.api().authors().validate().validateAuthorsCount(count);
    }
}
