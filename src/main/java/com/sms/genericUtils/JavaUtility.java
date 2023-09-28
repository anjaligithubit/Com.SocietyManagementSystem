package com.sms.genericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consist of java related methods
 * @author Subhadip Ganguly
 *
 */
public class JavaUtility 
{
	/**
	 * This method is used to get random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int randNum = ran.nextInt();
		return randNum;
	}
	
	/**
	 * This method will fetch system date in IST format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		return d.toString();
	}
	
	
	/**
	 * This method is used to fetch system date in required format
	 * @return
	 */
	public String getSystemDateInRequiredFormat()
	{
		Date date_time= new Date();
		String[] d = date_time.toString().split(" ");
		
		String day = d[0];
		String month = d[1];
		String date = d[2];
		String year = d[5];
		
		String finalFormat = day+" "+month+" "+date+" "+year;
		return finalFormat;
	}
	
	/**
	 * This method is used to get system date in format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yy hh-mm-ss");
		Date d = new Date();
		String systemDateInFormat = dateformat.format(d);
		return systemDateInFormat;
	}
	
}
