package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellDataUse {
 public static String getExcellData(String sheetName,String testCaseName,String key)  throws EncryptedDocumentException, IOException {
		String expTestCasename =testCaseName;

		DataFormatter df = new DataFormatter();
		FileInputStream  fis1=new FileInputStream("./src/test/resources/excellData/TyTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet=wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		Map<String,String> map=new HashMap<>();
		
		for (int i = 1; i <=rowCount; i++) {
			String testScriptName=df.formatCellValue(sheet.getRow(i).getCell(0));
			//System.out.println(testScriptName);
			if(testScriptName.equalsIgnoreCase(expTestCasename)){
				for (int j = 1; j <sheet.getRow(i).getLastCellNum(); j++) {
					String key1=df.formatCellValue(sheet.getRow(i).getCell(j));
					//System.out.println(key1);
					String value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
					//System.out.println(value);	 
					map.put(key1, value);
				}
				break;	
		    	}
			}
		 // System.out.println(map.get("ClientPassword"));
		return map.get(key);	
 }
 public static void main(String[] args) throws EncryptedDocumentException, IOException {
	String data=getExcellData("Client_Nominee_FormData","Client Information","Name");
	System.out.println(data);
}
}



