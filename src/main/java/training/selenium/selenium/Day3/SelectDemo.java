package training.selenium.selenium.Day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//https://artoftesting.com/samplesiteforselenium
public class SelectDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello selenium");
		System.setProperty("webdriver.chrome.driver",
				"E:\\EclipseWorkspace\\Training\\selenium\\Drivers\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		Thread.sleep(2000);
		// Navigating to URL
		wd.get("https://artoftesting.com/samplesiteforselenium");
		Thread.sleep(2000);
		WebElement selectDD = wd.findElement(By.id("testingDropdown"));
		Select sel=new Select(selectDD);
		sel.selectByIndex(2);//Manual Testing
		sel.selectByValue("Database");//Database by value
		sel.selectByVisibleText("Automation Testing");//Automation testing by visible text
		List<WebElement> listSearch=sel.getOptions();
		for(WebElement we:listSearch) {
			System.out.println("TEXT="+we.getText());
			System.out.println("VALUE="+we.getAttribute("value"));
		}
		wd.quit();
		System.out.println("selenium Closed");
	}

}