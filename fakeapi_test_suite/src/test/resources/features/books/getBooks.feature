Feature: Get All Books from the Library

  Scenario: Get all books that have been added to the library
    When all books are retrieved
    Then verify that the response status code is 200
    And verify that the books in the library are 200