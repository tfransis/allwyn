@Authors
Feature: Update an author in the Library

  Scenario: Update an existing author in the library
    Given a new author is added
    When the author is updated
    Then verify that the response status code is 200
    And verify that the author details match the expected values

  Scenario: Try to update an existing author by removing mandatory fields
    Given a new author is added
    When the author is updated by removing the mandatory fields
    Then verify that the response status code is 400

  Scenario: Try to update a non-existing author
    When a non-existing author with id 100000 is updated
    Then verify that the response status code is 404
    