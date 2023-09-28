package com.sms.genericUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consist of methods to fetch common data from property file
 * @author Subhadip Ganguly
 *
 */
public class FileUtility 
{
	/**
	 * This method is used to fetch common data present inside the property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
