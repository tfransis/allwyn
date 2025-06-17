Feature: Get A Book

  Scenario: Get a book from the library after it has been added
    Given a new book is added
    And verify that the response status code is 200
    When the book is retrieved
    Then verify that the response status code is 200

  Scenario: Try to get a book by providing an invalid ID
    When a book with id 1111111111111 is retrieved
    Then verify that the response status code is 400

  Scenario: Try to get a book by providing a non-existing ID
    When a book with id 11111111 is retrieved
    Then verify that the response status code is 404
