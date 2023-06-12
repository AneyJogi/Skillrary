package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class Admin_SubCategoryPage {
	
	@FindBy(name="category")
	private WebElement CategoryDropdown;
	
	@FindBy(xpath = "//input[@name='subcategory']")
	private WebElement SubCategoryEdt;
	
	@FindBy(xpath="//button[.='Create']")
	private WebElement CreateBtn;

	//initialization
	public  Admin_SubCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//ulitization
	
	public WebElement getCategoryDropdown() {
		return CategoryDropdown;
	}

	public WebElement getSubCategoryEdt() {
		return SubCategoryEdt;
	}

	public WebElement getCreateBtn() {
		return CreateBtn;
	}
	
	
	public String CreateSubCategory(WebDriverUtility wLib,String visibletext) throws Throwable
	{
		wLib.select(visibletext, CategoryDropdown);
		String subcategoryvalue = "6folds";
		SubCategoryEdt.sendKeys(subcategoryvalue);
		Thread.sleep(2000);
		CreateBtn.click();
		
		return subcategoryvalue;
	}
	
	
	
	
	
	

}
