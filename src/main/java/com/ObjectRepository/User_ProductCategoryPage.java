package com.ObjectRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class User_ProductCategoryPage {

		@FindBy(xpath = "//a[.=' womens']")
		private WebElement clkSubCategoryShirts;

		@FindBy(xpath = "//a[contains(text(),'t-shirts')]")
		private WebElement clkSubCategoryTshirts;

		@FindBy(xpath = "//a/img[1]")
		private WebElement clkProduct;

		@FindBy(xpath = "(//a/i[@class='icon fa fa-heart'])[2]")
		private WebElement clkWishlistBtn;

		@FindBy(xpath = "(//a/button[contains(text(),'Add to cart')])[1]")
		private WebElement clkAddToCartBtn;

		public WebElement getClkSubCategoryShirts() {
			return clkSubCategoryShirts;
		}

		public WebElement getClkSubCategoryTshirts() {
			return clkSubCategoryTshirts;
		}

		public WebElement getClkProduct() {
			return clkProduct;
		}

		public WebElement getClkWishlistBtn() {
			return clkWishlistBtn;
		}

		public WebElement getClkAddToCartBtn() {
			return clkAddToCartBtn;
		}
		public User_ProductCategoryPage(WebDriver driver) {
	       	PageFactory.initElements(driver, this);
	           }
		
		public void clkSubCategoryShirts() {
			clkSubCategoryShirts.click();
		}

		public void clkSubCategoryTshirts() {
			clkSubCategoryTshirts.click();
		}

		public void clkProduct() {
			clkProduct.click();
		}

		public void clkWishlistBtn() {
			clkWishlistBtn.click();
		}

		public void clkAddToCartBtn() {
			clkAddToCartBtn.click();
		}


	}


