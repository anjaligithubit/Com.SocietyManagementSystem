package genericsUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 
{
Connection con=null;
/**
 * This method is used to connect database
 * @throws SQLException
 */
public void  connectToDB() throws SQLException
{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con=DriverManager.getConnection(IPathConstants.dbUrl,IPathConstants.dbUsername,IPathConstants.dbPassword);
}
/**
 * This method is used to execute query and get the data
 * @param query
 * @param colNum
 * @param expData
 * @return
 * @throws Throwable
 */
public String executeAndGetData(String query,int colNum,String expData) throws Throwable 
{
	ResultSet result = con.createStatement().executeQuery(query);
	boolean flag=false;
	while(result.next()) 
	{
	String data = result.getString(colNum);
	if(data.contains(expData)) 
	{
		flag=true;
		break;
	}
	}
	if(flag==true) 
	{
		System.out.println("data is present");
		return expData;
	}
	else
	{
		System.out.println("data is not");
		return " ";
	}
	
}
/**
 * This method is used to close database connection
 * @throws Throwable
 */
public void closeDB() throws Throwable 
{
	con.close();
}
}
