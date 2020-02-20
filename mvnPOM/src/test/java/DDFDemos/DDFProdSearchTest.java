package DDFDemos;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDFProdSearchTest {
  @Test(dataProvider = "EbayData")
  public void ProdSearch(String ddvalue, String txtvalue)
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://ebay.com");
	  
	  driver.findElement(By.id("gh-ac")).sendKeys(txtvalue);
	  driver.findElement(By.id("gh-btn")).click();	  
  }
  
  @DataProvider
  public Object[][] EbayData() throws Exception 
  {
	Object [][]data;
	XSSFWorkbook wb = new XSSFWorkbook("C:\\Users\\Admin\\eclipse-workspace\\mvnPOM\\src\\test\\java\\Input\\DDFEbayInput.xlsx");
	XSSFSheet ws = wb.getSheet("Sheet1");
	
	int rows = ws.getPhysicalNumberOfRows();
	data = new Object[rows][2];
	
	for(int i = 0; i<rows; i++)
	{
		data[i][0] = ws.getRow(i).getCell(0).getStringCellValue();
		data[i][1] = ws.getRow(i).getCell(1).getStringCellValue();
		
	}
	return data;
	
	
  }
}
