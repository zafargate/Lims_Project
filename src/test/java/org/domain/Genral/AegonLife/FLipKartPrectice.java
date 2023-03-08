package org.domain.Genral.AegonLife;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FLipKartPrectice {

	static {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {

		// 1. Open the Browser
		WebDriver driver = new ChromeDriver();

		// 2. Enter the Url
		driver.get(
				"https://www.flipkart.com/search?q=laptop&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=off&as=off");
		driver.findElement(By.name("q")).sendKeys("laptop");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		List<WebElement> allPrice = driver.findElements(By.xpath(
				"//div[@class='_4rR01T']/parent::div[@class='col col-7-12']/following::div[@class='col col-5-12 nlI3QM']//div[@class='_30jeq3 _1_WHN1']"));

		for (WebElement ele : allPrice) {

			String price = ele.getText();

//            String price1 = price.substring(1);
//            String price2 = price1.replace(",", "");

			// System.out.println(price2);
			String modifiedprice = price.replaceAll("([₹,])", "");
			// System.out.println(modifiedprice);
			// System.out.println(price);
			if (Integer.parseInt(modifiedprice) > 30000 && Integer.parseInt(modifiedprice) <= 40000) {
				System.out.println(modifiedprice);
			}

		}
		driver.close();
	}

}
