package com.tyss.genricUtility.WebAction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ListBoxHandlingUtility {
       
	 
    /**
     * This Method is Used to single drop Down by Text
     * @param element
     * @param value
     */
  
    public void selectByText(WebElement element,String value){
        Select s= new Select(element);
        s.selectByVisibleText(value);
    }
    /**
     * This Method is Used to single drop Down by index
     * @param element
     * @param index
     */
    public void selectByIndex(WebElement element,int index){
        Select s= new Select(element);
        s.selectByIndex(index);
    }
    
    /**
     * This Method is Used to single drop Down by Value
     * @param element
     * @param valu
     */
    public void selectByValue(WebElement element,String valu){
        Select s= new Select(element);
        s.selectByValue(valu);
    }
    
    /**
     * 
     * @param element
     * @param valu
     */
    public void getOption(WebElement element,String valu){
        Select s= new Select(element);
        s.getOptions();
    }
    
    /**
     * 
     * @param element
     * @param valu
     */
    public void getWrrapedElement(WebElement element,String valu){
        Select s= new Select(element);
        s.getWrappedElement();
    }
    
    /**
     * 
     * @param element
     * @param valu
     */
    public void getDeselectAll(WebElement element,String valu){
        Select s= new Select(element);
         s.deselectAll();
    }
    
    /**
     * 
     * @param element
     * @param valu
     */
    public void getAllSelectedOptions(WebElement element,String valu){
        Select s= new Select(element);
        s.getAllSelectedOptions();
    }
}
