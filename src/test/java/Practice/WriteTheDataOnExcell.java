package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteTheDataOnExcell {
	
	public static void main(String[] args) throws IOException {
		
	
	
	        //Step1 
			FileInputStream  fis=new FileInputStream("./src/test/resources/commonData/TyTestData.xlsx");
			
			//step2
		 
			Workbook workbook = WorkbookFactory.create(fis);
			
			//step3
			Sheet sheet = workbook.getSheet("sheet3");
			
		    Row row = sheet.getRow(1);
		    Cell cell= row.createCell(1);
		    
		    cell.setCellValue("tc_004");
		    FileOutputStream fos=new FileOutputStream("./src/test/resources/commonData/TyTestData.xlsx");
		    
		    workbook.write(fos);
		    fos.close();
			
			
	}
}
