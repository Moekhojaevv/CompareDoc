package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class First2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("device", "Android");
		capability.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capability.setCapability(CapabilityType.VERSION, "11.0");
		capability.setCapability("deviceName", "DRGID18092302782");
		capability.setCapability("platformName", "Android");
		AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capability);
		Thread.sleep(2000);
		driver.navigate().to("https://google.com");
		Thread.sleep(2000);
		WebElement inputSerachBox = driver.findElementByXPath("//*[@name='q']");
		inputSerachBox.sendKeys("SELEnium");
		inputSerachBox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		System.out.println("CURRENT URL=" + driver.getCurrentUrl());
		System.out.println("CURRENT TITLE=" + driver.getTitle());
//		Set<String> handles = driver.getContextHandles();
//		for(String hand:handles) {
//			System.out.println(hand);
//		}
//		driver.context("CHROMIUM");
//		
		System.out.println("TEXT="+driver.findElement(By.xpath("//*[contains(text(),'automates browsers. That')]")).getText());
	}

}
