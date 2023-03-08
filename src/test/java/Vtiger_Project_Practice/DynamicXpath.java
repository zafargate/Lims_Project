package Vtiger_Project_Practice;

public class DynamicXpath {
	public static void main(String[] args) {
		
	//This is replace by Only String Type
	String tabXpath="xyz";
	String xpath=tabXpath.replace("xyz","Organization");
	System.out.println(xpath);
	
	//This is used for the Replace Integer Type as well as String Type 
	String partialXpath="//a[.='%s']";
	String x= String.format(partialXpath, "Organization");
	System.out.println(x);	
	}
}
