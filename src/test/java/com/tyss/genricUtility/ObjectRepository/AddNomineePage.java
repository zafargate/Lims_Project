package com.tyss.genricUtility.ObjectRepository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genricUtility.Miscl.VerificationUtility;

public class AddNomineePage {

	private WebDriver driver;

	private String addNomineeTxf = "//input[@name='%s']";
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;
	@FindBy(xpath = "//a[@class='btn']")
	private WebElement addNomineeBtn;
	@FindBy(xpath = "//tbody/tr/td[text()='name']")
	private List<WebElement> allTableElements;

	

	public void clickOnAddNominee() {
		addNomineeBtn.click();
	}

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
	// initialization
	public AddNomineePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Business Logic

	public void addNomineeSendKey(Map<String, String> addNomineeInformatio) {
		for (Entry<String, String> keyValue : addNomineeInformatio.entrySet()) {
			convertToWebElement(addNomineeTxf, keyValue.getKey()).sendKeys(keyValue.getValue());

		}
		submitBtn.click();
	}
	public boolean verifyNominee(VerificationUtility verificationUtility) {
	    return verificationUtility.tableVerifationData(allTableElements, "AddNominee");
		}

}
