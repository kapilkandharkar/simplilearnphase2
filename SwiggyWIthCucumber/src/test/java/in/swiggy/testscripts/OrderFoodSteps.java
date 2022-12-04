package in.swiggy.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderFoodSteps extends Driver {
	
	
	@Given("a user is on the landing page of Swiggy")
	public void a_user_is_on_the_landing_page_of_swiggy() {
	    Assert.assertTrue(driver.getCurrentUrl().equals("https://www.swiggy.com/"));
//		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.swiggy.com/");
	}

	@When("he enters delivery location as Bangalore and hit enter")
	public void he_enters_delivery_location_as_bangalore_and_hit_enter() {
		//landingPage = new LandingPage(driver);
		landingPage.selectDeliveryLocation("Bangalore");
	}

	@When("he clicks on first search result under restaurants")
	public void he_clicks_on_first_search_result_under_restaurants() {
		landingPage.clickFirstRestaurant();
	}

	@When("he clicks on Add button under Top Picks of that restaurant")
	public void he_clicks_on_add_button_under_top_picks_of_that_restaurant() {
		//restautantPage = new RestaurantPage(driver);
		restautantPage.addFirstDishFromMenu();
	}

	@When("he clicks on Add Item buttom if customise pop up displayed")
	public void he_clicks_on_add_item_buttom_if_customise_pop_up_displayed() {
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
	}

	@When("he clicks on Checkout button under Cart")
	public void he_clicks_on_checkout_button_under_cart() {
		restautantPage.clickCheckoutButton();
	}

	@Then("he must be able to order food successfully")
	public void he_must_be_able_to_order_food_successfully() {
		//CheckoutPage checkoutPage = new CheckoutPage(driver);
		String expectedMsg = "To place your order now, log in to your existing account or sign up.";
		String actualMsg = checkoutPage.getCheckoutMessage();
		Assert.assertEquals(actualMsg, expectedMsg);
		driver.quit();
	}


}
