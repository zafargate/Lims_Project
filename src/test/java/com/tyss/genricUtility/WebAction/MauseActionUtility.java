package com.tyss.genricUtility.WebAction;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MauseActionUtility {

	
    /**
     * 
     * @param driver
     * @param element
     */
    /*Actions Class method */
    public void mouseOverOnElement(WebDriver driver,WebElement element){
        Actions act=new Actions(driver);
        act.moveToElement(element).perform();
    }
    
    /**
     * 
     * @param driver
     * @param element
     */
    public void contextClick(WebDriver driver,WebElement element){
        Actions act=new Actions(driver);
        act.contextClick(element).perform();
    }
    
    /**
     * 
     * @param driver
     * @param element
     */
    public void doubbleClick(WebDriver driver,WebElement element){
        Actions act=new Actions(driver);
        act.doubleClick(element).perform();
    }
    
    /**
     * 
     * @param driver
     * @param src
     * @param dest
     */
    public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest){
        Actions act=new Actions(driver);
        act.dragAndDrop(src,dest).perform();
    }
    
    /**
     * 
     * @param driver
     */
    public void passEnterKey(WebDriver driver){
        Actions act=new Actions(driver);
        act.sendKeys(Keys.ENTER);
    }
}
