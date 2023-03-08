package com.tyss.genricUtility.Miscl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author khanz
 *
 */
public class ClenederUtility {
 
	/**
	 * 
	 * @return
	 */
	 public String getSystemDateAndTime() {
		 Date date=new Date();
		 return date.toString();
	 }
	 
	 /**
	  * 
	  * @return
	  */
	 public String getSystemDateWaitFormate() {
		 Date date=new Date();
		 String dateAndTime=date.toString();
		 System.out.println(dateAndTime);
		 
		 String YYYY=dateAndTime.split(" ")[5];
		 String DD=dateAndTime.split(" ")[2];
		 String MM=dateAndTime.split(" ")[1];
		 
		 String finalFormate=YYYY+"-"+MM+"-"+DD;
		 return finalFormate;
	 }
	 
	 /**
	  * 
	  * @return
	  */
	 
	 public String getSimpleDateFormate(String datePattern) {
		 SimpleDateFormat sdf=new SimpleDateFormat(datePattern);
		 String date=sdf.format(new Date());
		 return date;
	 }
	 
	 /**
	  * 
	  * @param date
	  * @return
	  * @throws ParseException
	  */
	 public String getCustemizeDate(String date,int variableDate)   {
		 SimpleDateFormat sdf=new SimpleDateFormat("dd_MMM_YYY");
		 Calendar cal = Calendar.getInstance();
		 try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cal.add(Calendar.DAY_OF_MONTH, variableDate);
		 String custDate=sdf.format(cal.getTime());
		 return custDate;
	 }
	 
	 
	 /**
	  * 
	  * @param args
	  */
	 public static void main(String[] args) {
		 ClenederUtility c=new ClenederUtility();
		System.out.println( c.getCustemizeDate("01_May_2023",-10));
	}
	 
	 
}
