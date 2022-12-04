package in.swiggy.testscripts;

import org.openqa.selenium.chrome.ChromeDriver;

import in.swiggy.pages.CheckoutPage;
import in.swiggy.pages.LandingPage;
import in.swiggy.pages.RestaurantPage;

public class Driver extends Tools{
	
	protected static LandingPage landingPage;
	protected static RestaurantPage restautantPage;
	protected static CheckoutPage checkoutPage;
	
	public static void init() {
		
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		
		landingPage = new LandingPage(driver);
		restautantPage = new RestaurantPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}

}
