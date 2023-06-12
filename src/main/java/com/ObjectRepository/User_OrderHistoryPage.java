package com.ObjectRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class User_OrderHistoryPage {
		
		//declaration
		@FindBy(xpath="(//td/a[@title='Track order'])[2]")
		private WebElement clkTrackBtn;
	
		//initialization

		public User_OrderHistoryPage(WebDriver driver) {
	       	PageFactory.initElements(driver, this);
	           }
		
		//Utilization
		public WebElement getClkTrackBtn() {
			return clkTrackBtn;
		}
		
		//business librar
		public void clkTrackBtn() {
		clkTrackBtn.click();
		}
		
		
		
	}

