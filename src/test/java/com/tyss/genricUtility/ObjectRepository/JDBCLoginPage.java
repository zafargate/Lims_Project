package com.tyss.genricUtility.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tyss.genricUtility.Miscl.VerificationUtility;

public class JDBCLoginPage {
	WebDriver driver;
	@FindBy(xpath="//input[@name='username']")
	private WebElement usernameTxf;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement PasswordTxf;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[.='Projects']")
	private WebElement projects;
	
	@FindBy(xpath="//span[.='Create Project']")
	private WebElement createProjectBtn ;
	
	@FindBy(xpath="//input[@name='projectName']")
	private WebElement projectNameTxf;
	
	@FindBy(xpath="//input[@name='createdBy']")
	private WebElement projectManagerTxf;
	
	@FindBy(xpath="//option[.='Select Value' ]/parent::select")
	private WebElement projectStatusDropDown;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement addProject;
	
	@FindBy(xpath="//tbody/tr/td[1]")
	private List<WebElement> projectTable;
	 
	public JDBCLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void loginOfJDBC(String username, String password) {
		usernameTxf.sendKeys(username);
		PasswordTxf.sendKeys(password);
		submitBtn.click();
	}
	 
	public void createProject(String projectName,String managerName,String Value) {
		
		projects.click();
		createProjectBtn.click();
		projectNameTxf.sendKeys(projectName);
		projectManagerTxf.sendKeys(managerName);
		projectStatusDropDown.click();
		Select s=new Select(projectStatusDropDown);
		s.selectByValue(Value);
		addProject.click();
	}
	
	public boolean verifyProject(VerificationUtility verifyUtility,String ProjectName) {
		return verifyUtility.tableVerifationData(projectTable, ProjectName);
	}

}
