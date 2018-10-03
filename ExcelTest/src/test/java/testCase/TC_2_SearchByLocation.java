package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.driverinstance;
import pages.loginPage;
import utilityPackage.ExcelUtils;

public class TC_2_SearchByLocation extends driverinstance {
	private String sTestCaseName;
	private int iTestCaseRow;
	
	@Test(dataProvider="Authentication")
	
	public void tc_01_SearchByLocation(String uname, String pass,String location) throws Exception
	{/*loinpage class has a constructor which needs driver object so we are passing the driver object from here and the value
	 	will be coming from parent due to inheritance*/
		loginPage login=new loginPage(driver);
		login.enterusername(uname);
		login.enterpassword(pass);
		login.clicksignin();
		 Select drpCountry = new Select(driver.findElement(By.xpath("//Select[@name='fromPort']")));
			drpCountry.selectByVisibleText(location);
			
			
			driver.findElement(By.xpath("//input[@name='findFlights']")).click();
			//Thread.sleep(5000);
			WebElement listofobject=driver.findElement(By.xpath("//td[@class='frame_action_xrows']"));
			Assert.assertEquals(true, listofobject.isDisplayed());
			
	}
	@DataProvider
	public Object[][] Authentication() throws Exception 
		{
			utilityPackage.ExcelUtils.setExcelFile("C://Akhil//Selenium//Selenium Doc//TestDataDataprovider.xlsx", "testdata");
			String sTestCaseName="AirLocationSearch";
			iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
			Object[][] testObjArray = ExcelUtils.getTableArray(iTestCaseRow);
	    	return (testObjArray);

		
	  
		}

}
