package appium;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class Calculator {

public static void main(String[] args) throws MalformedURLException, InterruptedException {

DesiredCapabilities dc = new DesiredCapabilities();

dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
//find from your mobile device, by going to the setting option and then to the “about Phone” option
dc.setCapability(MobileCapabilityType.PLATFORM, "Android");
dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
dc.setCapability("appPackage", "com.android.calculator2");
//to get this, go to the playstore, check for apk info app and install it, use it to find the app package for the application under test.
dc.setCapability("appActivity", "com.android.calculator2.Calculator");
//using the same app apk info, you can find the appActivity too

URL url = new URL("http://127.0.0.1:4723/wd/hub");
//here the “http://127.0.0.1:” is your IP on the system, and port “4723” that you can see from the appium server

AndroidDriver driver = new AndroidDriver(url, dc);

System.out.println("Application started");

}

}