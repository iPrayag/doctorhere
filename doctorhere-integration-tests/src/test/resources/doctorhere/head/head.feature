Feature: Head

  Scenario: a few cukes
    Given I have 42 cukes in my head
    When I wait 1 hour
    Then my head should growl
