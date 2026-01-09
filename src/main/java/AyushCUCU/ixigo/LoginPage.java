package AyushCUCU.ixigo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import TestBase.BaseClass;

public class LoginPage extends BaseClass{ 
	@FindBy(xpath="//iframe[@id='wiz-iframe-intent']") 
	WebElement ifram;
	@FindBy(xpath="//span[text()='×']") 
	WebElement closeBtn;
	@FindBy(xpath="(//button[text()='Log in/Sign up'])[1]") 
	WebElement loginPage; 
	@FindBy(xpath="//input[@placeholder='Enter Mobile Number']") 
	WebElement enterMobile; 
	@FindBy(xpath="//button[text()='Continue']") 
	WebElement loginContinue; 
	@FindBy(xpath="//button[text()='Verify']") 
	WebElement verify;   
	@FindBy(xpath="//span[text()='Yash']") 
	WebElement user;
	@FindBy(xpath="//div[text()='Please enter a valid OTP and try again']") 
	WebElement error;
	public LoginPage()
	{
		PageFactory.initElements(driver,this); 
	} 
	public String loginText()
	{
		return user.getText();
	} 
	public String loginError()
	{
		return error.getText();
	}
	public void startLogin() throws InterruptedException
	{
		Thread.sleep(5000);
		loginPage.click(); 
		Thread.sleep(2000); 
		enterMobile.sendKeys("9977512206");  
		Thread.sleep(5000);
		loginContinue.click(); 
		Thread.sleep(15000);
	//	verify.click(); 	
		
	
} 
	public void loginErrorCheck() throws InterruptedException
	{
		Thread.sleep(5000); 
		loginPage.click(); 
		Thread.sleep(2000); 
		enterMobile.sendKeys("9977512206"); 
		Thread.sleep(4000);
		loginContinue.click(); Thread.sleep(9000);
	}
	//driver.switchTo().defaultContent(); 
	/*Thread.sleep(3000);
	WebElement el1=driver.findElement(By.xpath("(//button[text()='Log in/Sign up'])[1]")); 
	act.moveToElement(el1).click().perform(); 
	Thread.sleep(4000);
	WebElement elm1=driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")); 
	elm1.sendKeys("9977512206"); 
	Thread.sleep(3000);
	WebElement elm2=driver.findElement(By.xpath("//button[text()='Continue']")); 
	elm2.click();  
	//button[text()='Verify']
	WebElement elm3=driver.findElement(By.xpath("//button[text()='Verify']")); 
	elm3.click(); */
}

