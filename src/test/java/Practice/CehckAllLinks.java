package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CehckAllLinks {
	 @Test
	 public void test() throws IOException {
		 
	 
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.get("https://demowebshop.tricentis.com/");
	   List<WebElement> linkList = driver.findElements(By.xpath("//a"));
	   List<String> listUrl=new ArrayList<>();
	   List<String> brokenUrl=new ArrayList<>();
	  for(WebElement ele: linkList) {
		  System.out.println(ele.getAttribute("href"));
		  listUrl.add(ele.getAttribute("href"));
	  }
	  for(String u : listUrl) {
		  try {
			URL url=new URL(u);
			URLConnection urlCOnnection = url.openConnection();
			HttpURLConnection httpUrlConnection=(HttpURLConnection)urlCOnnection;
			int statusCode=httpUrlConnection.getResponseCode();
			String statusMasg=httpUrlConnection.getResponseMessage();
			if(statusCode==200) {
				brokenUrl.add(u+statusMasg);
				
			}
			
		} catch (MalformedURLException e) {
			 brokenUrl.add(u+"====> no masg");
		}
		  
	  }
	  System.out.println(linkList.size());
	 
	 
	 }
}
