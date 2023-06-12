package category_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.ObjectRepository.Admin_CreateCategoryPage;
import com.ObjectRepository.Admin_HomePage;
import com.ObjectRepository.Admin_LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCategoryPOMTest {
	

	public static void main(String[] args) throws Throwable {
		
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	
	String BROWSER=fLib.readDataFromPropertyFile("browser");
	String URL=fLib.readDataFromPropertyFile("url");
	String USERNAME=fLib.readDataFromPropertyFile("username");
	String PASSWORD=fLib.readDataFromPropertyFile("password");
	
	WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
	
	wLib.maximizeWindow(driver);					
	wLib.waitForPageLoad(driver);					
	driver.get(URL);
	
	Admin_LoginPage alp= new Admin_LoginPage(driver);
	alp.login(USERNAME, PASSWORD);
	
	Admin_HomePage ahp= new Admin_HomePage(driver);
	ahp.clickOncreateCategoryLink();
	
	Admin_CreateCategoryPage accp= new Admin_CreateCategoryPage(driver);
	accp.CreateCategory(eLib, jLib, driver);
	
	
	
	
	}
}
 