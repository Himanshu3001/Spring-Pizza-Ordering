package com.himanshu.ecom.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidater implements ConstraintValidator<Email, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		System.out.print("Value is:" + value);
		
		if(value.equals(null))
		{
			return false;
		}
		
		return true;
	}

	
	
}
