@Books
Feature: Add Book to the Library

  Scenario: Add a new book to the library
    When a new book is added
    Then verify that the response status code is 200
    And verify that the book details match the expected values

  Scenario: Try to add a new book with missing mandatory fields
    When a new book with missing mandatory fields is added
    Then verify that the response status code is 400

  Scenario: Try to add an existing book to the library
    When a book with id 1 is added
    Then verify that the response status code is 409
