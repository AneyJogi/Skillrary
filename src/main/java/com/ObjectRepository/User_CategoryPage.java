package com.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_CategoryPage {
	
	@FindBy(xpath="//a[contains(.,' 5 Folds')]")
	private WebElement SubCategoryLink;

}
