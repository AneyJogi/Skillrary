package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_SignInPage{

	
	@FindBy(name="fullname")
	private WebElement FullnameEdt;
	
	@FindBy(name="emailid")
	private WebElement CreateEmailEdt;
	
	@FindBy(name="contactno")
	private WebElement ContactNoEdt;
	
	@FindBy(name="password")
	private WebElement CreatePasswordEdt;
	
	@FindBy(name="confirmpassword")
	private WebElement ConfirmPasswordEdt;
	
	@FindBy(xpath="//button[.='Sign Up']")
	private WebElement SignUpBtn;
	
//=======================================================

	@FindBy(xpath="//div[@class='col-md-6 col-sm-6 sign-in']/child::form/div[1]/input[@name='email']")
	private WebElement EmailEdt;
	
	@FindBy(xpath="//input[@id='exampleInputPassword1']")
	private WebElement LoginPasswordEdt;
	
	@FindBy(xpath="//button[.='Login']")
	private WebElement LoginBtn;
	
	
	//initialization
	
	public  User_SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization

	public WebElement getFullnameEdt() {
		return FullnameEdt;
	}
	public WebElement getCreateEmailEdt() {
		return CreateEmailEdt;
	}
	public WebElement getContactNoEdt() {
		return ContactNoEdt;
	}
	public WebElement getCreatePasswordEdt() {
		return CreatePasswordEdt;
	}
	public WebElement getConfirmPasswordEdt() {
		return ConfirmPasswordEdt;
	}
	public WebElement getSignUpBtn() {
		return SignUpBtn;
	}
	public WebElement getEmailEdt() {
		return EmailEdt;
	}
	public WebElement getLoginPasswordEdt() {
		return LoginPasswordEdt;
	}
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	
	
	public void userSignIn(String USERNAME,String PASSWORD)
	{
		
		EmailEdt.sendKeys(USERNAME);
		LoginPasswordEdt.sendKeys(PASSWORD);
		LoginBtn.click();
	}
	
	public void userSignUp(String FN,String USERNAME,String PASSWORD,String contactno)
	{
	
		
		FullnameEdt.sendKeys(FN);
		CreateEmailEdt.sendKeys(USERNAME);
		ContactNoEdt.sendKeys(contactno);
		CreatePasswordEdt.sendKeys(PASSWORD);
		ConfirmPasswordEdt.sendKeys(PASSWORD);
		SignUpBtn.click();
		
		EmailEdt.sendKeys(USERNAME);
		LoginPasswordEdt.sendKeys(PASSWORD);
		LoginBtn.click();
		
	}
	
}
