package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellDataFetchDailyBasis {
	
	
	 public static void getExcellData(String key,String sheetName) throws EncryptedDocumentException, IOException {
		String expTestCasename ="AddClient information";

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
					System.out.println(key1);
					String value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
					System.out.println(value);	 
					map.put(key1, value);
				}
				break;	
		    	}
			}
		
		//System.out.println(map);
		//return map.get("Client password");	
		 
	}
	 public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 
		 getExcellData( "Name", "Client_Nominee_FormData");
	}

}

