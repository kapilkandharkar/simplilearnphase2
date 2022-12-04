package in.redbus.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchApplication() {
		
		// 1) Open the Browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		
		// 2) Maximise It
		driver.manage().window().maximize();		
		
		// 3) Naigate to application
		driver.get("https://www.redbus.in");
		
	}
	
	@AfterClass
	public void closeApplication() {
		//driver.quit();		
	}


}
