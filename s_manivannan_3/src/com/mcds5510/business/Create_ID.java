package com.mcds5510.business;

import com.mcds5510.SQL_State.MySQL_Access;
import com.mcds5510.transaction.*;

public class Create_ID {
	private static Create_ID create=new Create_ID();
	MySQL_Access mysql=MySQL_Access.getObject();
	private Create_ID()
	{
		
	}

	public static Create_ID getObject()
	{
		return create;
	}

	public boolean insertTransaction(Transaction_Data trans_create) 
	{
		Validation_Data valid_card=new Validation_Data();
		trans_create.setCreditCard(valid_card.check_CardNumber(trans_create.getCardNumber()));
		if (trans_create.getCreditCard()=="false")
		{
			return false;
		}
		trans_create.setExpDate(valid_card.check_exp_date(trans_create.getExpDate()));
		if (trans_create.getExpDate()=="false")
		{
			return false;
		}
		boolean result = mysql.insertToDatabase(trans_create);
		if (result==true)
			return true;
		else 
			return false;
	}
	
}
