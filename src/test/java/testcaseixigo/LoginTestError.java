package testcaseixigo;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import AyushCUCU.ixigo.LoginPage;
import TestBase.BaseClass;

public class LoginTestError extends BaseClass {

	@BeforeTest 
	public void testDetails()
	{
		System.out.println("BeforeTest running");
		testName="TC002_LoginTestError" ; 
		testDescription="Login to ixigo website with valid credentials"; 
		author="Ayush Gangil";
	} 
	@Test
	public void TC002_LoginTestError() throws InterruptedException, IOException
	{
		LoginPage login =new LoginPage(); 
		login.loginErrorCheck(); 
		if(login.loginError().contains("Please enter a valid OTP and try again"))
		{
			test.pass("LoginTestError Pass");
		} 
		else 
		{
			takeScreenshot("TC002_LoginTestError");
			test.fail("LoginTestErrorFailed",MediaEntityBuilder.createScreenCaptureFromPath("D:\\ixigo\\ScreenShot\\TC002_LoginTestError.png").build());
		}
	}
}
