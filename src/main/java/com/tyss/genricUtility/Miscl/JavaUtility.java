package com.tyss.genricUtility.Miscl;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * 
	 * @param baundryValue
	 * @return
	 */
	public int getRandomNumber(int baundryValue) {
		return new Random().nextInt(baundryValue);
	}
	
	/**
	 * +
	 * @param output
	 */
	public void consolePrint(Object output) {
      System.out.println(output);
	}
	
	/**
	 * 
	 * @param monthName
	 * @param pettern
	 * @return
	 */
	public int getMonnthNumber(String monthName,String pettern) {
		
		int monthNumber = DateTimeFormatter.ofPattern(pettern.toUpperCase())
				    .withLocale(Locale.ENGLISH)
	                .parse(monthName)
	                .get(ChronoField.MONTH_OF_YEAR);
		           return monthNumber;	 
	}
	
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public int parseNumber(String s) {
		return Integer.parseInt(s);
	}
	
	/**
	 * 
	 * @param s
	 * @param strategy
	 * @return
	 */
	public String[] split(String s,String strategy) {
		return  s.split(strategy);
	}
	
//	/**
//	 * 
//	 * @param s
//	 * @return
//	 */
//	public String decode(String s) {
//		return new String(Base64.getDecoder().decode(s.getBytes()));
//	}
//	
//	/**
//	 * 
//	 * @param s
//	 * @return
//	 */
//	public String encode(String s) {
//		return new String(Base64.getEncoder().encode(s.getBytes()));
//	}

	/**
	 * 
	 * @param datePattern
	 * @return
	 */
	public String getSimpleDateFormate() {
		 SimpleDateFormat sdf=new SimpleDateFormat("DD_MM_YYYY_hh_mm_ss");
		 String date=sdf.format(new Date());
		 return date;
	 }
	
	 

}
