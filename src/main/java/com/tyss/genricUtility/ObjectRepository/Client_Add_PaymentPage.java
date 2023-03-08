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

public class Client_Add_PaymentPage {

	WebDriver driver;

	private String addPaymentTxf = "//input[@name='%s']";
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;
	@FindBy(xpath = "//button")
	private WebElement addPaymentBtn;
	@FindBy(xpath="//tbody/tr/td[2]")
	private List<WebElement> addPaymentTable;
	
	/**
	 * 
	 * @param addNomineeTxf
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
	public Client_Add_PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Business Logic
	/**
	 * 
	 * @param addPaymentTxfInfo
	 */
	public void addPaymentKeyValue(Map<String, String> addPaymentTxfInfo) {
		for (Entry<String, String> keyValue : addPaymentTxfInfo.entrySet()) {
			convertToWebElement(addPaymentTxf, keyValue.getKey()).sendKeys(keyValue.getValue());

		}
		submitBtn.click();
	}
	
     /**
      * 
      */
	public void clickOnAddPAymentBtn() {
		addPaymentBtn.click();
	}
	
	/**
	 * 
	 * @param verificationUtility
	 * @return
	 */
	 public boolean verifyAddPaymen(VerificationUtility verificationUtility) {
	    return verificationUtility.tableVerifationData(addPaymentTable, "AddPayment");
		}
	 
}
