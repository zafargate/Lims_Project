package com.tyss.genricUtility.WebAction;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertPopupUtility {
    
    /**
     * 
     * @param driver
     */
    /* All Popup Window Method */
    public void switchToAlertWindowAndAccept(WebDriver driver){
        driver.switchTo().alert().accept();
    }
    
    /**
     * 
     * @param driver
     */
    public void switchToAlertWindowAndCancel(WebDriver driver){
        driver.switchTo().alert().dismiss();
    }
    
    /**
     * 
     * @param pathOfTheFile
     * @return
     */
    public String getabsolutePath(String pathOfTheFile){
        File fil=new File(pathOfTheFile);
        String path=fil.getAbsolutePath();
        return path;
    }
     
    /**
     * 
     * @param driver
     * @return
     */
     public  String getAlertText(WebDriver driver){
         Alert alert = driver.switchTo().alert();
         String text=alert.getText();
         return text;
     }
     
     public void setDataToAlert(WebDriver driver,String data){
         driver.switchTo().alert().sendKeys(data); 
     }
}
