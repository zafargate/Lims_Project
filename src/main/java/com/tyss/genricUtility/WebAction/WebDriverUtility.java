package com.tyss.genricUtility.WebAction;
import org.apache.xmlbeans.impl.values.JavaStringHolder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebDriverUtility {
	 
	
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
        
	    /**
	     * 
	     * @param driver
	     * @param element
	     * @param pollingTime
	     * @throws InterruptedException
	     */
	    public void waitToWindow(WebDriver driver ,WebElement element,int pollingTime) throws InterruptedException {
	        FluentWait wait=new FluentWait(driver);
	        wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
	        wait.wait(20);
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }
        
	    /**
	     * 
	     * @param driver
	     * @param element
	     * @throws InterruptedException
	     */
	    public void cutemizeWait(WebDriver driver,WebElement element) throws InterruptedException {
	        int count=0;
	        while(count<20){
	            try{
	                element.click();
	            }catch(Throwable e){
	                Thread.sleep(1000);
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




        /**
         * 
         * @param element
         * @param value
         */
	  
	    public void selectByText(WebElement element,String value){
	        Select s= new Select(element);
	        s.selectByVisibleText(value);
	    }
        /**
         * 
         * @param element
         * @param index
         */
	    public void selectByIndex(WebElement element,int index){
	        Select s= new Select(element);
	        s.selectByIndex(index);
	    }
        
	    /**
	     * 
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

        /**
         * 
         * @param driver
         * @param javaScript
         */
	    /* java Script executer method*/

	    public void executeJavaScript(WebDriver driver,String javaScript){
	        JavascriptExecutor js=(JavascriptExecutor) driver;
	        js.executeScript(javaScript,null);
	    }

	    public void takeScreenShot(WebDriver driver, String screenshootName){
	        TakesScreenshot ts=(TakesScreenshot)driver;
	        File src=ts.getScreenshotAs(OutputType.FILE);
	        File dest=new File("./screenshot/"+screenshootName+".PNG");
	        //Files.copyFile(src,dest);
	    }
        
	    /**
	     * 
	     * @param driver
	     * @param javaScript
	     */
	    public void handliScrollBar(WebDriver driver,String javaScript){
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        js.executeScript(javaScript);
	    }
         
	    /**
	     * 
	     * @param driver
	     * @param partialWindowTitle
	     */
	    /*Get WimdowHandles method*/

	    public void grtWindowHandles(WebDriver driver,String partialWindowTitle){
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
	     * @return
	     */
	    public String getWindowHandle(WebDriver driver){
	        String index=driver.getWindowHandle();
	        return index;
	    }
        
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

 

	}



