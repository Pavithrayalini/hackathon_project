Feature: Enterprise Solutions Navigation
    
  Scenario: Navigating to Solutions
  	Given the user has accessed the enterprise solutions section
  	When the user selects the Solutions option
    Then the solutions overview should be displayed

  Scenario: Accessing Campus Solutions
    When the user clicks on the Coursera for Campus option
    Then the details for campus solutions should be presented
