package src_eBayProject.POM;



import java.awt.RenderingHints.Key;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;

// This page will have basic Home Page function
// Variables are defined as private and static and , methods are defined as public static
public class Home_page {
	
	private static By SearchTF =By.id("com.ebay.mobile:id/search_box");
	private static By SearchBoxTF =By.id("com.ebay.mobile:id/search_src_text");
	private static By SearchCTBT =By.id("com.ebay.mobile:id/search_complete_icon"); 
	private static By BuyNowBT =By.id("com.ebay.mobile:id/button_bin");
	
	// Review button via xPath
	private static By ReviewBT =By.xpath("//*[contains(@id,'com.ebay.mobile:id/take_action')]");
	private static By ProceedBT =By.xpath("//*[contains(@id,'com.ebay.mobile:id/proceedToPay')]");
	
	//private static By SearchCTBT =By.xpath (“//android.widget.IamgeView[contains(@resource-id,’search_complete_icon)]”));
			//id("com.ebay.mobile:id/search_complete_icon");
	
	
	public static void searchProduct(AndroidDriver driver, String productname) throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(SearchTF).click();
		driver.findElement(SearchBoxTF).sendKeys("wipro led");
		Thread.sleep(5000);
		driver.pressKeyCode(66);
		Thread.sleep(5000);
		List<WebElement> productList = driver.findElements(By.id("com.ebay.mobile:id/cell_collection_item"));
		productList.get(0).click();
	}
	
	public static void selectProduct(AndroidDriver driver) throws InterruptedException{
		List<WebElement> productList = driver.findElements(By.id("com.ebay.mobile:id/cell_collection_item"));
		productList.get(0).click();
		Thread.sleep(5000);
	}
	
	public static void buyProduct(AndroidDriver driver) throws InterruptedException{
		System.out.println( "User is navigating to settings page via Home button ");
		driver.findElement(BuyNowBT).click();
		Thread.sleep(5000);
		//Clicking review button via xPath
		driver.findElement(ReviewBT).click();	
		Thread.sleep(5000);
		driver.findElement(ProceedBT).click();	
	}


}
