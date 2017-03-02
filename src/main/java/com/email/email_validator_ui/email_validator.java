package com.email.email_validator_ui;

public class email_validator {
	public boolean email_validator(String email) {
		//if the email matches any of these criteria, it will return true
		if (email.matches("[^@]*@[^@]*") && email.matches(".*[.].*") && email.matches(".*[.]+((com)|(ca))") && email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			return true;
		}
		//false if not true
		else {
			return false;
		}
	}//end of boolean
}//end of class
