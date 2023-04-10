package com.tyss.genricUtility.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genricUtility.Enum.CommonModuleName;
import com.tyss.genricUtility.Enum.TabNames;

public class CommonPage {
  
	
    private WebDriver driver;
    
    private String tabPartialXpath="//a[.='%s']";
    private String modulePartialXpath="//a[normalize-space()='%s']";
    
    
    /**
     * 
     * @param partialXpath
     * @param replaceData
     * @return
     */
    private WebElement convertToWebElement(String modulePartialXpath,String replaceData) {
    	String xpath = String.format(modulePartialXpath, replaceData);
    	return driver.findElement(By.xpath(xpath));
    }
    
    
    /**
     * 
     * @param driver
     */
    //initialization
    public CommonPage(WebDriver driver) {
    	this .driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    //Business Logic
    public void clickTab(TabNames tabName) {
    	convertToWebElement(tabPartialXpath,tabName.getTab()).click();
    }
    
    
    public void clickOnModule(CommonModuleName module) {
    	convertToWebElement(tabPartialXpath,module.getModule()).click();
    }
}
