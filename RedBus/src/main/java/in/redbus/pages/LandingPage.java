package in.redbus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	private Actions actions;
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		
	}
	
	@FindBy(id = "src")
	private WebElement sourcecity;
	
	public void enterSourceCity() throws InterruptedException {
		sourcecity.sendKeys("Bangaluru");	
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER);
	}
	
	@FindBy(id = "dest")
	private WebElement destcity;
		
	public void enterDestinationCity() throws InterruptedException {
		destcity.sendKeys("Chennai");
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER);
	}
	
	@FindBy(id = "onward_cal")
	private WebElement dateCalendar;	

	@FindBy(xpath = "//table[contains(@class, 'monthTable')]")
	private WebElement Calendar;
	
	public void selectDateFromCalendar() throws InterruptedException {
		dateCalendar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> month = Calendar.findElements(By.tagName("td"));
		
		for(WebElement day : month) {
			if(day.getText().equals("17")) {
				day.click();
				break;
			}
		}
	}
	
	@FindBy(id = "search_btn")
	private WebElement searchBuses;
	
	public void clickSearchBuses() {
		searchBuses.click();
	}
}




















