package in.redbus.testscripts;

import org.testng.annotations.Test;

import in.redbus.pages.LandingPage;

public class BookTicketTest extends BaseTest{
	

	@Test
	public void BookTicketTest() throws InterruptedException {
		
		// 4) Enter Source City as "Bengaluru" 
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterSourceCity();
		
		// 5) Enter Destination City as "Chennai"
		landingPage.enterDestinationCity();
		
		// 6) Select date as 17th from Calendar		
		landingPage.selectDateFromCalendar();
		
		// 7) Click on 'Search Buses' button
		landingPage.clickSearchBuses();
		
		
		
		
	}


}
