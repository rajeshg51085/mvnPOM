package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserfactory 
{
	public static WebDriver wd;
	public static WebDriver StartBrowser(String bname, String url)
	{
		if(bname.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
			
		}
		else if (bname.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			wd = new FirefoxDriver();
			
		}	
		
		wd.manage().window().maximize();
		wd.get(url);
		return wd;
	}
	

}
