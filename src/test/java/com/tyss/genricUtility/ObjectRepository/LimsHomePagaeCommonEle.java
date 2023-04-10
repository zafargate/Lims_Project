package com.tyss.genricUtility.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LimsHomePagaeCommonEle {
	
	public LimsHomePagaeCommonEle(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='CLIENTS']")   private  WebElement moduleBtn;
	 
	@FindBy(xpath = "//a[@title='Logout']")             private  WebElement LogoutBtn;
	
	
	
	//Bissness Logic
	public void clickOnClientsBtn() {
		moduleBtn.click();
	}
		 
	public void clickOnLogoutBtn() {
		 LogoutBtn.click();
	}
	
	 
	

	
	
}
