package com.clinicmanagement.Utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateToDay {

	public static String getDayfromdate(String date){
		
		String finalDay=null;
		  SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
		  Date dt1;
		try {
			dt1 = format1.parse(date);
			DateFormat format2=new SimpleDateFormat("EEEE"); 
			 finalDay=format2.format(dt1);
			 System.out.println(finalDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return finalDay;
	}
	
}
