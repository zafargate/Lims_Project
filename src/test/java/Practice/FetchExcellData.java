package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

 

public class FetchExcellData {
	
	 

	 

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		DataFormatter df=new DataFormatter();
		
		//Step1 
		FileInputStream  fis=new FileInputStream("./src/test/resources/commonData/TyTestData.xlsx");
		
		//step2
	 
		Workbook workbook = WorkbookFactory.create(fis);
		
		//step3
		Sheet sheet = workbook.getSheet("sheet1");
		//step4
		Row row = sheet.getRow(3);
		
	    //step 5
		Cell cell = row.getCell(1);
		//step 6
		String data = cell.toString();
		String data1=df.formatCellValue(cell);
		//step 7
	
		System.out.println(data1);
		
	}

}
