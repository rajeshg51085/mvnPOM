package POMTest;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POMPages.browserfactory;
import POMPages.clsebay;

public class POMProdSearchTest {
  @Test
  public void ProdSearch() 
  {
	  WebDriver driver = browserfactory.StartBrowser("chrome", "http://ebay.com");
	  clsebay obj = new clsebay(driver);
	  obj.fnProdSearch("Sony");
  }
}
