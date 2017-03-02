package com.email.email_validator_ui;

public class email_validator {
	public boolean email_validator(String email) {
		//setting to true
		boolean validation = true;
		int count = 0;
		for (int i = 0; i < email.length(); i++) {
			//to make sure the email has a @ sign
			if (email.charAt(i) == '@'); {
				count++;
			}
		}
		if (count != 1) {
			validation = false;
		}
		//to check for a . in the email
		if (!email.contains(".")) {
			validation = false;
		}
		//if the length is less than 10
		if (email.length() < 10) {
			validation = false;
		}
		//if the email does not contain the domain names
		if (!email.contains("gmail") || !email.contains("yahoo") || !email.contains("dal") || !email.contains("hotmail")) {
			validation = false;
		}
		return validation;
	}//end of boolean
}//end of class
