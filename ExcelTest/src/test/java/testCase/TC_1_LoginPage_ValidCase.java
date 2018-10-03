 package testCase;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import baseclass.driverinstance;
import pages.loginPage;
import utilityPackage.ExcelUtils;
//@Listeners(listner.ListnerTest.class)	
/*Extends the parent class.when we are executing the test case first it will check for test annotation,now its checks 
 * do we have before method annotation.Since we are inheriting another class it will go to the parent class and checks 
 * if we have before annotation,so before method will execute and create a driver instance.since in parent driver is
 * made as public it can be used in child class
 * */
public class TC_1_LoginPage_ValidCase extends driverinstance {
	private String sTestCaseName;
	private int iTestCaseRow;
	
	@Test(dataProvider="Authentication")
	
	public void tc_01_login(String uname, String pass) throws Exception
	{/*loinpage class has a constructor which needs driver object so we are passing the driver object from here and the value
	 	will be coming from parent due to inheritance*/
		loginPage login=new loginPage(driver);
		login.enterusername(uname);
		login.enterpassword(pass);
		login.clicksignin();
		Assert.assertTrue(driver.getTitle().contains("a"));
	}
	@DataProvider
	public Object[][] Authentication() throws Exception 
		{
			utilityPackage.ExcelUtils.setExcelFile("./TestData/TestData.xlsx", "testdata");
			String sTestCaseName="DataProviderWithExcel";
			iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
			Object[][] testObjArray = ExcelUtils.getTableArray(iTestCaseRow);
	    	return (testObjArray);

		
	  
		}

}
