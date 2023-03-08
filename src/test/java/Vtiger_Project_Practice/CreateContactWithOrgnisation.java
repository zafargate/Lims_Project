package Vtiger_Project_Practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrgnisation {

	
	public static void main(String[] args) {
		
		
		String expOrgname="Sdet46_"+new Random().nextInt(1000);
		String expContactName="Sdet46_"+new Random().nextInt();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Actions act=new Actions(driver);
	   
	    //validating Login Page
	    driver.get("http://rmgtestingserver:8888/");
	    String loginURL=driver.getCurrentUrl();
	    if(loginURL.equals("http://rmgtestingserver:8888/"))
	    {
	        System.out.println("Login page is open sucessfully");
	    }
	    else {
	        System.out.println("login page is not open");
	        System.exit(0);
	    }
	    
	  //Login To tghe app
	    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@id='submitButton']")).click();

	   
	    //Validating HomePage
	    if(driver.getCurrentUrl().contains("Home"))
	    System.out.println("Home page is Displayed");
	    else
	    System.out.println("home page is not  Displayed");
	  
	    
	    driver.findElement(By.xpath("//a[contains(text(),'Organizations')]")).click();
	    //Validating Organizations Page
	    if(driver.getCurrentUrl().contains("organizations"))
	    {
	    	System.out.println("Organization page is displayed ");
	    }
	    else
	    {
	    	System.out.println("Orgnization Page is Not Displayed");
	    }
	    
	    //Validating Create new Organization Page 
	    driver.findElement(By.xpath("//img[contains(@alt,'Create Organization...')]")).click();
	    
	    String actCreateOrgPage= driver.findElement(By.xpath("//span[text()='Creating New Organization']")).getText();
	    if(actCreateOrgPage.equals("Organization Information"))
	    {
	    	System.out.println("Create New Organization page is displayed");
	    }
	    else
	    {
	    	System.out.println("Create page is not displayed");
	    }
	    
	    //Organization form
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expOrgname);
	    WebElement industryEle=driver.findElement(By.xpath("//select[@name='industry']"));
	    
	   Select inDD=new Select(industryEle);
	   inDD.selectByValue("Education");
	   
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   
	   
	   //Handling Alert
	   
	   try {
		   Alert alert = driver.switchTo().alert();
		   alert.accept();
		   System.out.println("GivenmOrganization is alredy Exist");
		   expOrgname=expOrgname+new Random().nextInt(100);
		   driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expOrgname);
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   }
	   catch(Exception e)
	   {
		   System.out.println("Given Orgnanization is not exist");
	   }
	   
	  // Verify the organization
	   
	   String actOrgName=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	   String  actIndustry=driver.findElement(By.xpath("//td[@id='mouseArea_Industry']")).getText();
	   
	   if(actOrgName.endsWith(expOrgname))
	   {
		   if(actIndustry.equals("Education"))
		   {
			   System.out.println("Bothj Organization and industry are showing");
		   }
		   else
		   {
			   System.out.println("only organization is Sowing");
		   }
	   }
	   else
	   {
		   System.out.println("Both are Not Showing");
	   }
	   
	   
	   //Create Contact
	   
	   driver.findElement(By.xpath("//a[.='Contacts']")).click();
 
	   // verify the contact page
	   driver.findElement(By.xpath("//img[contains(@title,'Create Contact')]")).click();
	   
	   //verify create contact page
	   driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(expContactName);
	   
	   
	    
	    
	   
		
		//driver.close();
		
	}
}
