package category_Module;

import org.testng.annotations.Test;

import com.GenericUtilities.AdminBaseClass;

import com.GenericUtilities.JavaUtility;
import com.ObjectRepository.Admin_CreateCategoryPage;
import com.ObjectRepository.Admin_HomePage;
import com.ObjectRepository.Admin_LoginPage;
import com.ObjectRepository.Admin_SubCategoryPage;

public class CreateCategory_Test extends AdminBaseClass{
	
	@Test
	public void InsertProdut() throws Throwable
	{
		
		Admin_HomePage ahp= new Admin_HomePage(driver);
		ahp.clickOncreateCategoryLink();
		
		Admin_CreateCategoryPage accp = new Admin_CreateCategoryPage(driver);
		accp.CreateCategory(eLib,jLib,driver); 
		
		new Admin_SubCategoryPage(driver);
		System.out.println("a");
	
	
	}
	 
	

}
