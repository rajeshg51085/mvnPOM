package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class clsebay 
{
public WebDriver wd;
	
	//To get driver information from calling testscripts [constructor]
	public clsebay(WebDriver d)
	{
		wd = d;
	}
	
	By txtSearch = By.id("gh-ac");
	By btnSearch = By.id("gh-btn");
	By ddcat = By.id("gh-cat");
	
	public void fnProdSearch(String ProdName)
	{
		wd.findElement(txtSearch).sendKeys(ProdName);
		wd.findElement(btnSearch).click();
	}
	
	public void fnProdCatSearch(String cat, String Pname)
	{
		WebElement dd = wd.findElement(ddcat);
		Select s = new Select(dd);
		s.selectByVisibleText(cat);
		fnProdSearch(Pname);
	}

}
