package training.selenium.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//https://artoftesting.com/samplesiteforselenium
public class Application {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello selenium");
		// 1.specify your webdriver path
		// FF=gecko
		// FirefoxDriver
		// IE=ie
		// InternetExplorerDriver
		System.setProperty("webdriver.chrome.driver",
				"E:\\EclipseWorkspace\\Training\\SeleniumTest\\Drivers\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		Thread.sleep(2000);
		// Navigating to URL
		wd.get("https://www.google.com/");
		Thread.sleep(2000);
		WebElement inputSerachBox = wd.findElement(By.name("q"));
		// Input Search text name=q
		inputSerachBox.sendKeys("SELEnium");
//        wd.findElement(By.name("q")).sendKeys("SELEnium");
		Thread.sleep(2000);
		System.out.println("INPUT ENABLED=" + inputSerachBox.isEnabled());
		System.out.println("INPUT ENABLED=" + inputSerachBox.isDisplayed());

		wd.findElement(By.name("btnK")).click(); // click the result
		Thread.sleep(2000); // wd.findElement(By.linkText("Selenium")).click();
//		wd.findElement(By.xpath("//h3[@class='LC20lb DKV0Md'][text()='Selenium']")).click();
//		Thread.sleep(5000);
		System.out.println("CURRENT URL=" + wd.getCurrentUrl());
		System.out.println("CURRENT TITLE=" + wd.getTitle());
		System.out.println("TEXT="+wd.findElement(By.xpath("//span[contains(text(),'automates browsers. That')]")).getText());
		//
//        
//        wd.close();
		
		List<WebElement> listSearch=wd.findElements(By.xpath("//div[@class='VwiC3b yXK7lf MUxGbd yDYNvb lyLwlc lEBKkf']/span"));
		System.out.println(listSearch.size());
		/*
		 * for(int i=0;i<listSearch.size();i++) {
		 * System.out.println(listSearch.get(i).getText()); }
		 */
		
		for(WebElement we:listSearch) {
			System.out.println(we.getText());
		}
		wd.quit();
		System.out.println("selenium Closed");
	}

}