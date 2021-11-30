Feature: Google Search

#	Scenario: Google 
#		Given Navigate to Google Search Application
#		When I enter search keyword 
#		Then Click on First Search Result
#		And Close browser


Scenario Outline: Google Test dat driven
#		Given Navigate to Google Search Application
		When I enter search keyword "<Keyword>"
#		Then Click on First Search Result
#		And Close browser
		
		Examples:
		|Keyword |Column2|
		|Selenium|asdasd|
		|Jira    |asda|
			