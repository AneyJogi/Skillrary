package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con= null;
	/**
	 * This method is used to get connection to data base
	 * @throws Throwable
	 * @author alwin
	 */
	public void connectToDb() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstants.DBURL,IPathConstants.DBUSERNAME,IPathConstants.DBPASSWORD);
	}

	public String executeQueryAndGetData(String query,String expData,int columnIndex) throws Throwable
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag= false;
		while(result.next())
		{
			String data=result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("Data is verified");
			return expData ;
		}
		else
		{
			System.out.println("Data is not verfied");
			return "";
		}
		
		
		
	}
	public void closeDB() throws Throwable
	{
		con.close();
		System.out.println("Database connection closed");
	}
}
