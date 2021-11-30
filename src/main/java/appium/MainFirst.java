package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MainFirst {

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
		/*
		 * Set<String> handles = driver.getContextHandles(); for(String hand:handles) {
		 * System.out.println(hand); } driver.context("CHROMIUM");
		 */
		Thread.sleep(2000);
	}

}