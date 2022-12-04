Feature: Order food from Swiggy website

Scenario: A user should be able to order food from Swiggy website successfully
Given a user is on the landing page of Swiggy
When he enters delivery location as Bangalore and hit enter
And he clicks on first search result under restaurants
And he clicks on Add button under Top Picks of that restaurant
And he clicks on Add Item buttom if customise pop up displayed
And he clicks on Checkout button under Cart
Then he must be able to order food successfully