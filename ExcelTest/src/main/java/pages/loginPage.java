package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class loginPage {
	
	WebDriver driver;
	/*Creating a constructor*/
	public loginPage(WebDriver driver)
	{/*when some one going to create testcases of login page they will create object of this login page class and he or she will pass the driver object.
	 When are creating the object the constructor is automatically called,so the driver which is passed will be stored
	 in local object inside the constructor,public loginPage(WebDriver driver).
	 Now we will be passing this driver local object value  to global object inside the constructor and global object 
	 can be used in all the methods*/
		this.driver=driver;
	}

	public void enterusername(String username) throws IOException
	{
		 driver.findElement(By.xpath(utilityPackage.utilityFetchproperty.fetchlocatorvalue("login_username_xpath"))).sendKeys(username);
	}
	public void enterpassword(String password) throws IOException
	{
		 driver.findElement(By.xpath(utilityPackage.utilityFetchproperty.fetchlocatorvalue("login_password_xpath"))).sendKeys(password);
	        
	        
	}
	public void clicksignin() throws IOException
	{
		 
	        driver.findElement(By.xpath(utilityPackage.utilityFetchproperty.fetchlocatorvalue("login_signin_xpath"))).click();
}
}