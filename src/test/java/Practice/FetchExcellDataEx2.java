package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcellDataEx2 {
	
public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		DataFormatter df=new DataFormatter();
		
		//Step1 
		FileInputStream  fis=new FileInputStream("./src/test/resources/commonData/TyTestData.xlsx");
		
		//step2
	 
		Workbook workbook = WorkbookFactory.create(fis);
		
		//step3
		Sheet sheet = workbook.getSheet("sheet1");
		//step4
		int rownum = sheet.getLastRowNum();
		
	    //step 5
		 int cellnum = sheet.getRow(1).getLastCellNum();
		//step 6
		 
		 for (int i = 1; i <=rownum; i++) {
			 
			for (int j = 0; j <sheet.getRow(i).getLastCellNum(); j++) {
				
				System.out.print(df.formatCellValue(sheet.getRow(i).getCell(j))+" ");
				
			}
			System.out.println();
			
		}
//		String data = cell.toString();
//		String data1=df.formatCellValue(cell);
		//step 7
	
//		System.out.println(data1);
		
	}

  
}
