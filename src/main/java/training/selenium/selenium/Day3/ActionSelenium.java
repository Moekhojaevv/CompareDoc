package training.selenium.selenium.Day3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSelenium {
	public static void main(String[] args) throws InterruptedException {

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
//		inputSerachBox.sendKeys("SELEnium");
//    wd.findElement(By.name("q")).sendKeys("SELEnium");
//		Thread.sleep(2000);
		Actions action=new  Actions(wd);
		action.keyDown(inputSerachBox,Keys.SHIFT);
		action.sendKeys(inputSerachBox,"selenium");
		action.keyUp(inputSerachBox,Keys.SHIFT);
		action.build().perform();
		Thread.sleep(2000);
		Robot rbt;
		try {
			rbt = new Robot();
			rbt.keyPress(KeyEvent.VK_BACK_SPACE);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
		System.out.println("End");
		
	}

//	WebElement element = driver.findElement(By strategy to identify element);
//	actions.keyDown(element, Keys.SHIFT);
//	actions.sendKeys(“TextToBeConvertAndSendInUpperCase”);
//	actions.keyUp(Keys.SHIFT);

}
