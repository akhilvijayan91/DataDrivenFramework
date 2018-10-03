package baseclass;
 
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilityPackage.ExtentUtils;


public class driverinstance {
	
	public WebDriver driver;
	
	@BeforeMethod  
	public void initiateDriverinstance() throws Exception
	{/* fetching data from property file converting object to string
	(since fetchpropertyvalue() method will be returning only object) and then comparing*/
		if(utilityPackage.utilityFetchproperty.fetchpropertyvalue("browserName").toString().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			
		driver=new ChromeDriver();
		}
		
		else if(utilityPackage.utilityFetchproperty.fetchpropertyvalue("browserName").toString().equalsIgnoreCase("chrome"))
		{
			driver= new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		}
		else if(utilityPackage.utilityFetchproperty.fetchpropertyvalue("browserName").toString().equalsIgnoreCase("chrome"))
		{
			driver=new InternetExplorerDriver();
		}
		//if incorrect or nothing is mentioned it will create Chrome driver object
		else
		{
			driver=new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
		driver.get(utilityPackage.utilityFetchproperty.fetchpropertyvalue("URL").toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@AfterMethod
	public void closeDriverInstance(ITestResult result) throws IOException
	{ String className = this.getClass().getSimpleName();  
		ExtentUtils.finalreport(result,driver,className);
		driver.close();
	}
}
	 