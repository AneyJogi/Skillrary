package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepository.Admin_HomePage;
import com.ObjectRepository.Admin_LoginPage;
import com.ObjectRepository.User_HomePage;
import com.ObjectRepository.User_SignInPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminBaseClass {
	
	public FileUtility fLib= new FileUtility();
	public ExcelUtility eLib= new  ExcelUtility();
	public DatabaseUtility dLib= new DatabaseUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dLib.connectToDb();
		System.out.println("====Connected To Database====");
	}
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable
	{
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL= fLib.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			System.out.println("===="+BROWSER+" browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			System.out.println("===="+BROWSER+" browser launched====");
		}
		else
		{
			System.out.println("====Invalid browser====");
		}
		
		sdriver=driver;
		driver.get(URL);
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		
	}

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
		String USERNAME=fLib.readDataFromPropertyFile("username");
		String PASSWORD=fLib.readDataFromPropertyFile("password");
		
		Admin_LoginPage alp = new Admin_LoginPage(driver);
		alp.login(USERNAME, PASSWORD);
		System.out.println("====Login To App successfull====");
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		Admin_HomePage ahp = new Admin_HomePage(driver);
		ahp.logOut();
	
		System.out.println("====Logout of App successfull====");
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
		System.out.println("====Browser is closed====");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable
	{
		dLib.closeDB();
		System.out.println("====Database Connection Closed====");
	}
}



