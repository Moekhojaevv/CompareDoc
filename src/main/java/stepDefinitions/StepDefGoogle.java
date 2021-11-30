package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefGoogle {
	WebDriver wd ;
	@Given("^Navigate to Google Search Application$")
	public void navigate_to_Google_Search_Application() throws Throwable {
		System.out.println("navigate_to_Google_Search_Application");System.setProperty("webdriver.chrome.driver",
				"E:\\EclipseWorkspace\\Training\\SeleniumTest\\Drivers\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		Thread.sleep(2000);
		// Navigating to URL
		wd.get("https://www.google.com/");
		Thread.sleep(2000);
		
	}
	@When("I enter search keyword {string}")
	public void i_enter_search_keyword(String string) {
	    System.out.println("Passed from Examples:"+string);
	}
	@When("^I enter search keyword$")
	public void i_enter_search_keyword() throws Throwable {
		WebElement inputSerachBox = wd.findElement(By.name("q"));
		// Input Search text name=q
		inputSerachBox.sendKeys("SELEnium");
		Thread.sleep(2000);
		System.out.println("INPUT ENABLED=" + inputSerachBox.isEnabled());
		System.out.println("INPUT ENABLED=" + inputSerachBox.isDisplayed());
	}

	@Then("^Click on First Search Result$")
	public void click_on_First_Search_Result() throws Throwable {
		wd.findElement(By.name("btnK")).click(); // click the result
		Thread.sleep(2000);
		System.out.println("CURRENT URL=" + wd.getCurrentUrl());
		System.out.println("CURRENT TITLE=" + wd.getTitle());
		System.out.println("TEXT="+wd.findElement(By.xpath("//span[contains(text(),'automates browsers. That')]")).getText());
	}

	@Then("^Close browser$")
	public void close_browser() throws Throwable {
		try{
			wd.quit();
		}catch(RuntimeException e) {
//			e.printStackTrace();
		}
	}
}
