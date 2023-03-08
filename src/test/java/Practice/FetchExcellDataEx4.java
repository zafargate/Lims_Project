package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcellDataEx4 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		String expTestScriptName = "SelectOrganizationListTest";
		String expKey = "ColumnName";
		

		DataFormatter df = new DataFormatter();

		// Step1
		FileInputStream fis = new FileInputStream("./src/test/resources/excellData/TyTestData.xlsx");

		// step2

		Workbook workbook = WorkbookFactory.create(fis);

		// step3
		Sheet sheet = workbook.getSheet("AddFacebookForm");
		// step4
		int rownum = sheet.getLastRowNum();

		// step 5
		int cellnum = sheet.getRow(1).getLastCellNum();
		// step 6
	
		
		//String[] value=null;
		List<String> dataList=new ArrayList<>();
		
//		
//		for (int i = 1; i <= rownum; i++) {
//			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
//			// System.out.println(testScriptName);
//
//			if (testScriptName.equalsIgnoreCase(expTestScriptName)) {
//				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
//
//					// System.out.print(df.formatCellValue(sheet.getRow(i).getCell(j)) + " ");
//					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
//					if (key.equalsIgnoreCase(expKey)) {
//						int count=0;
//						for(int k=i+1; ; k++)
//						{
//							String data = df.formatCellValue(sheet.getRow(k).getCell(j));
//							//System.out.println(data);
//							dataList.add(data);
//							
//							if(data.equals("")) 
//							{
//                                break;
//						    }else {
//							
//								count++;
//							}
//						}
//						
//						System.out.println(count);
//				       //value=new String[count];
//						
////						for(int k=0; k<count; k++)
////						{
////							value[k]= df.formatCellValue(sheet.getRow(i+1+k).getCell(j));
////						}
//						
//						for(int p=0; p<count; p++)
//						{
//							System.out.println(dataList.get(p));
//						}
//						
//					}
//					
//				}
//				break;
//			}
//
//		}
//		
//		
//		//System.out.println(value);
//
//	}
		
		String exTc="AddFacebooForm";
		String eKey="sex";
		
		Map<String,String> map=new HashMap<>();
		
		for(int i=0; i<sheet.getLastRowNum();i++) {
			String tcName=df.formatCellValue(sheet.getRow(i).getCell(0));
			//System.out.println(tcName);
			if(exTc.equalsIgnoreCase(tcName)) {
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String aKey=df.formatCellValue(sheet.getRow(i).getCell(j));
					//System.out.println(aKey);
							String value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
							//System.out.println(value);
							map.put(aKey, value);
							if(value.equals("")) {
							break;
							}
						}
					}
					
				}
		
		     System.out.println(map.get(eKey));
		
			}

	}


