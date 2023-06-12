package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;

public class User_HomePage{
	
	@FindBy(xpath="//li[@class='active dropdown yamm-fw']")
	private WebElement HomeLink;
	
	@FindBy(xpath="//a[.='My Account']")
	private WebElement MyAccountLink;
	
	@FindBy(xpath="//a[.='Wishlist']" )
	private WebElement WishListLink;
	
	@FindBy(xpath="//a[.='My Cart']")
	private WebElement MyCartLink;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement LoginLink;
	
	@FindBy(xpath = "//span[contains(.,'Track Order')]")
	private WebElement trackOrder;
	
	@FindBy(name = "product")
	private WebElement searchTF;
	
	@FindBy(xpath = "//button[@name = 'search']")
	private WebElement searchbtn;
	
	@FindBy(xpath = "(//a[contains(text(),'womens')])[1]")
	private WebElement clkCategory;
	
	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement LogoutLink;
	
	
	//initialization
	
	public User_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//utilization
	
	
	public WebElement getHomeLink() {
		return HomeLink;
	}
	public WebElement getMyAccountLink() {
		return MyAccountLink;
	}

	public WebElement getWishListLink() {
		return WishListLink;
	}
	public WebElement getMyCartLink() {
		return MyCartLink;
	}
	public WebElement getLoginLink() {
		return LoginLink;
	}
	public WebElement getTrackOrder() {
		return trackOrder;
	}
	public WebElement getSearchTF() {
		return searchTF;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public WebElement getClkCategory() {
		return clkCategory;
	}
	public WebElement getLogoutLink() {
		return LogoutLink;
	}


	//business Libraries
	public void clickOnLogoutLink() {
		LogoutLink.click();
	}
		public void MyCartBtn() {
		MyCartLink.click();
	}
	public void clickonWishlistLink() {
		WishListLink.click();
	}
	public void clickOnMyAccountLink() {
		MyAccountLink.click();
	}
	public void TrackOrder() {
		trackOrder.click();
	}
	 
	public void SearchProductTF(ExcelUtility eLib) throws Throwable
	{
		String data = eLib.readDataFromExcel("SubCategory",0,1);
		searchTF.sendKeys(data);
		searchbtn.click(); 
	}
	public void clickOnLoginLink() {
		LoginLink.click();
	}
	public void clkCategory() {
		clkCategory.click();
	}
}