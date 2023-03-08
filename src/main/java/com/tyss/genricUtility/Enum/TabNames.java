package com.tyss.genricUtility.Enum;

public enum TabNames {
	
	CONTACTS("Contacts"),
	ORGANIZATION("Organization"),
	DASHBOARD("zafar"),
	PRODUCTS("Products"),
	EMAIL("Emails"),
	LEADS("Leads");
	
	private String tabName;
	
	private TabNames(String tabName) {
		this.tabName=tabName;
	}
	
      public String getTab() {
    	  return tabName;
      }
}
