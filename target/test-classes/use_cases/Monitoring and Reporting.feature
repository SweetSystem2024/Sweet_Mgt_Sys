Feature: Monitoring and Reporting

Actor: Admin 

Scenario: Admin or store owner or raw material supplier can generate product's names report with their sales details
	Given that the admin or store owner or raw material supplier is logged in
	And there are products in the store
	Then the report can be generated
	And the report is generated
	
	Scenario: Admin or store owner or raw material supplier can generate the best selling product
	
	Given that the admin or store owner or raw material supplier is logged in
	And there are products in the store
	And the admin decide which the Best selling product
  Then I should see a confirmation message "the Best selling product is 'cake'" "
 
 
	Scenario: Admin can Gather and display statistics on registered users by City
		Given that the admin is logged in
	 And there are a users deal with our store
	 Then the admin should view the users which is their city'Nablus'
	 Then the admin should view the users which is their city'Jenin'
	 
	 
	