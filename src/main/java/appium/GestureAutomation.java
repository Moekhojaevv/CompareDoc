package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
public class GestureAutomation {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String sFile = "C:\\Users\\ankle\\Downloads\\ApiDemos-debug.apk";

		// To create an object of Desired Capabilities
		DesiredCapabilities capability = new DesiredCapabilities();
		// OS Name
		capability.setCapability("device", "Android");
		capability.setCapability(CapabilityType.BROWSER_NAME, "");
		// Mobile OS version. In My case its running on Android 4.2
		capability.setCapability(CapabilityType.VERSION, "11.0");
		capability.setCapability("app", sFile);
		// To Setup the device name
		capability.setCapability("deviceName", "Pixel 2 API 30 2");
		capability.setCapability("platformName", "Android");
		// set the package name of the app
		capability.setCapability("app-package", "io.appium.android.apis");
		// set the Launcher activity name of the app
		capability.setCapability("app-activity", ".ApiDemos");
		// driver object with new Url and Capabilities
		AppiumDriver driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
		Thread.sleep(2000);
		TouchAction touch=new TouchAction(driver);
		List<MobileElement> listElement=(List<MobileElement>)driver.findElementsById("android:id/text1");
		////TAP
//		touch.tap(tapOptions().withElement(element(listElement.get(4)))).perform();
		/////TAP With Coordinates
//		touch.tap(point(112,1566))
//		.waitAction(waitOptions(Duration.ofSeconds(10)))
//		.perform();

		///Long Tap/Press
//		touch.press(element(listElement.get(4)))
//		.waitAction(waitOptions(Duration.ofSeconds(10)))
//		.release()
//		.perform();
////		
////		Horizontal swipe
//		touch.press(point(6,648))
//		.waitAction(waitOptions(Duration.ofSeconds(5)))
//		.moveTo(point(860,648))
//		.release()
//		.perform();
//		
////		Vertical swipe		
//		touch.press(point(6,648))
//		.waitAction(waitOptions(Duration.ofSeconds(5)))
//		.moveTo(point(6,1572))
//		.release()
//		.perform();
//		
//		touch.press(point(400,16))
//		.waitAction(waitOptions(Duration.ofSeconds(5)))
//		.moveTo(point(6,1572))
//		.release()
//		.perform();

		touch.press(element(listElement.get(7)))
		.waitAction(waitOptions(Duration.ofSeconds(5)))
		.moveTo(element(listElement.get(0)))
		.release()
		.perform();
		
		Thread.sleep(2000);
	}

}