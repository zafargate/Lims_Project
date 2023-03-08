package com.tyss.genricUtility.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author khanz
 *
 */
 public class LimsLoginPage {
	// declaration
	// this is work as a || oprator with all locator
	@FindAll({@FindBy(name=""),@FindBy(id=""),@FindBy(xpath="")})private WebElement usernameTextField1;
	// This is also same as Find All But it work as && Oprator all Locator
	@FindBys({@FindBy(name=""),@FindBy(id=""),@FindBy(xpath="")}) private WebElement usernameTextField2; 
	@FindBy(xpath = "//input[@placeholder='username']")
	private WebElement usernameTextField;
	@FindBy(xpath = "(//input[@placeholder='password'])[1]")
	private WebElement passwordTextField;
	@FindBy(xpath = "//button[normalize-space()='login']")
	private WebElement loginBtn;
	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement logoutBtn;

	
	//initialization of the Elemenet
	public LimsLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	// UtiLization In Bissness logic
	public void loginAction(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginBtn.click();
	}

	/**
	 * 
	 */
	public void clickOnLogOutBtn() {
		logoutBtn.click();
	}
}
