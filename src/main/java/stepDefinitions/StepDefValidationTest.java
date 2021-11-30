package stepDefinitions;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefValidationTest {
	WebDriver wd;

	@Given("^Navigate to Application$")
	public void navigate_to_Application() throws Throwable {
		String path = new File("src/main/resources/drivers/chromedriver.exe").getAbsolutePath();
		System.out.println("navigate_to_Google_Search_Application");
		System.setProperty("webdriver.chrome.driver", path);
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		Thread.sleep(2000);
		// Navigating to URL
		wd.get("https://testpages.herokuapp.com/styled/validation/input-validation.html");
		Thread.sleep(2000);

	}

	@When("I enter {string},{string},{string},{string} and {string}")
	public void i_enter_and(String sFName, String sLName, String sAge, String sCountry, String sNotes) {
		WebElement fName = wd.findElement(By.id("firstname"));
		WebElement lName = wd.findElement(By.id("surname"));
		WebElement age = wd.findElement(By.id("age"));
		WebElement country = wd.findElement(By.id("country"));
		WebElement notes = wd.findElement(By.id("notes"));
		fName.sendKeys(sFName);
		lName.sendKeys(sLName);
		age.sendKeys(sAge);
		new Select(country).selectByVisibleText(sCountry);
		notes.sendKeys(sNotes);
	}

	@When("^Click on Submit Button$")
	public void clickonSubmitButton() throws Throwable {
		WebElement submit = wd.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
	}
	@Then("Validate for {string}")
	public void validate_for(String sCase) {
		WebElement age ;
		switch(sCase) {
		case "surnamevalidation":
			Assert.assertEquals(wd.findElement(By.name("surnamevalidation")).getText(),"Surname provided is too short");
			break;
		case "blankAge":
			age = wd.findElement(By.id("age"));
			System.out.println("validationMessage="+age.getAttribute("validationMessage"));
			Assert.assertEquals(age.getAttribute("validationMessage"),"Please fill out this field.");
			break;
		case "AgeLess18":
			age = wd.findElement(By.id("age"));
			System.out.println("validationMessage="+age.getAttribute("validationMessage"));
			Assert.assertEquals(age.getAttribute("validationMessage"),"Value must be greater than or equal to 18.");
			break;
		case "AgeMore80":
			age = wd.findElement(By.id("age"));
			System.out.println("validationMessage="+age.getAttribute("validationMessage"));
			Assert.assertEquals(age.getAttribute("validationMessage"),"Value must be less than or equal to 80.");
			break;
			
			
		}
		
	}

	@Then("^Close Application$")
	public void close_browser() throws Throwable {
		try{
			wd.quit();
		}catch(RuntimeException e) {
				
		}
	}

}
