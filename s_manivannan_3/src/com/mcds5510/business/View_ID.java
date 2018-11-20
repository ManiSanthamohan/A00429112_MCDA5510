package com.mcds5510.business;

import com.mcds5510.SQL_State.MySQL_Access;
import com.mcds5510.transaction.*;

public class View_ID {
	private static View_ID view=new View_ID();
	MySQL_Access mysql=MySQL_Access.getObject();
	private View_ID()
	{
		
	}

	public static View_ID getObject()
	{
		return view;
	}

	public Transaction_Data viewTransaction(Transaction_Data trans_View) 
	{
		
		Transaction_Data trans_Display = mysql.viewFromDatabase(trans_View);
		if (trans_Display!=null)
			return trans_Display;
		else 
			return trans_Display;
	}
	
}
