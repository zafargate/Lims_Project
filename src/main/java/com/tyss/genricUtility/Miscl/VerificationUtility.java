package com.tyss.genricUtility.Miscl;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author khanz
 *
 */
public class VerificationUtility {
	/**
	 * 
	 * @param acthual
	 * @param expected
	 */
	public void exactVerify(String expected, String acthual,String strategy,String pageNameOrTCName) {
		if (acthual.equalsIgnoreCase("TC")) {
		  if(acthual.equalsIgnoreCase(expected)) {
			System.out.println(pageNameOrTCName+"TC is Pass");
			}
		 else {
			System.out.println(pageNameOrTCName+"TC is fail");
		  }
	}
		else if(strategy.equalsIgnoreCase("page")) {
			if(acthual.equals(expected)) {
				System.out.println(pageNameOrTCName+"page Displyed");
			}
			else {
				System.out.println(pageNameOrTCName+"page not Displyed");
			}
		}
		
	}
     /**
      * 
      * @param acthual
      * @param expected
      * @param name
      */
	public void partialVerify(String expected, String acthual,String strategy,String pageNameOrTCName) {
		System.out.println("Actual ==> "+acthual);
		System.out.println("Expected ===> "+expected);
		
		if (strategy.equalsIgnoreCase("TC")) {
			  if(acthual.contains(expected)) {
				System.out.println(pageNameOrTCName+"TC is Pass");
				}
			 else {
				System.out.println(pageNameOrTCName+"TC is fail");
			}
		}
			else if(strategy.equalsIgnoreCase("page")) {
				if(acthual.contains(expected)) {
					System.out.println(pageNameOrTCName+"page Displyed");
				}
				else {
					System.out.println(pageNameOrTCName+"page not Displyed");
				}
			}
	}
	
	public void partialUrlVarify(WebDriver driver,String exp_Url) {
		if(driver.getCurrentUrl().contains(exp_Url)) {
			System.out.println(driver.getTitle()+" is dispaly sucessfully");
		}else {
			System.out.println(driver.getTitle()+" is not dispaly");
		}
	}
	
	public boolean tableVerifationData(List<WebElement> allLink,String name) {
	boolean flag=false;
		for(WebElement link:allLink) {
			String text=link.getText();
			if(text.equals(name)) {
				flag=true;
				break;
			} 
		}
		return flag;
		
	}
	 
}
