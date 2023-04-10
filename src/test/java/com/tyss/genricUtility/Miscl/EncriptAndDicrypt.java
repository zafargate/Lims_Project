package com.tyss.genricUtility.Miscl;

import java.util.Base64;

public class EncriptAndDicrypt {
	
	public static void main(String[] args) {
		String EncriptData="admin";
		byte[] byteA=EncriptData.getBytes();
		byte[] byteB=Base64.getDecoder().decode(byteA);
		String s= new String(byteB);
		System.out.println(s);
	}

}
