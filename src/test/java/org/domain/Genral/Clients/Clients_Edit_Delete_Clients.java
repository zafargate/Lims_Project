package org.domain.Genral.Clients;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clients_Edit_Delete_Clients
{
     
    public static void main(String[] args) throws InterruptedException {

        // 1. Open the Browser
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //  2. Enter the Url
        driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/index.php");

        //confirmation login page
        String crrnt_url = driver.getCurrentUrl();
        if (crrnt_url.equals("http://rmgtestingserver/domain/Life_Insurance_Management_System/index.php")) {
            System.out.println("login page is open sucessfully");
        } else {
            System.out.println("login page is not opend");
        }
        //3.Enter ussername and passwotrd
        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("555");
        driver.findElement(By.xpath("(//input[@placeholder='password'])[1]")).sendKeys("666");

        // 4. click on login button
        driver.findElement(By.xpath("//button[normalize-space()='login']")).click();

        // confirmation of homepage
        String home_text = driver.findElement(By.xpath("//div[@class='inner-text']")).getText();
        System.out.println(home_text);
        if (home_text.equals("welcome, 555")) {
            System.out.println("Home Page is Open");
        } else {
            System.out.println("home Page Is Not Open");
        }
        // Thread.sleep(3000);

        //click on clients module
        driver.findElement(By.xpath("//a[normalize-space()='CLIENTS']")).click();

        // clients module confirmation page
        String client_page_url = driver.getCurrentUrl();

        if (client_page_url.equals("http://rmgtestingserver/domain/Life_Insurance_Management_System/client.php")) {
            System.out.println("client page is opened sucessfully");
        } else {
            System.out.println("clients page  not Open");
        }

        JavascriptExecutor j= (JavascriptExecutor)driver;
        j.executeScript("window.scrollBy(document.body.scrollWidth,0)");

        //driver.findElement(By.xpath(""))
    }
}
