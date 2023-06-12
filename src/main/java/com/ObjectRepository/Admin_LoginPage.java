package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_LoginPage {
	
	//declaration
	
	@FindBy(name="username")
	private WebElement usernameEdt;
	
	@FindBy (name="password")
	private WebElement passwordEdt;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	
	//initialization
	
	public Admin_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSumbmitBtn() {
		return submitBtn;
	}
	
	//business libraries
	
	public void login(String USERNAME, String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		submitBtn.click();
		
	}
	
	
	
	
	
	

}
