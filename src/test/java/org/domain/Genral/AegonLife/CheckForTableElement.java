 package org.domain.Genral.AegonLife;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CheckForTableElement
{
    static {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
    }



    public static void main(String[] args) throws InterruptedException
    {


            // 1. Open the Browser
        WebDriver driver=new ChromeDriver();
        int row_num=0;

        driver.get("https://money.rediff.com/index.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String rowNum_xpath= "//div[@class='hmnseindicestable']//ul[@class='bold']/parent::div/ul";
        String hadder_xpath=  "//div[@class='hmnseindicestable']//ul[@class='bold']/parent::div/ul/li["+row_num+"]";

        ArrayList<String> col = claculateColWise(driver, rowNum_xpath);
        ArrayList<String> row = claculateColWise(driver, hadder_xpath);

       // System.out.println(col.get(0));
        System.out.println(row.get(0));


        driver.close();
    }


    static ArrayList<String> claculateColWise(  WebDriver driver, String xpath)
    {
        ArrayList<String> list=new ArrayList<String>();
        Scanner sc=new Scanner(System.in);
        List<WebElement> colmnList = driver.findElements(By.xpath(xpath));

        for (WebElement ele:colmnList)
        {
           String text=ele.getText();
              list.add(text);
        }

        return list;
    }




}
