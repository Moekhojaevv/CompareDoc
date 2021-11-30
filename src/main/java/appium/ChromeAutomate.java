package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
public class ChromeAutomate {

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
		
		List<MobileElement> listElement=(List<MobileElement>)driver.findElementsById("android:id/text1");
		
		TouchAction touch1=new TouchAction(driver);
		touch1.tap(element(listElement.get(0)))
		.waitAction(waitOptions(Duration.ofSeconds(3)))
		.release()
		.waitAction(waitOptions(Duration.ofSeconds(3)));
		
		TouchAction touch2=new TouchAction(driver);
		touch2.tap(element(listElement.get(4)))
		.waitAction(waitOptions(Duration.ofSeconds(3)))
		.release()
		.waitAction(waitOptions(Duration.ofSeconds(3)));
		
		TouchAction touch3=new TouchAction(driver);
		touch2.tap(element(listElement.get(6)))
		.waitAction(waitOptions(Duration.ofSeconds(3)))
		.release()
		.waitAction(waitOptions(Duration.ofSeconds(3)));
		
		MultiTouchAction multi=new MultiTouchAction(driver);
		multi.add(touch1)
		.add(touch2)
//		.add(touch3)
		.perform();
		Thread.sleep(2000);
	}

}