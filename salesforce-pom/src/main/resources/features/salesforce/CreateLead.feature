Feature: Create Lead in Salesforce

  As a Salesforce user
  I want to create a new lead
  So that I can manage potential customers effectively


  Scenario Outline: Create a new lead with valid details
    When The user navigates to the leads tab
    And The user clicks on the new button for leads
    And The user enters the lead details:
      | Salutation | <Salutation>       |
      | FirstName  | <FirstName>        |
      | LastName   | <LastName>         |
      | Company    | <Company>          |
    And The user clicks the save button for leads
    Then A new lead should be created with frist name "<FirstName>" last name "<LastName>"

  Examples:
    | Salutation | FirstName | LastName | Company       |
    | Mr.        | John      | Doe      | Example Corp  |
    | Ms.        | Jane      | Smith    | Tech World    |
