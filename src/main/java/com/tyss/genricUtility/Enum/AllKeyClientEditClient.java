package com.tyss.genricUtility.Enum;
/**
 * This class is used for specially Editclient_Edit_TestCase sheetName,testcaseName,Data,NameOfClient
 * @author khanz
 *
 */
public enum AllKeyClientEditClient {
    
	CLIENTEDITCLIENTSSHEET("ClientEditClients"),
	CLIENTEDITCLIENTSTEST("ClientEditClientsTxft"),
	CLIENTEDITCLIENTSTESTDATA("ClientEditClientsTxftData"),
	NAMEOFCLIENT_PARX("Priyanka");
	
	 
	
	String sheetName;
	String testCaseName;
	String NameOFClient;
	
	private AllKeyClientEditClient(String key) {
		sheetName=key;
		testCaseName=key;
		NameOFClient=key;
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
	public String nameOFClient() {
		return testCaseName;
	}
}
