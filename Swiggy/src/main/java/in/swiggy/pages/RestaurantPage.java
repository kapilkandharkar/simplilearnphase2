package in.swiggy.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RestaurantPage {
	

	private WebDriverWait wait;
	
	@FindBy(xpath = "(//div[contains(@class, '_1RPOp')])[1]")  //*[contains(text(),'ADD')]
	private WebElement firstDishMenu;
	
	@FindBy(xpath = "//*[contains(text(), 'Add Item')]")  
	private WebElement popupAddItem;
	
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	private WebElement buttonCheckout;

	public RestaurantPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void addFirstDishFromMenu()
	{
		wait.until(ExpectedConditions.visibilityOf(firstDishMenu));
		firstDishMenu.click();
	}
	
	public void clickCheckoutButton()
	{		
		wait.until(ExpectedConditions.visibilityOf(buttonCheckout));
		buttonCheckout.click();		
	}
	
	public void clickAddItem()
	{		
		wait.until(ExpectedConditions.visibilityOf(popupAddItem));
		popupAddItem.click();		
	}
}
