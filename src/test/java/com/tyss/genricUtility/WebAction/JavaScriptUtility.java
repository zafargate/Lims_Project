package com.tyss.genricUtility.WebAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tyss.genricUtility.Miscl.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptUtility {
      JavaUtility javaUtitlity;
      JavascriptExecutor js;
      TakesScreenshot ts;
      WebDriver driver;
	 /**
     * 
     * @param driver
     * @param javaScript
     */
    /* java Script executer method*/
      
     public JavaScriptUtility(WebDriver driver){
    	    js=(JavascriptExecutor) driver;
    	    ts=(TakesScreenshot)driver;
      }

    public void executeJavaScript(WebDriver driver,String javaScript){
        
        js.executeScript(javaScript,null);
    }
  

    
    /**
     * 
     * @param driver
     * @param width
     * @param height
     */
    public void custemizeScroll(int width,int height){
    	js.executeScript("window.scrollBy("+height+","+width+")");       
    }
    
    /**
     * 
     * @param driver
     */
    public void scrolDown(){ 
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");   
    } 
    
    /**
     * 
     * @param driver
     */
    public void scrolUp(){
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    } 
    
    /**
     * 
     * @param driver
     */
    public void scrolRight(){
        js.executeScript("window.scrollTo(document.body.scrollWidth,0)");
    } 
    
    /**
     * 
     * @param driver
     */
    public void scrolLeft(){
        js.executeScript("-window.scrollTo(document.body.scrollWidth,0)");
    } 
    
    /**
     * 
     * @param driver
     * @param locOfElement
     */
    public void scrollOnElement(WebElement element){
        js.executeScript("window.scrollTo(0,"+element+")");
    }
    
    /**
     * 
     * @param driver
     * @param element
     */
    public void scrollTillElement(WebElement element) {
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    /**
     * 
     * @param driver
     * @param element
     */
    public void click(WebElement element) {
    	js.executeScript("arguments[0].click();", element);
    }
    
    /**
     * 
     * @param driver
     * @param element
     */
    public void sendKey( WebElement element,String data) {
    	js.executeScript("arguments[0].value='"+data+"'",element);
    }
    
    /**
     * 
     * @param driver
     * @param element
     * @param data
     */
    public void launchApplication(WebElement element,String data) {
    	js.executeScript("window.location=arguments[0]", element,data);
    }
    
    public String getTitleByJs() {	
    	return  js.executeScript("return document.title;").toString();
    }
    
    public void genrateAlertJs(String massage) {
    	js.executeScript("alert('"+massage+"')");
    }
    
    public void refreshBrowserByJs() {
    	js.executeScript("history.go(0)");
    }
    
    
   
    public static void main(String[] args) throws InterruptedException {
    	
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver=new ChromeDriver();
    	 JavascriptExecutor js1 = (JavascriptExecutor) driver;
    	JavaScriptUtility  j=new JavaScriptUtility(driver);
    	driver.get("https://www.bbc.com/");
    	WebElement ele = driver.findElement(By.xpath("//a[@id='idcta-link']"));
    	WebElement ele1 = driver.findElement(By.xpath("//ul[@class='international']//li[@class='orb-nav-homedotcom']//a"));
    	 j.click(ele);
    	 Thread.sleep(3000);
    	WebElement ele5=driver.findElement(By.xpath("//input[@id='user-identifier-input']"));
    	
    	//js1.executeScript("arguments[0].value='admin'", ele5);
    	j.sendKey(ele5, "admin");
//    	js1.executeScript("arguments[0].style.border='3px solid red'", ele);
//    	 System.out.println(ele1.getText());
//    	j.scrollTillElement(ele1);
//    	System.out.println( j.getTitleByJs());
//    	j.genrateAlertJs("Alert");
//    	j.refreshBrowserByJs();
    	
//    	 Thread.sleep(2000);
//    	j.scrolDown();
//    	Thread.sleep(2000);
//    	j.scrolUp();
//    	
        
//        j.scrollTillElement(ele);
        
        j.sendKey(ele5,"admin");
//        WebElement ele2=driver.findElement(By.xpath("//input[@id='password-input']"));
//        j.sendKey(ele2,"admin");
////        WebElement ele3=driver.findElement(By.xpath("//input[@id='password-input']"));
////        j.sendKey(ele3);
//        WebElement ele4=driver.findElement(By.xpath("//button[@id='submit-button']"));
//        j.click(ele4);
    	
    	
	}
}
