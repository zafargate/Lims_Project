package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcellDataEx3 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		String expTestScriptName = "SelectOrgCelenderTest";
		String expKey = "OrgName";
		

		DataFormatter df = new DataFormatter();

		// Step1
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData/TyTestData.xlsx");

		// step2

		Workbook workbook = WorkbookFactory.create(fis);

		// step3
		Sheet sheet = workbook.getSheet("Client_EditClients");
		// step4
		int rownum = sheet.getLastRowNum();

		// step 5
		int cellnum = sheet.getRow(1).getLastCellNum();
		// step 6
		String value = "";
		for (int i = 1; i <= rownum; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			// System.out.println(testScriptName);

			if (testScriptName.equalsIgnoreCase(expTestScriptName)) {
				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {

					// System.out.print(df.formatCellValue(sheet.getRow(i).getCell(j)) + " ");
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if (key.equalsIgnoreCase(expKey)) {
						value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						System.out.println(value);
					 
					}
				}
				break;
			}

		}
		//System.out.println(value);

	}
}
