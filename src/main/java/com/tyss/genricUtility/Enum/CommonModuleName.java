package com.tyss.genricUtility.Enum;

/**
 * This is used for All Common module of Lims project Only witch is used for Dynamic xpath
 * @author khanz
 *
 */
public enum CommonModuleName {
     
	CLIENTS("CLIENTS"),AGENTS("AGENTS"),POLICY("POLICY"),NOMINEE("NOMINEE"),
	PAYMENTS("PAYMENTS");
	 
	
	private String moduleName;
	
	/**
	 * This constructore initiallise to name of module
	 * @param moduleName
	 */
	private CommonModuleName(String moduleName) {
		this.moduleName=moduleName;
	}
	
	/**
	 * This method used to return the common module name
	 * @return
	 */
      public String getModule() {
    	  return moduleName;
      }

	 
}
