package com.sms.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Subhadip Ganguly
 *
 */
public class DatabaseUtility
{
	Connection con = null;
	
	/**
	 * This method is used to connect database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.dbUrl,IpathConstants.dbUsername,IpathConstants.dbPassword);
	}
	
	/**
	 * This method is used to execute query and get the data
	 * @param query
	 * @param columnNo
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query,int columnNo,String expectedData) throws SQLException
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String data = result.getString(columnNo);
			if(data.equalsIgnoreCase(expectedData))
			{
				flag = true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("-- Data is verified");
			return expectedData;
		}
		else
		{
			System.out.println("-- Data is not present");
			return "";
		}
	}
	
	/**
	 * This method is used to close the database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
}
