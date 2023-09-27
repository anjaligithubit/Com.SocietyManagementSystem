package genericsUtils;

import java.util.Date;
import java.util.Random;

/**
 * @author Anjali
 */
public class JavaUtility 
{
		
	
	/**
	 * This method is used to get the random number
	 * @return
	 */
	public int getRandomNumber() 
	{
		Random random=new Random();
		int randNum = random.nextInt(1000);
		return randNum;
	}
	/**
	 * This method will return fetch the system date in IST format
	 * @return
	 */
	public String getSystemDate() 
	{
	Date date=new Date();
	return date.toString();
	}
	/**
	 * This method will return date in required format
	 * @return
	 */
	public  String getSystemDateInFormat()
	{
		Date dateWithTime=new Date();
		String[] d = dateWithTime.toString().split(" ");
		String day = d[0];
		String month = d[1];
		String date = d[2];
		String year=d[5];
		String formatDate=day+""+month+""+date+""+year;
		return formatDate;
	}
	}
