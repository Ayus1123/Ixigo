package AyushCUCU.ixigo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class BookingPage extends BaseClass {
@FindBy(xpath="//button[text()='Round Trip']") 
WebElement roundTrip;

@FindBy(xpath="(//div[contains(@class,'flex-1 h-full flex flex-col justify-center px-15 py-10')])[1]")
WebElement sourceClick; 
@FindBy(xpath="(//div[contains(@class,'flex flex-grow items-center')])[1]/input") 
WebElement sourceSend; 
@FindBy(xpath="(//span[text()='BOM'])[1]") 
WebElement sourceSubmit; 

@FindBy(xpath="//div[contains(@class,'flex-1 h-full flex flex-col justify-center px-15 py-10 ')]//span[text()='To']") 
WebElement destinationClick; 
@FindBy(xpath="(//div[@class='flex flex-grow items-center']/input)[2]") 
WebElement destinationSend; 
@FindBy(xpath="//span[text()='LHR']")  
WebElement destinationSubmit;   

@FindBy(xpath="(//button[@type='button'][11])[2]") 
WebElement departureDate; 
@FindBy(xpath="(//div[@class='flex flex-col'])[5]") 
WebElement returnClick;  
@FindBy(xpath="(//button[@type='button'])[52]") 
WebElement returnDate; 

@FindBy(xpath="(//div[@class='flex flex-col'])[6]") 
WebElement travelSelect; 
@FindBy(xpath="//button[@data-testid='2']") 
WebElement clickAdult; 
@FindBy(xpath="(//button[text()='2'])[2]") 
WebElement clickChildren; 
@FindBy(xpath="(//button[text()='2'])[3]") 
WebElement clickInfants; 
@FindBy(xpath="//span[text()='Business']") 
WebElement selectClass;

@FindBy(xpath="//button[text()='Search']")
WebElement search;

Actions act;
public BookingPage()
{
	PageFactory.initElements(driver,this);
} 

public void setSource() throws InterruptedException
{
	act=new Actions(driver);
	Thread.sleep(9000);
	roundTrip.click(); 
	Thread.sleep(5000);
	act.moveToElement(sourceClick).click().perform();;  
	Thread.sleep(6000); 
	sourceSend.sendKeys("Pune"); 
	Thread.sleep(5000);  
	sourceSubmit.click();
	
} 
public void setDestination() throws InterruptedException
{
	act=new Actions(driver); 
	elementVisibilityWait(destinationClick);
	Thread.sleep(8000);  
	destinationSend.sendKeys("London"); 
	Thread.sleep(8000);  
	destinationSubmit.click(); 
	Thread.sleep(8000);
} 
public void setDate() throws InterruptedException
{
	act=new Actions(driver); 
	Thread.sleep(3000);
	act.moveToElement(departureDate).click().perform();  
	Thread.sleep(3000);
	act.moveToElement(returnClick).click().perform();   
	Thread.sleep(3000);
	act.moveToElement(returnDate).click().perform();
} 
public void setTravel() throws InterruptedException
{
	Thread.sleep(3000);
	travelSelect.click(); 
	Thread.sleep(3000);
	clickAdult.click();  
	Thread.sleep(3000);
	clickChildren.click();  
	Thread.sleep(3000);
	clickInfants.click();  
	Thread.sleep(3000);
	selectClass.click(); 
	Thread.sleep(3000);
	search.click(); 
	Thread.sleep(6000);
}
}
