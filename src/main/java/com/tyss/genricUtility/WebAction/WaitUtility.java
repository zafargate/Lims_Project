package com.tyss.genricUtility.WebAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author khanz
 *
 */
public class WaitUtility {
	private WebDriverWait wait;
	private WebDriver driver;

	public WaitUtility(WebDriver driver,long timeout) {
		this.driver=driver;
		wait=new WebDriverWait(driver, 10);
	}
	
	
	public WaitUtility() {}
	
/**
  * 
  * @param miliSecond
  * 
  */
	public void pause(Long miliSecond) {
		try {
			Thread.sleep(miliSecond);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param TimeOut
	 */
	public void waitElementLoad(WebDriver driver,Long TimeOut) {
		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @param driver
	 * @param xpath
	 */
	public void waitUntilVisible(String xpath) {
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
	}
	
	/**
	 * 
	 * @param driver
	 * @param xpath
	 */
	public void waitUntilClikable(String xpath) {
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}
	
	/**
	 * 
	 * @param driver
	 * @param xpath
	 */
	public void waitUntilUntilInvisible(String xpath) {
		 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
	}
	
    /**
     * 
     * @param text
     * @param xpath
     */
	public void waitUntilInvisibleOfText(String text,String xpath) {
		 wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath),text));
	}
	
	/**
	 * 
	 * @param xpath
	 */
	public void visibilityOf(String xpath) {
		// TODO Auto-generated method stub
		 wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath(xpath))));
	}
	
	/**
	 * 
	 * @param pollingTime
	 * @param duration
	 * @param element
	 */
	public void waitUntilClick(long pollingTime, int duration,WebElement element)   {
		int count=0;
		while(count<duration) {
			try {
			element.click();
			}catch(Exception e) {
				try {
					Thread.sleep(pollingTime);
					count++;
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	}
	
	
	
}
