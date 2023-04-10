package com.tyss.genricUtility.Enum;

/**
 * This enum class Contains excell Sheetname
 * ADDNOMINEEXPATH("LIMSPartialXpath");
 * @author khanz
 *
 */
public enum AddNomineeXpath {
	
    ADDNOMINEEXPATH("LIMSPartialXpath");
	
	String sheetName;
	
	/**
	 * This constructore used for initiallize to the give excell sheetname 
	 * @param sheetName
	 */
	private AddNomineeXpath(String sheetName) {
		this.sheetName=sheetName;
	}
	
	/**
	 * This method is contains return to given Excellsheetname 
	 * @return
	 */
	public String getSheetName() {
		return sheetName;
	}
 
//	public static void main(String[] args) {
//		System.out.println(ExcelEnumKey1.ORGANIZATION.getSheetName());
//	}
	
}
