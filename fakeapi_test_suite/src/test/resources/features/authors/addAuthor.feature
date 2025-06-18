@Authors
Feature: Add Author to the Library

  Scenario: Add a new author to the library
    When a new author is added
    Then verify that the response status code is 200
    And verify that the author details match the expected values

  Scenario: Try to add a new author with missing mandatory fields
    When a new author with missing mandatory fields is added
    Then verify that the response status code is 400

  Scenario: Try to add an existing author to the library
    When an author with id 1 is added
    Then verify that the response status code is 409
