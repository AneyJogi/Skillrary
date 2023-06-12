package category_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.ObjectRepository.Admin_LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCategory
{

	

	public static void main(String[] args) throws Throwable 
	{
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
			
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		String USERNAME=fLib.readDataFromPropertyFile("username");
		String PASSWORD=fLib.readDataFromPropertyFile("password");
		    
		//eLib.readDataFromExcel(Organisation, , 0)
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver= new ChromeDriver();
		
		wLib.maximizeWindow(driver);					//		driver.manage().window().maximize();
		wLib.waitForPageLoad(driver);					//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.get(URL);                                //driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		
	
//		Random ran = new Random();
//		int random = ran.nextInt(1000);
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);;
		driver.findElement(By.name("submit")).click();
//		Admin_LoginPage alp= new Admin_LoginPage(driver);
//		alp.login(USERNAME, PASSWORD);
		
		driver.findElement(By.xpath("//a[.=' Create Category ']")).click();
		
//		HashMap<String, String> map = new HashMap<String, String>();    //create empty Map
//		for(int i=0;i<Sh.getLastRowNum();i++)							// fetch data from ecxel
//		{
//			String key = Sh.getRow(i).getCell(0).getStringCellValue();
//			String value = Sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);										//put data into map
//		}
		
		 HashMap<String, String> map = eLib.readMultipleData("AdminCategoryPage");
		
		for(Entry<String, String> set: map.entrySet())					//get data from map
		{
			if(set.getKey().equalsIgnoreCase("category"))
			{
		     driver.findElement((By.name(set.getKey()))).sendKeys(set.getValue()+jLib.random());
		     
			}
			else
			{
				driver.findElement((By.name(set.getKey()))).sendKeys(set.getValue());
			}
		}
		
		
		driver.findElement(By.name("submit")).click();
		
		//driver.findElement(By.name("category")).sendKeys(category+random);
	    //driver.findElement(By.name("description")).sendKeys(description);
		//driver.findElement(By.name("submit")).click();
		//String actual=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		//List<WebElement> categorylist = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		//for(WebElement product:categorylist)
		//{
		//	product.getText();
		//}
	     
		
		
			}

	}
