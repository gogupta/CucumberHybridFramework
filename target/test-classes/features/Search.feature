Feature: Search Functionality

Scenario: User searches a valid product
Given User opens the Application
When User enters a vaild product "HP" into search box field
And User clicks on Search button
Then User should get a valid product displayed in search results

Scenario: User searches a invalid product
Given User opens the Application
When User enters a invaild product "Honda" into search box field
And User clicks on Search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens the Application
When User dont enters any product "Honda" into search box field
And User clicks on Search button
Then User should get a message about no product matching

