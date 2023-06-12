package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility  {
	 

	/**
	 * This method is used to maximize window
	 * @param driver
	 * @author alwin
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		 driver.manage().window().maximize();
				 
	}
 
	/**
	 * This method is used to wait for the page load
	 * @param driver
	 *
	 */
	public void waitForPageLoad(WebDriver driver)
	{
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to wait until element is visible
	 * @param driver
	 * @param element
	 */
	
	public void elementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait until element is clickable
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * This method will select data from dropdown using value
	 * @param element
	 * @param value
	 */
	
	public void select(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will select data from dropdown using index
	 * @param element
	 * @param value
	 */
	
	
	public void select(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will select data from dropdown using visibleText
	 * @param element
	 * @param value
	 */
	public void select(String visibleText,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * this method will perform Drag and drop action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions act= new Actions(driver);
		act.dragAndDrop(src,dst).perform();
	}
	
	
	/**
	 * this method will perform mousehover action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void mousehover(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * this method will perform doubleClick action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}
	
	
	/**
	 * this method will perform rightClick action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
		
	}
	
	/**
	 * This method is used to press enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act= new Actions(driver);
	    act.sendKeys(Keys.ENTER).perform();
		
	}
	
	/**
	 * This method is used to press enter key
	 * @param driver
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to release key
	 * @param driver
	 */
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to switch frame using index
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch frame using nameOrID
	 * @param driver
	 * @param nameOrID
	 */
	 
	 
	public void switchToFrame(WebDriver driver,String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method is used to switch frame using address
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 *  This method is used to acceptAlert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/** 
	 * This method is used to dismiss Alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to switch to another window
	 * @param driver 
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver,String partialTitle)
	{
		//Step1: use getWindowHandle to capture all window ids's
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//Step3: check whether there is next window
		while(it.hasNext())
		{
			//Step4: capture current window id
			String winId = it.next();
			
			//Step5:switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle(); 
			
			//Step6:check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{ 
				break;
			}
		}
	}
	
		
		public static String getScreenShot(WebDriver driver,String screenShotName) throws Throwable
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			 File src = ts.getScreenshotAs(OutputType.FILE);
			String path = ".\\screenshot\\"+screenShotName+".png";
			File dst= new File(path);
			FileUtils.copyFile(src, dst);
			return dst.getAbsolutePath(); 
		}
		

		/** 
		 * This method will perform random scroll
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver)
		{
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0, 800)", "");
		}
		
		/**
		 * This method will scroll until particular element is found
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js =(JavascriptExecutor)driver;
			int y=element.getLocation().getY();
			js.executeScript("window.scrollBy(0, "+y+")", element);
			//jse.executeScript("argument[0].scrollIntoView()",element);
		}
		

		}
	
	
	
	


