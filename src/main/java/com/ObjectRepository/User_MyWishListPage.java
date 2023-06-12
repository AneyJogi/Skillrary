package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_MyWishListPage {
	
		//declaration
		@FindBy(xpath = "(//a[contains(text(),'Add to cart')])[1]")
		private WebElement clkAddToCartBtn;

		
		//initialization
		public User_MyWishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
				}
		
		//Utilization
		public WebElement getClkAddToCartBtn() {
			return clkAddToCartBtn;
		}

		//Business Libraries
		public void clkAddToCartBtn() {
			clkAddToCartBtn.click();
		}
	

}
