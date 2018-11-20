package com.mcds5510.business;

import com.mcds5510.SQL_State.MySQL_Access;
import com.mcds5510.transaction.*;

public class Delete_ID {
	private static Delete_ID delete=new Delete_ID();
	MySQL_Access mysql=MySQL_Access.getObject();
	private Delete_ID()
	{
		
	}

	public static Delete_ID getObject()
	{
		return delete;
	}

	public boolean deleteTransaction(Transaction_Data trans_Delete) 
	{
		
		boolean result = mysql.removeFromDatabase(trans_Delete);
		if (result==true)
			return true;
		else 
			return false;
	}
	
}
