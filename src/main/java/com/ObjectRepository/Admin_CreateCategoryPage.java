package com.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaUtility;

public class Admin_CreateCategoryPage 
{
	//declaration
	@FindBy(name="category")
	private WebElement CreateCategoryEdt;
	
	@FindBy(name="description")
	private WebElement DescriptionEdt;
	
	@FindBy(name="submit")
	private WebElement SubmitBtn;
	
	
	//initialization
	public Admin_CreateCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	//Utilization

	public WebElement getCreateCategoryEdt() {
		return CreateCategoryEdt;
	}


	public WebElement getDescriptionEdt() {
		return DescriptionEdt;
	}


	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//business Library
	
	public String CreateCategory(ExcelUtility eLib,JavaUtility jLib,WebDriver driver) throws Throwable
	{
		HashMap<String, String> map = eLib.readMultipleData("AdminCategoryPage");
		String categoryvalue = null;
		for(Entry<String, String> set: map.entrySet())					//get data from map
		{
		if(set.getKey().equalsIgnoreCase("category"))
		{
			categoryvalue = set.getValue()+jLib.random();
		   driver.findElement((By.name(set.getKey()))).sendKeys(categoryvalue);
		     
		}
		else
		{
				driver.findElement((By.name(set.getKey()))).sendKeys(set.getValue());
			
		}	
		}
		Thread.sleep(2000);
			SubmitBtn.click();
			
			return categoryvalue;	


	}
}

