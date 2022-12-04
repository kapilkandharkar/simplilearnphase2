package in.swiggy.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.swiggy.pages.CheckoutPage;
import in.swiggy.pages.LandingPage;
import in.swiggy.pages.RestaurantPage;

/*Go to https://www.swiggy.com/
Enter your delivery location as ‘Bangalore’ and hit enter
Click on first search result under ‘restaurants’
Click on ‘Add’ button under ‘Top Picks’ of that restaurant
Click on ‘Checkout’ button under ‘Cart’
Verify user sees the text ‘To place your order now, log in to your existing account or sign up’
Close the browser*/

public class OrderFoodTest extends BaseTest {
	
	@Test
	public void orderFoodBangalore() {
		
		//1) Go to https://www.swiggy.com/
		LandingPage landingPage = new LandingPage(driver);
		
		//2) Enter your delivery location as ‘Bangalore’
		landingPage.selectDeliveryLocation("Bangalore");
		
		//3) Click on first search result under ‘restaurants’
		landingPage.clickFirstRestaurant();
		
		//4) Click on ‘Add’ button under ‘Top Picks’ of that restaurant
		RestaurantPage restautantPage = new RestaurantPage(driver);
		restautantPage.addFirstDishFromMenu();
		
		//4.5) Depending upon restaurant e.g. KFC displays pop up for add item
		//     If pop up displayed click on Add Item
		boolean isAddItemPopup;
		try {
		   driver.findElement(By.xpath("//*[contains(text(), 'Add Item')]"));
		   isAddItemPopup = true;
		} catch (NoSuchElementException e) {
			isAddItemPopup = false;
		}
		if(isAddItemPopup) {
			restautantPage.clickAddItem();
		}
		
		//5) Click on ‘Checkout’ button under ‘Cart’
		restautantPage.clickCheckoutButton();
		
		//6) Verify user sees the text ‘To place your order now, log in to your existing account or sign up’
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		String expectedMsg = "To place your order now, log in to your existing account or sign up.";
		String actualMsg = checkoutPage.getCheckoutMessage();
		Assert.assertEquals(actualMsg, expectedMsg);
	}

}
