package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_HomePage {
	
	
	@FindBy(xpath="//a[.=' Create Category ']" )
	private WebElement CreateCategoryLink;
	
	@FindBy(xpath="//a[.='Sub Category ']" )
	private WebElement SubCategoryLink;
	
	@FindBy(xpath="//a[.='Insert Product ']")
	private WebElement InsertProductLink;
	
	@FindBy(xpath="//a[contains(.,'Manage users')]" )
	private WebElement ManageUsersLink;
	
	@FindBy(xpath="(//a[@href='logout.php'])[1]")
	private WebElement LogoutLink;
	
	@FindBy(xpath="//a[contains(.,'Order Management')]" )
	private WebElement OrderManagementLink;
	
	@FindBy(xpath="//a[@href='todays-orders.php']" )
	private WebElement todaysOrderLink;
	
	@FindBy(xpath="//a[@href='pending-orders.php']" )
	private WebElement pendingOrdersLink;
	
	@FindBy(xpath="//a[@href='delivered-orders.php']" )
	private WebElement deliveredOrderLink;
	
	// initialization
	public Admin_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getCreateCategoryLink() {
		return CreateCategoryLink;
	}

	public WebElement getSubCategoryLink() {
		return SubCategoryLink;
	}

	public WebElement getInsertProductLink() {
		return InsertProductLink;
	}

	public WebElement getManageUsersLink() {
		return ManageUsersLink;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	public WebElement getOrderManagementLink() {
		return OrderManagementLink;
	}

	public WebElement getTodaysOrderLink() {
		return todaysOrderLink;
	}

	public WebElement getPendingOrdersLink() {
		return pendingOrdersLink;
	}

	public WebElement getDeliveredOrderLink() {
		return deliveredOrderLink;
	}
	
	//business Libraries
	
	public void clickOncreateCategoryLink()
	{
		CreateCategoryLink.click();
	}
	
	public void clickOnSubCategoryLink()
	{
		SubCategoryLink.click();
	}
	
	public void clickOnInsertProductLink()
	{
		InsertProductLink.click();
	}

	public void clickOnManageUser()
	{
		ManageUsersLink.click();
	}
	
	public void logOut()
	{
		LogoutLink.click();
	
}
	
}

