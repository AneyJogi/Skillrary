package com.ObjectRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class User_PaymentMethodpage {

		//Declaration
		@FindBy(xpath = "//input[@value='COD']")
		private WebElement clkCODPaymentOptions;
		
		@FindBy(xpath = "//input[@value='Internet Banking']")
		private WebElement clkInternetBankingOptions;
		
		@FindBy(xpath = "//input[@value='Debit / Credit card']")
		private WebElement clkDebitCardOptions;
		
		@FindBy(name = "submit")
		private WebElement clkSubmitBtn;
		
		//Utilization
		public WebElement getClkCODPaymentOptions() {
			return clkCODPaymentOptions;
		}
		public WebElement getClkInternetBankingOptions() {
			return clkInternetBankingOptions;
		}
		public WebElement getClkDebitCardOptions() {
			return clkDebitCardOptions;
		}
		public WebElement getClkSubmitBtn() {
			return clkSubmitBtn;
		}
		
		
		//initialization
		public User_PaymentMethodpage(WebDriver driver) {
	       	PageFactory.initElements(driver, this);
	           }
		
		//business Libraries
		public void clickCODPaymentOptions() {
			clkCODPaymentOptions.click();
		}
		public void clickInternetBankingOptions() {
			clkInternetBankingOptions.click();
		}
		public void clickDebitCardOptions() {
			clkDebitCardOptions.click();
		}
		public void clickSubmitBtn() {
			clkSubmitBtn.click();
		}
		
		
	}


