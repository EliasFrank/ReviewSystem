package com.jxau.myUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorLog {
	
	public static void addErrorLog(Exception e) {

		PrintStream ps = null;

		Date date = new Date();
		String DATE_PATTERN = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		String dateString = sdf.format(date);
		
		try {
			ps = new PrintStream(
				new FileOutputStream("H:\\checkLog\\Errors\\" + dateString + ".log", true));

			e.printStackTrace(ps);	
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}finally {
			if(ps != null) {
				ps.close();
			}
		}	
	}
}
