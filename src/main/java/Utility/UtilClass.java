package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class UtilClass {
public static WebDriver driver; 
public static  ExtentReports reports ; 
public static ExtentTest test;  
public static ExtentSparkReporter spark ;
public static String testName; 
public String testDescription; 
public String author;  

public static String readProperty(String Key) throws IOException
{
	Properties ps;
FileInputStream fs=new FileInputStream("D:\\ixigo\\src\\main\\java\\resources\\data.properties"); 
ps=new Properties(); 
 ps.load(fs); 
 System.out.println(ps.getProperty(Key));
 return ps.getProperty(Key).toString();
} 
public static void launchBrowser(String browser)
{
	ChromeOptions cr=new ChromeOptions();
	cr.addArguments("--incognito");
	System.out.println("hiii"+browser);
	if (browser.equalsIgnoreCase("chrome"))
	{ 
		System.out.println("Done");
		driver = new ChromeDriver(cr);
	} else if (browser.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	} else if (browser.equalsIgnoreCase("Edge")) {
		driver = new EdgeDriver();
	}
	//driver=new ChromeDriver(); 
	
	 driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
} 
public static void launch(String url)
{
	driver.get(url);
}
public static void scrollToElement(WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor) driver; 
	js.executeScript("argument[0].scrollIntoView(true);",element);
} 
public static void elementVisibilityWait(WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); 
	wait.until(ExpectedConditions.visibilityOf(element));
} 
public static void elementClickable(WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); 
	wait.until(ExpectedConditions.elementToBeClickable(element));
} 
public static void takeScreenshot(String testName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver; 
	File source=ts.getScreenshotAs(OutputType.FILE);  
	File destination=new File("D:\\ixigo\\ScreenShot\\"+testName+".png");
	FileHandler.copy(source,destination);
} 
public static void selectFromDropDown(WebElement element,String value) 
{
Select s=new Select(element); 
s.selectByValue(value);
}
public static void implicitwait()
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
} 
public static void moveToElement(WebElement element)
{
	Actions act=new Actions(driver);  
	act.moveToElement(element).click().perform();
} 
public static void switchToChildWindow()
{
	String mainWindow=driver.getWindowHandle(); 
	Set<String>allWindowHandles=driver.getWindowHandles(); 
	Iterator<String>it=allWindowHandles.iterator();
	while(it.hasNext())
	{
		String childWindow=it.next();
		if(!mainWindow.equalsIgnoreCase(childWindow)) 
		{
			driver.switchTo().window(childWindow);
		}
	} 
}
public static void switchtoIframe(WebElement element)
{
	driver.switchTo().frame(element);
}
}

