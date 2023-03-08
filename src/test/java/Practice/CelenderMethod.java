package Practice;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CelenderMethod {
	 public static void main(String[] args) throws InterruptedException {
	        String reqMonth="April";
	        String reqYear="2022";
	        String reqDate="15";

	        int reqMonthNum= DateTimeFormatter.ofPattern("MMMM")
	                .withLocale(Locale.ENGLISH)
	                .parse(reqMonth)
	                .get(ChronoField.MONTH_OF_YEAR);

	        int reqYearNum=Integer.parseInt(reqYear);
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("http://rmgtestingserver:8888/");
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	        WebDriverWait wait=new WebDriverWait(driver,10);
	        
	        driver.findElement(By.name("user_name")).sendKeys("admin");
	        driver.findElement(By.name("user_password")).sendKeys("admin");
	        driver.findElement(By.id("submitButton")).click();

	        driver.findElement(By.linkText("Organizations")).click();
	        driver.findElement(By.xpath("//img[contains(@title,'Open Calendar...')]")).click();
	        //click on clender icon/widget
//	        Thread.sleep(3000);
//	        WebDriverWait wait1=new WebDriverWait(driver, 10);
//	        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='status']")));
	        WebElement ele=driver.findElement(By.xpath("//td[@class='calHdr']/a/b"));
	        //fetch current month and tyear
	        wait.until(ExpectedConditions.visibilityOf(ele));
	        String currMothYear=ele.getText();
	        System.out.println(currMothYear);
	        //Store Month and year Saprate
	        String currMonth=currMothYear.split(" ")[0];
	        String currYear=currMothYear.split(" ")[1];

	        //jaunary month ---->MMMM 01------>,mm,yyyy,DD,sss,MMM

	        int curMonthNum=DateTimeFormatter.ofPattern("MMMM")
	                .withLocale(Locale.ENGLISH)
	                .parse(reqMonth)
	                .get(ChronoField.MONTH_OF_YEAR);

	        //Verify with required month and year and click on n ext
	        while(!(reqMonth.equals(currMonth)||reqYearNum==0))
	        {
	            driver.findElement(By.xpath("//img[@src='themes/images/small_right.gif']")).click();
	            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//td[@class='calHdr']/a/b"),currMothYear));
	            currMonth = currMothYear.split(" ")[0];
	            currYear=currMothYear.split(" ")[1];
	            
	            System.out.println(currMonth);
	        }
	        
	        while(!(reqMonth.equals(currMonth)||(reqYear.equals(currYear))))
	        {
	            driver.findElement(By.xpath("//img[@src='themes/images/small_right.gif']")).click();
	            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//td[@class='calHdr']/a/b"),currMothYear));
	            currMonth = currMothYear.split(" ")[0];
	            currYear=currMothYear.split(" ")[1];
	            
	            System.out.println(currMonth);
	        }


	        // click on Date
	        driver.findElement(By.xpath("//a[contains(@href,'view=day') and text()='"+reqMonth+"']")).click();


	    }

}
