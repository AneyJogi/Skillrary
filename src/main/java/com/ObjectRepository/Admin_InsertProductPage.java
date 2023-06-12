package com.ObjectRepository;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class Admin_InsertProductPage {
	
	
	@FindBy(name="category")
	private WebElement CategoryNameDropdown;
	
	@FindBy (name="subcategory")
	private WebElement SubCategoryDropdown;
	
	@FindBy(name="productName")
	private WebElement ProductNameEdt;
	
	@FindBy(name="productCompany")
	private WebElement ProductCompanyEdt;
	
	@FindBy(name="productpricebd")
	private WebElement ProductPricebdEdt;
	 
	@FindBy(name="productprice")
	private WebElement ProductPriceEdt;
	
	@FindBy(name="productDescription")
	private WebElement ProductDescrptionEdt;
	
	@FindBy(name="productShippingcharge")
	private WebElement ProductShippingcharge;
	
	@FindBy(id="productAvailability")
	private WebElement ProductAvailabilityDropdown;
	
	@FindBy(xpath="//button[.='Insert']")
	private WebElement InsertBtn;
	
	
	
	public Admin_InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getCrategoryNameDropdown() {
		return CategoryNameDropdown;
	}



	public WebElement getSubCategoryDropdown() {
		return SubCategoryDropdown;
	}



	public WebElement getProductNameEdt() {
		return ProductNameEdt;
	}



	public WebElement getProductCompanyEdt() {
		return ProductCompanyEdt;
	}



	public WebElement getProductPricebdEdt() {
		return ProductPricebdEdt;
	}



	public WebElement getProductPriceEdt() {
		return ProductPriceEdt;
	}



	public WebElement getProductDescrptionEdt() {
		return ProductDescrptionEdt;
	}



	public WebElement getProductShippingcharge() {
		return ProductShippingcharge;
	}



	public WebElement getProductAvailabilityDropdown() {
		return ProductAvailabilityDropdown;
	}



	public WebElement getInsertBtn() {
		return InsertBtn;
	}
	
	//Business Library
	
	public void insertProduct(WebDriverUtility wLib,WebDriver driver,ExcelUtility eLib,JavaUtility jLib,String CategoryValue, String subcategoryvalue) throws Throwable
	
	{
		
	wLib.select(CategoryValue, CategoryNameDropdown);
	Thread.sleep(2000);
	wLib.select(subcategoryvalue, SubCategoryDropdown);
	Thread.sleep(2000);
	
	HashMap<String, String> map = eLib.readMultipleData("ProductDetails");
	
	for(Entry<String, String> set: map.entrySet())					//get data from map
	
		{
		driver.findElement((By.name(set.getKey()))).sendKeys(set.getValue());
		}
	
	wLib.select(ProductAvailabilityDropdown, "In Stock");
	
	String[] imagePaths = {"./PdtImg/Img1.png", "./PdtImg/Img2.png", "./PdtImg/Img3.png"};

		int inputNumber = 1;
		for (String imagePath : imagePaths) {
	    File imageFile = new File(imagePath);
	    String absolutePath = imageFile.getAbsolutePath();
	    String inputName = "productimage" + inputNumber;
	    WebElement inputFile = driver.findElement(By.xpath("//input[@name='" + inputName + "']"));
	    inputFile.sendKeys(absolutePath);
	    inputNumber++;
	}

		InsertBtn.click();
	}

}
