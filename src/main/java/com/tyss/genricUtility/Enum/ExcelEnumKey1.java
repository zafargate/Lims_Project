package com.tyss.genricUtility.Enum;
/**
 * This enum class Contains excellsheet name of mixed test case
 * ORGANIZATION("Client_Nominee_FormData"),ADDNOMINEE("AddNominee_Key_Value"),
 * CLIENTADDPAYMENT("Client_Add_Payment") ADDNOMINEEXPATH("LIMSPartialXpath") 
 * CELENDERTEST("CelenderTest") JDBC("JDBC_DATA")
 * @author khanz
 *
 */
public enum ExcelEnumKey1 {
   
	ORGANIZATION("Client_Nominee_FormData"),
	ADDNOMINEE("AddNominee_Key_Value"),
	CLIENTADDPAYMENT("Client_Add_Payment"), 
	ADDNOMINEEXPATH("LIMSPartialXpath"),
	CELENDERTEST("CelenderTest"),
	
	
	JDBC("JDBC_DATA"); 
	 
	  
	
	String sheetName;
	String testCaseName;
	
	private ExcelEnumKey1(String key) {
		this.sheetName=key;
		this.testCaseName=key;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSheetName() {
		return sheetName;
	}
	public String getTcName() {
		return testCaseName;
	}
 
	public static void main(String[] args) {
		System.out.println(ExcelEnumKey1.CLIENTADDPAYMENT.getSheetName());
	}
	
}
