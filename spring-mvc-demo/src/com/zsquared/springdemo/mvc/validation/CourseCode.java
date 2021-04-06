package com.zsquared.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//Definition of default Course Code
	public String value() default "CSC";
	
	//Definition of default error message
	public String message() default "must start with CSC";
	
	// Defintion of default groups
	public Class<?>[] groups() default{};
	
	// definition of default payloads
	public Class<? extends Payload>[] payload() default {};

}
