package com.tyss.genricUtility.WebAction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowPopupUtility {
     
	  /**
     * 
     * @param driver
     * @param partialWindowTitle
     */
    /*Get WimdowHandles method*/

    public void getWindowHandles(WebDriver driver,String partialWindowTitle){
       Set<String> allLinks =driver.getWindowHandles();
       Iterator<String> it=allLinks.iterator();

        while(it.hasNext()) {
            String wID = it.next();
            driver.switchTo().window(wID);
            String currentWindowTittle = driver.getTitle();
            if (currentWindowTittle.contains(partialWindowTitle)) {
                break;
            }
        }
    }
    
    /**
     * 
     * @param driver
     * @param partialWindowTitle
     */
    public void switchToWindow(WebDriver driver , String partialWindowTitle){
        Set<String> set=driver.getWindowHandles();
        Iterator<String> it=set.iterator();

        while(it.hasNext()) {
            String wID = it.next();
            driver.switchTo().window(wID);
            String currentWindowTittle = driver.getTitle();
            if (currentWindowTittle.contains(partialWindowTitle)) {
                break;
            }
        }
    }
    
    
}
