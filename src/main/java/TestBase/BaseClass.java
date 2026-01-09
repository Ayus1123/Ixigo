package TestBase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utility.UtilClass;

public class BaseClass extends UtilClass{

@BeforeSuite 
public void startReport()
{
	
	 
	System.out.println("BeforeSuite running");
	spark=new ExtentSparkReporter("ixigoReport.html");
	reports=new ExtentReports(); 
	spark.config().setDocumentTitle("IxigoTesting"); 
	spark.config().setReportName("Ayush");
	reports.attachReporter(spark);   
	
	 
} 
@BeforeClass
public void detail()
{
	System.out.println("BeforeClass running"+testName);
	test=reports.createTest(testName,testDescription); 
	test.assignAuthor(author); 
} 
@BeforeMethod 
public void setUp() throws IOException
{
	System.out.println("BeforeMethod running");
	launchBrowser(readProperty("browser"));   
	launch(readProperty("url")); 
	
} 
@AfterMethod 
public void tearDown()
{
	System.out.println("AfterMethod running");
	driver.quit();
}
@AfterSuite
public void endReport()
{
	System.out.println("AfterSuite running");
	reports.flush();
}
}
