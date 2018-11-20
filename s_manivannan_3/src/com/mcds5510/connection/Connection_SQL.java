package com.mcds5510.connection;

import java.sql.*;


public class Connection_SQL {
	
	private static Connection_SQL my_Connect=new Connection_SQL();
	
	private Connection_SQL()
	{
		
	}
	
	public static Connection_SQL getObject()
	{
		return my_Connect;
	}
	
	public Connection getConnection()
	{
		Connection myCon=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/s_manivannan?useSSL=false", "s_manivannan", "A00429112");
			return myCon;
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return myCon;
		
	}
}
