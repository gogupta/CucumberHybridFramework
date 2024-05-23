Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field
And User has enters valid password <password> into password field
And User clicks on Login Button
Then User should get successfully logged in
Examples:
|username							 |password|
|govindgupta1@gmail.com|12345		|
|govindgupta2@gmail.com|12345		|
|govindgupta3@gmail.com|12345		|
 
Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User has enters invalid password "12345678" into password field
And User clicks on Login Button
Then User should get proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password credentials
Given User navigates to login page
When User enters valid email address "govindgupta2209@gmail.com" into email field
And User has enters invalid password "123456789" into password field
And User clicks on Login Button
Then User should get proper warning message about credentials mismatch

Scenario: Login with invalid email and invalid password credentials
Given User navigates to login page
When User enters invalid email address into email field
And User has enters valid password "12345" into password field
And User clicks on Login Button
Then User should get proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login Button
Then User should get proper warning message about credentials mismatch