package dataProvider;

import org.testng.annotations.Test;

import utilityPackage.ExcelUtils;

import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class SearchByLocationmercuryTours 
{
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
  @Test(dataProvider = "airsearch")
  public void Airsearch(String sUserName, String sPassword,String location) throws InterruptedException 
  {
	    driver.findElement(By.name("userName")).sendKeys(sUserName);
		System.out.println(sUserName);
	    driver.findElement(By.name("password")).sendKeys(sPassword);
		System.out.println(sPassword);
	    driver.findElement(By.name("login")).click();
	    Select drpCountry = new Select(driver.findElement(By.xpath("//Select[@name='fromPort']")));
		drpCountry.selectByVisibleText(location);
		Thread.sleep(5000);
  }
  
  @DataProvider
  public Object[][] airsearch() throws Exception
  {
	    ExcelUtils.setExcelFile("./TestData/TestData.xlsx", "testdata");
		String sTestCaseName="AirLocationSearch";
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
		Object[][] testObjArray = ExcelUtils.getTableArray(iTestCaseRow);
  	    return (testObjArray);

  }
  @AfterMethod
  public void afterMethod()
  {
	  driver.close();
  }
}
