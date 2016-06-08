Scenario: User searches for a single step
 
Given user is on Home page
When user pass correct login data
Then succes flash is shown

Given user is on Home page
When user pass invalid login data
Then error flash is shown
