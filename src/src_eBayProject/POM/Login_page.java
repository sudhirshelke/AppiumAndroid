package src_eBayProject.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

// This page will have basic login function
public class Login_page {
	
	private static By homeBtn= By.id("com.ebay.mobile:id/home");
	private static By SettingsBtn= By.name("Settings");
	private static By SignOutBtn= By.name("Sign out");
	private static By signIN =By.id("com.ebay.mobile:id/logo");
	private static By usernameTF =By.id("com.ebay.mobile:id/edit_text_username");
	private static By passwordTF =By.id("com.ebay.mobile:id/edit_text_password");
	private static By SearchTF =By.id("com.ebay.mobile:id/edit_text_search_box");
	private static By signInBtn= By.id("com.ebay.mobile:id/button_sign_in");
	private static By denyBtn= By.id("com.ebay.mobile:id/button_google_deny");
	
/**
* @Desc: Sign In user with the help of valid UserName & Password
* @return true/false
* @throws Exception
* @Variables: UserName,Password
* @author Sudhir Shelke
* @date : Created_date: 17/April/2018 Ex: signInUser(username("sudhirshelke12983"),password("*****"))
*/
	public static void signInUser(AndroidDriver driver, String username, String password) throws InterruptedException{
		System.out.println( "User is navigating to Sign In page via Home button ");
		driver.findElement(homeBtn).click();
	    driver.findElement(signIN).click();	
	    Thread.sleep(5000);
	    System.out.println( "Enter UserName & Password... ");
		driver.findElement(usernameTF).sendKeys(username);
		Thread.sleep(5000);
		driver.findElement(passwordTF).sendKeys(password); 
		Thread.sleep(5000);
		System.out.println( "Clicking SignIn button ");
		driver.findElement(signInBtn).click();
		WebElement deny = driver.findElement(denyBtn);	
		boolean DenyBTExists = deny.isDisplayed();
	    if (DenyBTExists == false) {
	    	driver.findElement(denyBtn).click();
	    }
	 }
	

/**
* @Desc: Function will Sign Out user
* @return true/false
* @throws Exception
* @Variables: NA
* @author Sudhir Shelke
* @date : Created_date: 17/April/2018 Ex: signOutUser())
*/
	public static void signOutUser(AndroidDriver driver) throws InterruptedException{
		//logger.info("Configure my accounts-->settings is not available");
		System.out.println( "User is navigating to signout settings via Home button ");
		driver.findElement(homeBtn).click();
		Thread.sleep(5000);
	    driver.findElement(SettingsBtn).click();	
	    Thread.sleep(5000);
	    System.out.println( "Clicking SignIn button ");
	    driver.findElement(SignOutBtn).click();
		Thread.sleep(5000);
			
	}

	/**
	* @Desc: Function will verify sign In user
	* @return true/false
	* @throws Exception
	* @Variables: NA
	* @author Sudhir Shelke
	* @date : Created_date: 17/April/2018 Ex: verifySignInUser())
	*/

	public static void verifySignInUser(AndroidDriver driver) throws InterruptedException{
		//logger.info("Configure my accounts-->settings is not available");
		System.out.println( "User is navigating to settings page via Home button ");
		driver.findElement(homeBtn).click();
		System.out.println( "User is checking for signIn button after Signing in ");
		WebElement sign = driver.findElement(signIN);	
		boolean SignInExists = sign.isDisplayed();
	    if (SignInExists == false) {
	    	 System.out.println( "User logged in successfully ");
		} else {
			System.out.println( "User is not logged in successfully ");
		}
	}
	
	
	/**
	* @Desc: Function will verify sign Out user
	* @return true/false
	* @throws Exception
	* @Variables: NA
	* @author Sudhir Shelke
	* @date : Created_date: 17/April/2018 Ex: verifySignOutUser())
	*/
	public static void verifySignOutUser(AndroidDriver driver) throws InterruptedException{
			//logger.info("User is navigating to settings page via Home button");
			System.out.println( "User is navigating to settings page via Home button ");
			driver.findElement(homeBtn).click();
			System.out.println( "User is checking for signIn button after Signing out ");
			WebElement sign = driver.findElement(signIN);	
			boolean SignInExists = sign.isDisplayed();
		    if (SignInExists == true) {
		    	 System.out.println( "User logged in successfully ");
			} else {
				System.out.println( "User is not logged out successfully ");
		}
	
	}
}


