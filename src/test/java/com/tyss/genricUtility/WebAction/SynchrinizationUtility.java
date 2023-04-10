package com.tyss.genricUtility.WebAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchrinizationUtility {

    /**
     * 
     * @param driver
     */
    public void waitForPageLoad(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    /**
     * 
     * @param driver
     */
    public void waitForPageLoadJSElement(WebDriver driver){
        driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
    }
    
    /**
     * 
     * @param driver
     * @param element
     */
    public void waitForElementToBeClickable(WebDriver driver, WebElement element){
         WebDriverWait wait=new WebDriverWait(driver,20);
         wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
