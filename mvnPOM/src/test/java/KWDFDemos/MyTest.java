package KWDFDemos;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTest 
{
	public WebDriver driver;
  @Test
  public By locatorInfo(String locType, String locValue) 
  {
	  By b = null;
	  
	  switch (locType)
	  {
	  case "id":
		  b = By.id(locValue);
		  break;
		  
	  case "name":
		  b = By.name(locValue);
		  break;
		  
	  case "classname":
		  b = By.className(locValue);
		  break;
		  
	  case "tagname":
		  b = By.tagName(locValue);
		  break;
		  
	  case "xpath":
		  b = By.xpath(locValue);
		  break;
		  
	  case "css_selector":
		  b = By.cssSelector(locValue);
		  break;
		  
	  case "linkText":
		  b = By.linkText(locValue);
		  break;
		  
	  case "PartiallinkText":
		  b = By.partialLinkText(locValue);
		  break;
		  
		  default:
			  b = null;
			  break;
	  
	  }
	return b;
  }
  
  @Test
  public void SampleTest() throws Exception
  {
	  XSSFWorkbook wb = new XSSFWorkbook("E:\\Selenium\\keywords.xlsx");
	  XSSFSheet ws = wb.getSheet("Sheet1");
	  int rows = ws.getPhysicalNumberOfRows();
	  
	  for(int i = 1; i<rows; i++)
	  {
		  String cTestcase = ws.getRow(i).getCell(0).getStringCellValue();
		  String clocType = ws.getRow(i).getCell(1).getStringCellValue();
		  String clocValue = ws.getRow(i).getCell(2).getStringCellValue();
		  String cTestData = ws.getRow(i).getCell(3).getStringCellValue();
		  
		  switch(cTestcase)
		  {
		  case "open Browser" : 
			  if(cTestData.equalsIgnoreCase("chrome"))
			  {
				  WebDriverManager.chromedriver().setup();
				  driver = new ChromeDriver();
			  }
			  else if (cTestData.equalsIgnoreCase("firefox"))
			  {
				  WebDriverManager.firefoxdriver().setup();
				  driver = new FirefoxDriver();
				  
			  }
			  
			  driver.manage().window().maximize();
			  break;
			  
			  
		  case "Enter_url":
			  driver.get(cTestData);
			  break;
			  
		  case "select_Dropdown":
			  WebElement dd = driver.findElement(locatorInfo(clocType,clocValue));
			  Select s = new Select(dd);
			  s.deselectByVisibleText(cTestData);
			  break;
			  
		  case "enter_Text":
			  WebElement txt = driver.findElement(locatorInfo(clocType,clocValue));
			  txt.sendKeys(cTestData);
			  break;
			  
		  case "click_Button":
			  WebElement btn = driver.findElement(locatorInfo(clocType,clocValue));
			  btn.click();
			  break;
			  
		  case "close_Browser":
			  driver.close();
			  break;
		  }
	  }
  }
}
