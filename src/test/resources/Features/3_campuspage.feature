Feature: Campus Inquiry Form Submission

  Background: 
    Given the user is on the campus inquiry page

  Scenario: Filling the Campus Inquiry Form
    When the user enters their personal and professional details into the form using "<row_index>"
    And the user submits the campus inquiry form
    Then a confirmation message should be displayed if the submission is successful
    And an error message should be displayed if there are any validation errors
    
    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |