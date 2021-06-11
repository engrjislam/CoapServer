package com.coap.server.main.utils;

import java.text.SimpleDateFormat; 
import java.util.Date;  


public class CurrentDateTime {
	
	final String dateFormat = "yyyy.MM.dd HH:mm:ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat); 
	
	public String getCurrentDateTime() {
		Date date = new Date();
		return simpleDateFormat.format(date);
	}
	
}
