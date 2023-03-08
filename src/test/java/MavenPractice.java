import org.testng.annotations.Test;

public class MavenPractice {
    
	@Test
	void test1() {
		String url=System.getProperty("url");
		System.out.println(url);
		
	}
}
