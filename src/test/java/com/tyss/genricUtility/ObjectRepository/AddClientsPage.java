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

public class AddClientsPage {

	private WebDriver driver;

	private String addNomineeTxf = "//input[@name='%s']";

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;
	@FindBy(xpath = "//button")
	private WebElement AddClientBtn;
	@FindBy(xpath="//tbody/tr/td[2]")
	private List<WebElement> addClientTable;

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
	public AddClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Business Logic

	public void addNomineeSendKey(Map<String, String> addNomineeInformatio) {
		for (Entry<String, String> keyValue : addNomineeInformatio.entrySet()) {
			convertToWebElement(addNomineeTxf, keyValue.getKey()).sendKeys(keyValue.getValue());

		}
	}

	public void addClientSendKey(Map<String, String> addClientInformatio) {
		for (Entry<String, String> keyValue : addClientInformatio.entrySet()) {
			convertToWebElement(addNomineeTxf, keyValue.getKey()).sendKeys(keyValue.getValue());

		}
		submitBtn.click();
	}
 
	public void clickOnAddClientsBtn() {
		AddClientBtn.click();
	}
	
	 public boolean verifyAddClients(VerificationUtility verificationUtility) {
		    return verificationUtility.tableVerifationData(addClientTable, "AddPayment");
			}


}
