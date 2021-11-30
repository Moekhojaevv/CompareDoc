Feature: Validation Test

Scenario Outline: Validation Test with different Ages data
		Given Navigate to Application
		When I enter "<FirstName>","<LastName>","<Age>","<Country>" and "<Notes>"
		And Click on Submit Button
		Then Validate for "<SuccessOrFailureScenario>"
		And Close Application
		
		Examples:
		|FirstName |LastName|Age|Country				|Notes					|SuccessOrFailureScenario|
		|ABC			 |XYZ			|		|United Kingdom	|Test Valid Age |blankAge					 			 |
		|ABC			 |XYZ			|17	|United Kingdom	|Test Valid Age |AgeLess18				 			 |
		|ABC			 |XYZ			|81	|United Kingdom	|Test Valid Age |AgeMore80				 			 |
		|ABC			 |XYZ			|18	|United Kingdom	|Test Valid Age | 			 								 |
		

			