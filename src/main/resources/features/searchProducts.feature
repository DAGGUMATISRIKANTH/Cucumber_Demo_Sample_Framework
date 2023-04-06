Feature: Search and place the order for products

Scenario: Search Experience for products search in both home page and offers page
Given User is on GreenCart landing page
When User searched for shortname "Tom" and extracting actual name of product
Then User searched for same shortname "Tom" in offers page 
And validate product name in offer page matches with landing page

