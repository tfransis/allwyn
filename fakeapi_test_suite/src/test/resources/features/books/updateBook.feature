@Books
Feature: Update a book in the Library

  Scenario: Update an existing book in the library
    Given a new book is added
    When the book is updated
    Then verify that the response status code is 200
    And verify that the book details match the expected values

  Scenario: Try to update an existing book by removing mandatory fields
    Given a new book is added
    When the book is updated by removing the mandatory fields
    Then verify that the response status code is 400

  Scenario: Try to update a non-existing book
    When a non-existing book with id 100000 is updated
    Then verify that the response status code is 404
    