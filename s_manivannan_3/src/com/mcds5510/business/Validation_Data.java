package com.mcds5510.business;
public class Validation_Data {
	
	public String check_CardNumber(String cardNumber)
	{
		String cc_type;
		if (cardNumber.length() == 16 && (cardNumber.startsWith("51") || cardNumber.startsWith("52")
				|| cardNumber.startsWith("53") || cardNumber.startsWith("54") || cardNumber.startsWith("55"))) {
			cc_type = "Master Card";
		} else if (cardNumber.length() == 16 && (cardNumber.startsWith("4"))) {
			cc_type = "VISA Card";
		} else if (cardNumber.length() == 15 && (cardNumber.startsWith("34") || cardNumber.startsWith("37"))) {
			cc_type = "AMEX";
		} else {

			return "false";
		}
		return cc_type;
	}

	public String check_exp_date(String check_string) {
		String a_string;
		a_string = check_string;
		String out;
		while (true) {
			String temp[] = a_string.split("/");
			if (temp[0].length() == 2 && temp[1].length() == 4 && !temp[0].matches("[a-zA-Z]+")
					&& temp[0].matches("[0-9]+") && !temp[1].matches("[a-zA-Z]+") && temp[1].matches("[0-9]+")
					&& Integer.parseInt(temp[0]) < 13 && Integer.parseInt(temp[0]) > 0
					&& Integer.parseInt(temp[1]) > 2015 && Integer.parseInt(temp[1]) < 2032) {
				return a_string;
			} else {
				return "false";
			}
		}

	}
}
