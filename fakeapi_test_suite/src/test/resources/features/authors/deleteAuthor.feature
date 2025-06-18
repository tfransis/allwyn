@Authors
Feature: Delete An Author

  Scenario: Delete an author from the library after it has been added
    Given a new author is added
    And verify that the response status code is 200
    When the author is deleted
    Then verify that the response status code is 200

  Scenario: Try to delete an author by providing an invalid ID
    When an author with id 1111111111111 is deleted
    Then verify that the response status code is 400

  Scenario: Try to delete an author by providing a non-existing ID
    When an author with id 11111111 is deleted
    Then verify that the response status code is 404
