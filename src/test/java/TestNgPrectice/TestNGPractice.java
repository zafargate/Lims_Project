package TestNgPrectice;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPractice {

	@BeforeSuite
	void beforSuit() {
	 
		System.out.println("beforSuit");
	}
     
	@BeforeTest
	void beforeTest() {
		System.out.println("beforeTest");
	}
	 
//	@org.testng.annotations.BeforeClass 
//	void beforClass() {
//		System.out.println("beforClass");
//	}
//	
	@BeforeMethod 
	void beforMehtod() {
		System.out.println("beforMehtod");
	}
	
	@Test
	void test() {
		System.out.println("test");
	}
	
	@AfterSuite
	void afterSuit() {
	 
		System.out.println("afterSuit");
	}
     
	@AfterTest
	void afterTest() {
		System.out.println("afterTest");
	}
	 
//	@org.testng.annotations.AfterClass 
//	void afterClass() {
//		System.out.println("afterClass");
//	}
	
	@AfterMethod 
	void afterMehtod() {
		System.out.println("afterMehtod");
	}
	 

	 
}
