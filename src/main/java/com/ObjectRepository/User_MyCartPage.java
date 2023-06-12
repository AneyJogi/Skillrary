package com.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;

public class User_MyCartPage {

	
	@FindBy(xpath = "//a[.='Home']")
	private WebElement homeBtn;
	
	@FindBy(name="remove_code[]")
	private WebElement removeProductFromMyCart;
	
	@FindBy(xpath = "//td/div/input[@type='text']")
	private WebElement UpdateQquatity;
	
	@FindBy(name="ordersubmit")
	private WebElement clkCheckOutBtn;
	
	@FindBy(name = "billingaddress")
	private WebElement billAddress;
	
	@FindBy(name = "bilingstate")
	private WebElement billState;
	
	@FindBy(name = "billingcity")
	private WebElement billCity;
	
	@FindBy(name = "billingpincode")
	private WebElement billPinCode;
	
		@FindBy(name = "update")
	private WebElement clkUpdateBtn;
		
	
	
	public WebElement getRemoveProductFromMyCart() {
			return removeProductFromMyCart;
		}

		public WebElement getUpdateQquatity() {
			return UpdateQquatity;
		}

		public WebElement getClkCheckOutBtn() {
			return clkCheckOutBtn;
		}

		public WebElement getBillAddress() {
			return billAddress;
		}

		public WebElement getBillState() {
			return billState;
		}

		public WebElement getBillCity() {
			return billCity;
		}

		public WebElement getBillPinCode() {
			return billPinCode;
		}

		public WebElement getClkUpdateBtn() {
			return clkUpdateBtn;
		}

	public WebElement getHomeBtn() {
		return homeBtn;
	}
	
	public  User_MyCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void removeProductFromMyCart() {
		removeProductFromMyCart.click();
	}

	public void updateQquatity() {
	UpdateQquatity.click();
	}

	public void clkCheckOutBtn() {
		clkCheckOutBtn.click();
	}
public void changeBillingAddress(WebDriver driver, ExcelUtility eLib,String address,String state,String city,String pinCode) throws Throwable {
	
	HashMap<String, String> map = eLib.readMultipleData("Billing&Shipping");
	
	for(Entry<String, String> set: map.entrySet())					//get data from map
	{
		{
			driver.findElement((By.name(set.getKey()))).sendKeys(set.getValue());
		}
	}
	
	
	billAddress.sendKeys(address);
	billState.sendKeys(state);
	billCity.sendKeys(city);
	billPinCode.sendKeys(pinCode);
	clkUpdateBtn.click();
}

	public void clkHomeBtn() {
		homeBtn.click();
	}
}

