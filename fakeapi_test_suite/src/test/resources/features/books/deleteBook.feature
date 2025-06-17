Feature: Delete A Book

  Scenario: Delete a book from the library after it has been added
    Given a new book is added
    And verify that the response status code is 200
    When the book is deleted
    Then verify that the response status code is 200

  Scenario: Try to delete a book by providing an invalid ID
    When a book with id 1111111111111 is deleted
    Then verify that the response status code is 400

  Scenario: Try to delete a book by providing a non-existing ID
    When a book with id 11111111 is deleted
    Then verify that the response status code is 404
