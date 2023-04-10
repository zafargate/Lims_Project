package com.tyss.genricUtility.ExtarnalUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.tyss.genricUtility.Enum.JDBCPropertyKey;
import com.tyss.genricUtility.Enum.PropertyKey;

/**
 * This class contain reusable method for Property file
 * @author khanz
 *
 */
public class PropertyUtility {
	private Properties prop;
	
	/**
	 * This is costructer will initialise the propertyFile
	 * @param 
	 * @throws IOException 
	 */
	 public PropertyUtility(String filePath) throws IOException {
		 FileInputStream fisProperty=new FileInputStream(filePath);
		 prop = new Properties();
		 prop.load(fisProperty);
		 fisProperty.close();
	 }
	 
	 /**
	  * This Constructer used for create object for class
	  */
	 public PropertyUtility() {}
	 
	 /**
	  * This method used iontialise the propertyFile
	  * @param filePath
	 * @throws IOException 
	  */
	 @Deprecated
	 public void initializePropertyFile(String filePath) throws IOException {
		 FileInputStream fisProperty = new FileInputStream(filePath);
		 prop = new Properties();
		 prop.load(fisProperty);
		 fisProperty.close();
	 }
	 
	 /**
	  * 
	  * @param key
	  * @return
	  */
	 
	 public String getPropertyData(PropertyKey key) {
		 String keyString = key.name().toLowerCase();
		 String value=prop.getProperty(keyString,"please give proper key '"+keyString+"'");		 
		return value;		 
	 }
	 
	 /**
	  *
	  * @param key
	  * @return
	  */
	 public String getPropertyDataJDBC(JDBCPropertyKey key) {
		 String keyString = key.name().toLowerCase();
		 String value=prop.getProperty(keyString,"please give proper key '"+keyString+"'");
		 
		return value;
		 
	 }
	 
	 

}
