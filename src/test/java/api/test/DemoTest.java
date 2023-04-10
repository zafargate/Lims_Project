package api.test;

import org.testng.annotations.Test;

import com.tyss.genricUtility.AnnotationClass.Report;
import com.tyss.genricUtility.ConfigerClass.MainClass;

public class DemoTest extends MainClass {
	
	@Report(author = "zafar", assign = { "Mohan" })
	@Test
	public void tes1() {
	System.out.println("test 1");	
	}
	
	@Report(author = "zafar", assign = { "Mohan" })
	@Test
	public void tes2() {
	System.out.println("test 2");	
	}
	
	
	@Report(author = "zafar", assign = { "Mohan" })
	@Test
	public void tes3() {
	System.out.println("test 3");	
	}
	
	@Report(author = "zafar", assign = { "Mohan" })
	@Test
	public void tes4() {
	System.out.println("test 4");	
	}
	
	

}
