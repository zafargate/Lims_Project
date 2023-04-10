package com.tyss.genricUtility.WebAction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.tyss.genricUtility.ConfigerClass.MainClass;
import com.tyss.genricUtility.Miscl.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author khanz
 *
 */
public class SeleniumUtility {
	 
	JavaUtility javaUtitlity;
    JavascriptExecutor js;
    TakesScreenshot ts;
    WebDriver driver;
	
	/**
	 * 
	 * @param browser
	 * @return
	 */
    public SeleniumUtility() {
 	  
    }
    /**
     * 
     * @param browser
     * @return
     */
	public WebDriver lounchBrowser(String browser) {
		
		switch (browser) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}

		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		case "ie": {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}

		case "edge": {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		default: {
			System.out.println("Enter proper key");
		}
		}

		return driver;
	}
	
	public WebDriver lounchBrowser(String browser,String s) {

		switch (browser) {
		case "chrome": {
			if (s.equalsIgnoreCase("option")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable.notifications");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
		}
		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		case "ie": {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}

		case "edge": {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		default: {
			System.out.println("Enter proper key");
		}
		}

		return driver;
	}

	/**
	 * 
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	/**
	 * 
	 * @param url
	 */
	public void launchApplication(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		 
	}
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	public void resizeBrowser(int width,int height) {
		driver.manage().window().setSize(new Dimension(width,height));
	}
	
	/**
	 * 
	 */
	public void closeBrowser() {
		driver.quit();
	}
	
	/**
	 * 
	 */
	public void closeTab() {
		driver.close();
	}
  
	/**
	 * 
	 * @return
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl(); 
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle(); 
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPageSource() {
		return driver.getPageSource(); 
	}
	
    /**
     * This will be take ScreenShort page wise
     * @param driver
     * @param screenshootName
     * @throws  
     */
    public String takeScreenShot( String testCaseName,JavaUtility javaUtility) {
    	  ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File dest=new File("./screenshot/"+testCaseName+""+ javaUtility.getSimpleDateFormate()+".PNG");
        try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return dest.getAbsolutePath();
    }
    
    /**
     * As Element Name Wise 
     * @param eleement
     * @param eleName
     * @param javaUtility
     * @return
     */
    public String takeScreenShot(  WebElement eleement, String eleName,JavaUtility javaUtility) {
    	  ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File dest=new File("./screenshot/"+eleName+""+ javaUtility.getSimpleDateFormate()+".PNG");
        try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return dest.getAbsolutePath();
    }
    /**
     * 
     * @return
     */
	public String takeScreenShot() {
		TakesScreenshot	ts=(TakesScreenshot)driver;
	    String path=ts.getScreenshotAs(OutputType.BASE64);
	    return path;
	}
	
	public static void main(String[] args) {
		SeleniumUtility s=new  SeleniumUtility();
	}
	 

	 
	 
}
