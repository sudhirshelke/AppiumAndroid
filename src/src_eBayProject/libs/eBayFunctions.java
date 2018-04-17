package src_eBayProject.libs;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import src_eBayProject.POM.Home_page;
import src_eBayProject.POM.Login_page;


public class eBayFunctions {
WebDriver driver;

@BeforeClass
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("BROWSER_NAME", "Android");
	capabilities.setCapability("VERSION", "6.0.1"); 
	capabilities.setCapability("deviceName","trlte");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("appPackage", "com.ebay.mobile");
	
	// This package name of your app (you can get it from apk info app)
	// This is Launcher activity of your app (you can get it from apk info app)
	capabilities.setCapability("appActivity","com.ebay.mobile.activities.MainActivity"); 
	
	//Create AndroidDriver instance and connect to the Appium server
	//It will launch the eBay App in Android Device using the configurations specified in Desired Capabilities
	driver =  new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS); 
}

/* Flow


*/
@Test

/**
* @Desc: Function will sign In user
* @return true/false
* @throws Exception
* @Variables: NA
* @author Sudhir Shelke
* @date : Created_date: 17/April/2018 Ex: signInFunctions())
*/
public void signInFunctions() throws Exception {
		Login_page.signInUser((AndroidDriver) driver, "sudhirshelke12983@gmail.com", "Avayaa123");
		System.out.println( "Verifying user signed or not??  ");
		Login_page.verifySignInUser((AndroidDriver) driver);
}

public void searchBuyProductFunctions() throws Exception {
	System.out.println( "Searching for product...Please wait  ");
	Home_page.searchProduct((AndroidDriver)driver, "wipro led bulbs");
	System.out.println( "Selecting product...Please wait  ");
	Home_page.selectProduct((AndroidDriver) driver);
	System.out.println( "Buying product...Please wait  ");
	Home_page.buyProduct((AndroidDriver) driver);
}

public void signOutFunctions() throws Exception {
	
	Login_page.signOutUser((AndroidDriver) driver);
	System.out.println( "Verifying signing out  ");
	Login_page.verifySignOutUser((AndroidDriver) driver);
}
  

@AfterClass
public void teardown(){
	//close the driver
	driver.quit();
}
}
