package com.tyss.genricUtility.ObjectRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage {

	WebDriver driver;
	private String addNomineeTxf = "//input[@name='%s']";
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;

	/**
	 * 
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	WebElement convertToWebElement(String addNomineeTxf, String replaceData) {
		String xpath = String.format(addNomineeTxf, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	/**
	     * 
	     * @param driver
	     */
	    //initialization
	    public FaceBookPage(WebDriver driver) {
	    	this .driver=driver;
	    	PageFactory.initElements(driver, this);
	    }

	// Business Logic

	public void addFaceBookKey(Map<String, String> addNomineeInformatio) {
		for (Entry<String, String> keyValue : addNomineeInformatio.entrySet()) {
			convertToWebElement(addNomineeTxf, keyValue.getKey()).sendKeys(keyValue.getValue());

		}
	}

	public void clickOnSubmitBtn() {
		submitBtn.click();
	}

}
