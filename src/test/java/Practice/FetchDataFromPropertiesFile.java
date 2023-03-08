package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/commonData/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String password=p.getProperty("username");
		System.out.println(password);
	
		fis.close();
		
	p.setProperty("", "");
		
	}

}
