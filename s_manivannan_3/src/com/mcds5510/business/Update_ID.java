package com.mcds5510.business;

import com.mcds5510.SQL_State.MySQL_Access;
import com.mcds5510.transaction.*;
public class Update_ID {
	private static Update_ID update=new Update_ID();
	MySQL_Access mysql=MySQL_Access.getObject();
	private Update_ID()
	{
		
	}

	public static Update_ID getObject()
	{
		return update;
	}

	public boolean updateTransaction(Transaction_Data trans_update) 
	{
		
		if (trans_update.getID()==null)
		{
			return false;
		}
		else {
			
			Transaction_Data my_transaction=new Transaction_Data();
			View_ID getUpdate=View_ID.getObject();
			Validation_Data valid_card=new Validation_Data();
			my_transaction=getUpdate.viewTransaction(trans_update);
			if (trans_update.getCardNumber()==null)		
				trans_update.setCardNumber(my_transaction.getCardNumber());
			if (trans_update.getNameOnCard()==null)
				trans_update.setNameOnCard(my_transaction.getNameOnCard());
			if (trans_update.getExpDate()==null)
				trans_update.setExpDate(my_transaction.getExpDate());
			if (trans_update.getQantity()==null)
				trans_update.setQantity(my_transaction.getQantity());
			if (trans_update.getUnitPrice()==null)
				trans_update.setUnitPrice(my_transaction.getUnitPrice());
			trans_update.setCreditCard(valid_card.check_CardNumber(trans_update.getCardNumber()));
			
			float totaltPrice=Float.parseFloat(trans_update.getQantity())*Float.parseFloat(trans_update.getUnitPrice());
			trans_update.setTotaltPrice(String.valueOf(totaltPrice));
			if (trans_update.getCreditCard()=="false")
			{
				return false;
			}
			trans_update.setExpDate(valid_card.check_exp_date(trans_update.getExpDate()));
			if (trans_update.getExpDate()=="false")
			{
				return false;
			}
			
			boolean result = mysql.updateToDatabase(trans_update);
			if (result==true)
				return true;
			else 
				return false;
	}
	}
}
