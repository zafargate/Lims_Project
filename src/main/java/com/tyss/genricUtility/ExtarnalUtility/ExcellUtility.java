package com.tyss.genricUtility.ExtarnalUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 

/**
 * This Class contains constructer ExcellUtility(String filename) we can fatch
 * data in map form and string form and direct row and column wise get the date
 * and set data row and column wise
 * 
 * @author khan zafar
 *
 */
public class ExcellUtility {

	DataFormatter df;
	Workbook wb;
	FileInputStream fis;

	/**
	 * This Constructore call implicitly intiallize(filename);
	 * And This method is initiallise DataFormatter, FIS, WbFectory.create
	 * @param filename
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 */
	public ExcellUtility(String filename) throws EncryptedDocumentException, IOException {
		intiallize(filename);
	}

	/**
	 * This method is initiallise DataFormatter, FIS, WbFectory.create
	 * @param fileName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	private void intiallize(String fileName) throws EncryptedDocumentException, IOException {
		df = new DataFormatter();
		fis = new FileInputStream(fileName);
		wb = WorkbookFactory.create(fis);
	}

	/**
	 * This method is used to get Excel Data in the String format By Expected Key
	 * getExcellData(String SheetName, String expTestCaseName, String expectedKey)
	 * @param SheetName
	 * @param expectedTestCaseName
	 * @param expectedKey
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String getExcellData(String SheetName, String expTestCaseName, String expectedKey) {
		Sheet sheet = wb.getSheet(SheetName);
		int rowCount = sheet.getLastRowNum(); // index
		Map<String, String> map = new HashMap<>();
		String value = "";
		int testScriptCounter = 0;
		int keyCounter = 0;
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));			 
			if (testScriptName.equalsIgnoreCase(expTestCaseName)) {
				testScriptCounter++;
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));				 
					if (key.equalsIgnoreCase(expectedKey)) {
						keyCounter++;
						value = df.formatCellValue(sheet.getRow(i + 1).getCell(j));					 
						map.put(key, value);
						break;
					}

				}
				break;
			}

		}
		if (keyCounter == 0) {
			if (testScriptCounter == 0) {
				value = "please give proper testSCript Key '" + expTestCaseName + "'";
			} else {
				value = "please give proper testscript key '" + expectedKey + "'";
			}

		}
		System.out.println("Value fetch from Excell ===> " + value);
		return value;
	}

	/**
	 * This Method used To fetch excel data into Return into map Format
	 *  Map<String,String> getExcelData(String sheetName, String expTestCaseName)
	 * @param sheetName
	 * @param expTestCaseName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Map<String, String> getExcelData(String sheetName, String expTestCaseName) {
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum(); // index
		Map<String, String> map = new HashMap<>();

		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			// System.out.println(testScriptName);
			if (testScriptName.equalsIgnoreCase(expTestCaseName)) {

				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {

					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					// System.out.println(key);

					String value = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
					// System.out.println(value);
					if (key.equals(""))
						break;
					map.put(key, value);
				}
				break;
			}

		}

		return map;
	}

	/**
	 * This Method is Used To Get Excel value in String 
	 * getData(String sheetName, int rowCount, int cellIndex) 
	 * @param sheetName
	 * @param rowCount
	 * @param cellIndex
	 * @return
	 */
	public String getData(String sheetName, int rowCount, int cellIndex) {
		String value = df.formatCellValue(wb.getSheet(sheetName).getRow(rowCount).getCell(cellIndex));
		return value;
	}

	/**
	 * This method is used To Close The WorkBook
	 * @throws IOException
	 */
	public void close() throws IOException {
		wb.close();
	}

	/**
	 * This Method Is To Set the value in Excel Sheet
	 * setData(String sheeetName, int rowIndex, int cellIndex)
	 * @param sheeetName
	 * @param rowIndex
	 * @param cellIndex
	 */
	public void setData(String sheeetName, int rowIndex, int cellIndex) {
		wb.getSheet(sheeetName).getRow(rowIndex).createCell(cellIndex);
	}

	/**
	 *This method used to fetch the data in 2d array
	 *Specially for DataProvider annotation
	 * getData(String sheetName)
	 * @param sheetName
	 * @return
	 */
	public String[][] getData(String sheetName) {
		Sheet sheet = wb.getSheet(sheetName);
		String data[][] = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {

				data[i - 1][j] = df.formatCellValue(sheet.getRow(i).getCell(j));

			}

		}
		return data;
	}

	/**
	 * This method is Used Save the Write The Data
	 * saveData(String fileOutputPath)
	 * @param fileOutputPath
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void saveData(String fileOutputPath) throws FileNotFoundException, IOException {
		wb.write(new FileOutputStream(fileOutputPath));
	}

//	public static void main(String[] args) throws FileNotFoundException, IOException {
//		ExcellUtility ex = new ExcellUtility(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
//		// ex.setData(, 0, 0);
//		ex.saveData(FrameWorkConstatnt.TEST_EXCELL_FILE_PATH);
//
//	}

}
