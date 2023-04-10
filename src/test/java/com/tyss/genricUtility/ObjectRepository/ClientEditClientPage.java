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

public class ClientEditClientPage {
	WebDriver driver;
	String partialxpathOfEditClients = "//input[@name='%s']";
	public  String partialXpathClientStatus = "//td[contains(.,'%s')]/following-sibling::td[.='Client Status']/a";

	 
	@FindBy(xpath = "//a[normalize-space()='Edit Client']")
	private WebElement editClientLink;
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//tbody/tr/td[2]")
	private List<WebElement> tableName;
	
	@FindBy(xpath = "//a[.='Delete Client']")
	private WebElement deleteClient;
	

	/**
	 * 
	 * @param driver
	 */
	// initialization
	public ClientEditClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement convertToWebElement(String partialxpath, String replaceData) {
		String xpath = String.format(partialxpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	public void clickClientStatusNameBysWithEdit(String nameOfClient) {
		convertToWebElement(partialXpathClientStatus, nameOfClient).click();
		editClientLink.click();
	}
	 

	public void addTextIntoEditClient(Map<String, String> editClientNameText) {
		for (Entry<String, String> keyValue : editClientNameText.entrySet()) {
			WebElement e = convertToWebElement(partialxpathOfEditClients, keyValue.getKey());
			e.clear();
			e.sendKeys(keyValue.getValue());
		}
		submitButton.click();
	}

	public boolean verifyEditClient(VerificationUtility verificationUtility, String nameOfText) {
		return verificationUtility.tableVerifationData(tableName, nameOfText);
	}
	public void clickOnDeleteClient() {
		deleteClient.click();
	}
	
	
//   public static void main(String[] args) {
//	   String xpath = String.format(partialXpathClientStatus,"Priyanka");
//	   System.out.println(xpath);
//  }
}
