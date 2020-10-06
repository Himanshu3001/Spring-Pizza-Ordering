package com.himanshu.ecom.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailValidater.class)
public @interface Email {
	

	String message() default  "{*invalid email}";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
