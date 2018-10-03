package dataProvider;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;


import utilityPackage.ExcelUtils;
import utilityPackage.ExtentUtils;
import utilityPackage.ScreenshotUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class ExcelWithDataProvider {

	private String sTestCaseName;
	private int iTestCaseRow;
 	WebDriver driver;
 	
@BeforeMethod
	  public void beforeMethod() 
	  {
		System.setProperty("webdriver.chrome.driver", "C:\\Akhil\\Selenium\\ChromeDriver\\chromedriver.exe");
		driver = new  ChromeDriver();
	 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://newtours.demoaut.com/");
		
	  }
@Test(dataProvider = "Authentication")
  public void login(String sUserName, String sPassword) 
	{
	

    driver.findElement(By.name("userName")).sendKeys(sUserName);

	System.out.println(sUserName);

    driver.findElement(By.name("password")).sendKeys(sPassword);

	System.out.println(sPassword);

    driver.findElement(By.name("login")).click();
    Assert.assertTrue(driver.getTitle().contains("akhi"));
    
    
    }
@DataProvider
public Object[][] Authentication() throws Exception 
	{
		ExcelUtils.setExcelFile("C://Akhil//Selenium//Selenium Doc//TestDataDataprovider.xlsx", "testdata");
		String sTestCaseName="DataProviderWithExcel";
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
		Object[][] testObjArray = ExcelUtils.getTableArray(iTestCaseRow);
    	return (testObjArray);

	
  
	}
 @AfterMethod
  public void afterMethod(ITestResult result) throws IOException 
 	{ 
	 String className = this.getClass().getSimpleName();
	
	 ExtentUtils.finalreport(result, driver, className);
 		
 	
 	driver.close();
    }
  
}
