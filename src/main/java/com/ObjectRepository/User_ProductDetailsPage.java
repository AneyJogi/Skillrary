package com.ObjectRepository;

	
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class User_ProductDetailsPage {

		@FindBy(xpath = "//div[5]/div[1]/div[2]/div[1]/a[1]/i[1]")
		private WebElement clkWislistBtn;
		
		@FindBy(xpath = "//a[contains(text(),' ADD TO CART')]")
		private WebElement clkAddToCartBtn;
		
		@FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/i")
		private WebElement increaseTheQuant;
		

		//initialization
		public User_ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		     }
		
		//Utilization
		public WebElement getClkWislistBtn() {
			return clkWislistBtn;
		}

		public WebElement getClkAddToCartBtn() {
			return clkAddToCartBtn;
		}

		public WebElement getIncreaseTheQuant() {
			return increaseTheQuant;
		}
	     
		
		
		public void clkWislistBtn() {
			clkWislistBtn.click();
		}

		public void clkAddToCartBtn() {
			clkAddToCartBtn.click();
		}

		public void increaseTheQuant(WebElement increaseTheQuant) {
			 increaseTheQuant.click();
		}
		
		


}
