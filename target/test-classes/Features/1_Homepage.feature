Feature: Search for a course

  Scenario: Searching for a course
  	Given the user has navigated to the homepage
    When the user enters a course name into the search bar
    And the user clicks the search button
    Then the search results should display courses related to the entered name

  Scenario: Applying filters to search
    When the user selects the English language filter
    And the user selects the Beginner level filter
    Then the search results should update to show only English beginner courses

  Scenario: Selecting a course
    When the user views the list of courses
    Then the user should be able to select a course from the list

  Scenario: Displaying course details
    When the user clicks on a course
    Then the course title, ratings, and hours of learning should be displayed

  Scenario: Counting available languages
    When the user clicks on the see all languages button
    Then the total number of languages and languages name should be displayed

  Scenario: Counting available levels
    When the user views the list of levels
    Then the total number of levels and the levels should be displayed