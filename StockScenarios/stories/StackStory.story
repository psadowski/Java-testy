Scenario: Stack Push
Given a null stack,
When pushed a value 5,
Then an exception is thrown.

Scenario: Stack Pop
Given a null stack,
When poped a value,
Then an exception is thrown.

Scenario: Stack Top
Given a not null stack,
When user get top,
Then a value should be returned. 
