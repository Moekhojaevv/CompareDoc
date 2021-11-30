package training.selenium.selenium;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//https://artoftesting.com/samplesiteforselenium
public class ApplicationLogger {

	public static void main(String[] args) throws InterruptedException {
		PropertyConfigurator.configure("E:\\EclipseWorkspace\\Training\\SeleniumTest\\src\\log4j.properties");
		Logger log=Logger.getLogger("devpinoyLogger");
		log.info("Hello selenium");
		System.setProperty("webdriver.chrome.driver",
				"E:\\EclipseWorkspace\\Training\\SeleniumTest\\Drivers\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		Thread.sleep(2000);
		wd.get("https://www.google.com/");
//		Thread.sleep(2000);
//		WebElement inputSerachBox = wd.findElement(By.name("w"));
//		inputSerachBox.sendKeys("SELEnium");
//		Thread.sleep(2000);
//		System.out.println("INPUT ENABLED=" + inputSerachBox.isEnabled());
//		System.out.println("INPUT ENABLED=" + inputSerachBox.isDisplayed());
//
//		wd.findElement(By.name("btnK")).click(); // click the result
//		Thread.sleep(2000); // wd.findElement(By.linkText("Selenium")).click();
//		System.out.println("CURRENT URL=" + wd.getCurrentUrl());
//		System.out.println("CURRENT TITLE=" + wd.getTitle());
//		System.out.println("TEXT="+wd.findElement(By.xpath("//span[contains(text(),'automates browsers. That')]")).getText());
		wd.quit();
		log.debug("Hello selenium Closed");
	}

}