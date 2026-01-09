package testcaseixigo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import AyushCUCU.ixigo.LoginPage;
import TestBase.BaseClass;

public class LoginTest extends BaseClass{ 
	
	@BeforeTest 
public void testDetails()
{
	System.out.println("BeforeTest running");
	testName="TC001_LoginTest" ; 
	testDescription="Login to ixigo website with valid credentials"; 
	author="Ayush Gangil";
} 
@Test 
public void TC001_LoginTest() throws InterruptedException, IOException
{
	LoginPage login=new LoginPage();

	login.startLogin();  
	Assert.assertTrue(login.loginText().contains("Hey Yash")); 
	if(login.loginText().contains("Yash"))
	{
		test.pass("Login Test Passed");
	} 
	else {
		 
		takeScreenshot("TC001_LoginTest"); 

		test.fail("Login Test Failed",  MediaEntityBuilder.createScreenCaptureFromPath("D:\\ixigo\\ScreenShot\\TC001_LoginTest.png").build());
	}
	//test.fail("Login test passed");
}
}