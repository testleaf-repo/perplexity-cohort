Feature: Create Opportunity in Salesforce 

	As a Salesforce user
  I want to create a new opportunity
  So that I can manage potential customers effectively


Scenario Outline: Create a new opportunity with valid details 
	When The user navigates to the opportunity tab 
	And The user clicks on the new button for opportunity
	And The user enters the opportunity details: 
		| OpportunityName | <OpportunityName> |
		| CloseDate  | <CloseDate>      	  |
		| Stage  	 | <Stage>        	 	  |
	And The user clicks the save button for opportunity
	Then A new opportunity should be created with opportunity name "<OpportunityName>" 
	
	Examples: 
		| OpportunityName | CloseDate | Stage 		 |
		| John       	  | 28/05/2025| Prospecting  |
		| Jane       	  | 29/05/2025| Qualification|
