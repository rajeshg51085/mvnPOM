package POMTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POMPages.browserfactory;
import POMPages.clsebay;

public class POMProdCatSearchtest {
  @Test
  public void prodCatSearch()
  {
	  WebDriver driver = browserfactory.StartBrowser("chrome", "http://ebay.com");
	  clsebay obj = new clsebay(driver);
	  obj.fnProdCatSearch("Cameras & Photo", "Sony");
  }
}
