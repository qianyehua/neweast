package com.MedicimeMS.Tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InTime {
    
	
	public boolean isInTime(String time,String mintime,String maxtime){
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
		try {
			Calendar cjgt=Calendar.getInstance();
			Calendar cleft=Calendar.getInstance();
			Calendar cright=Calendar.getInstance();
			cjgt.setTime(sdf.parse(time));
			cleft.setTime(sdf.parse(mintime));
			cright.setTime(sdf.parse(maxtime));
			
			if((cjgt.compareTo(cleft)>=0)&&(cjgt.compareTo(cright)<=0) ){
				return true;
			}
			
			  return false;
		} catch (ParseException e) {
			// TODO ted catch blockAuto-genera
			e.printStackTrace();
			return false;
		}	
    }
}
