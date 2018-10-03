package assertions;

import org.openqa.selenium.WebDriver;

public class compare {
	
	

	public static boolean validatepageURL(WebDriver driver,String expectedURL)
	{
		boolean flag=false;
		if(driver.getCurrentUrl().equalsIgnoreCase(expectedURL))
		{
			flag=true;
		}
		return flag;
	}
	public static boolean validatepagetitle(WebDriver driver,String expectedtitle)
	{
		boolean flag=false;
		if(driver.getTitle().equalsIgnoreCase(expectedtitle))
		{
			flag=true;
		}
		return flag;
	}
}

