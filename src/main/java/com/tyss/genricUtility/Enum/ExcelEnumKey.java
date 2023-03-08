package com.tyss.genricUtility.Enum;
/**
 * 
 * @author khanz
 *
 */
public enum ExcelEnumKey {
     
	 ADDFACEBOOK("AddFacebookForm");
		
     String sheetName;
     /**
      * 
      * @param sheetName
      */
  private ExcelEnumKey(String sheetName) {
	   this.sheetName=sheetName;
  }
  /**
   * 
   * @return
   */
  public String getExcellSheet() {
	  return sheetName;
  }
}
