package com.tyss.genricUtility.Miscl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * @author khanz
 *
 */
public class IntractionUtility {

	private Actions act;
	
	
	/**
	 * 
	 * @param driver
	 */
	public IntractionUtility(WebDriver driver) {
		act = new Actions(driver);
	}
	
	/**
	 * 
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		act.moveToElement(element).perform();
	}
	
	/*
	 * 
	 */
	public void doubbleClick(WebElement element) {
		act.doubleClick(element).perform();
	}
	
	/**
	 * 
	 * @param element
	 */
	public void rightClick(WebElement element) {
		act.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @param element
	 */
	public void enter() {
		act.keyDown(Keys.ENTER).perform();
	}
	
	/**
	 * 
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragAndDrop(WebElement srcElement,WebElement targetElement) {
		act.dragAndDrop(srcElement, targetElement) .perform();
	}
	
	
	
}
