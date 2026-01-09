package testcaseixigo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import AyushCUCU.ixigo.BookingPage;
import TestBase.BaseClass;

public class BookingPageNavigationTest extends BaseClass {
	@BeforeTest 
	public void testDetails()
	{
		System.out.println("BeforeTest running");
		testName="TC003_BookingTest" ; 
		testDescription="Checking if the booking page navigation works correctly"; 
		author="Ayush Gangil";
	}  
	@Test 
	public void TC003_BookingTest() throws InterruptedException, IOException
	{
	 BookingPage book=new BookingPage(); 
	 book.setSource();  
	 
	 book.setDestination(); 
	 
	 book.setDate(); 
    book.setTravel();  
	 Assert.assertTrue(driver.getCurrentUrl().contains("search/result/flight")); 
	 if(driver.getCurrentUrl().contains("search/result/flight")) 
	 {
		 test.pass("BookingPageNavigationTest Pass");
	 }  
	 else 
	 {
		 takeScreenshot("TC003_BookingTest");
		 test.fail("BookingPageNavigationTest Fail",MediaEntityBuilder.createScreenCaptureFromPath("D:\\ixigo\\ScreenShot\\TC003_BookingTest.png").build());
	 }
	 
	}
}
