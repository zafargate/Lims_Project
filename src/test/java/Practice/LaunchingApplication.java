package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingApplication {
  
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
    driver.get("http://rmgtestingserver:8888/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
    //validating Login Page
    
    String loginURL=driver.getCurrentUrl();
    if(loginURL.equals("http://rmgtestingserver:8888/"))
        System.out.println("Login page is open sucessfully");
    else
        System.out.println("login page is not open");


    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@id='submitButton']")).click();

    //Validating HomePage
    
    String homepageUrl=driver.getCurrentUrl();
    if(homepageUrl.equals("http://rmgtestingserver:8888/index.php?action=index&module=Home"))
    System.out.println("Home page is opened sucessfully");
    else
    System.out.println("home page is not open ");
  
    
    driver.findElement(By.xpath("//a[contains(text(),'Organizations')]")).click();
    driver.findElement(By.xpath("//img[contains(@alt,'Create Organization...')]")).clear();
	
	driver.close();
	
}
}
