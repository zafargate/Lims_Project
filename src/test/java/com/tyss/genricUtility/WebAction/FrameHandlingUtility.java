package com.tyss.genricUtility.WebAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandlingUtility {

	
	 /**
     * 
     * @param driver
     * @param index
     */
    public void switchToFram(WebDriver driver,int index){
        driver.switchTo().frame(index);
    }
    
    /**
     * 
     * @param driver
     * @param attribute
     */
    public void switchToFrame(WebDriver driver,String attribute){
        driver.switchTo().frame(attribute);
    }
    
    /**
     * 
     * @param driver
     * @param element
     */
    public void switchToFrame(WebDriver driver,WebElement element){
        driver.switchTo().frame(element);
    }
    
    /**
     * 
     * @param driver
     */
    public void switchToDefoulCOntent(WebDriver driver){
        driver.switchTo().defaultContent();
    }
    
    /**
     * 
     * @param driver
     */
    public void switchToParentFrame(WebDriver driver){
        driver.switchTo().parentFrame();
    }


}
